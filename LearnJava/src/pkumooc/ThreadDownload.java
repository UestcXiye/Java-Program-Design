package pkumooc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author liuwenchen
 * @create 2020-07-10 12:39
 */

public class ThreadDownload {
    public static void main(String[] args) throws Exception {
        //String path="http://img.ewebweb.com/uploads/20191006/19/1570360737-HvGOTkxnum.jpg";
        String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588346633185&di=8f8b2b357c8461d232fcce9e0c476f3a&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Fe79d2c22d40a801e7b02183dee9db3e5c71514af.jpg";
        MultiThreadDownload mtd = new MultiThreadDownload(path, "C:\\Users\\81228\\Desktop\\LeiMus.png", 3);
        mtd.download();

    }
}
class MultiThreadDownload {

    private String str_url;
    private String storagePath;
    private int threadNumber;
    private static long downloadByteCount;

    MultiThreadDownload(String str_url, String storagePath, int threadNumber) {
        this.str_url = str_url;
        this.storagePath = storagePath;
        this.threadNumber = threadNumber;
    }

    public void download() throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("Download......");

        /*
         *  首先设置本地文件的大小
         *  当然这是个null数据的文件
         *  这样才能通过RandomAccessFile的数组下标机制达到随机位置写入
         */
        URL url = new URL(str_url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(10000);
        conn.setRequestMethod("GET");
        long fileLength = conn.getContentLengthLong(); // 得到需要下载的文件大小
        conn.disconnect();
        RandomAccessFile file = new RandomAccessFile(storagePath, "rwd");
        file.setLength(fileLength); // 关键方法 ： 设置本地文件长度
        file.close();

        /*
         *  计算每条线程下载的字节数，以及每条线程起始下载位置与结束的下载位置，
         *  因为不一定平均分，所以最后一条线程下载剩余的字节
         *  然后创建线程任务并启动
         *  Main线程等待每条线程结束(join()方法)
         */
        long oneThreadReadByteLength = fileLength / threadNumber;
        for (int i = 0; i < threadNumber; i++) {
            long startPosition = i * oneThreadReadByteLength;
            long endPosition = i == threadNumber - 1 ? fileLength : (i + 1) * oneThreadReadByteLength - 1;
            Thread t = new Thread(new Task(startPosition, endPosition));
            t.start();
            t.join();
        }

        /*
         *  检查文件是否下载完整，不完整则删除
         */
        if (downloadByteCount == fileLength) {
            System.out.println("ALL Thread Download OK.");
            System.out.println("time = " + ((System.currentTimeMillis() - startTime) / 1000) + " S");
        } else {
            System.out.println("Download Error.");
            new File(storagePath).delete();
        }
    }

    class Task implements Runnable {

        private long startPosition;
        private long endPosition;

        Task(long startPosition, long endPosition) {
            this.startPosition = startPosition;
            this.endPosition = endPosition;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(str_url);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Range", "bytes=" + startPosition + "-" + endPosition); // 关键方法: 每条线程请求的字节范围
                if (conn.getResponseCode() == HttpURLConnection.HTTP_PARTIAL) { // 关键响应码 ：206，请求成功 + 请求数据字节范围成功
                    RandomAccessFile file = new RandomAccessFile(storagePath, "rwd");
                    file.seek(startPosition); // 关键方法 ：每条线程起始写入文件的位置
                    InputStream in = conn.getInputStream();
                    byte[] buf = new byte[8192];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        file.write(buf, 0, len);
                        downloadByteCount += len;
                    }
                    // 关闭网络连接及本地流
                    in.close();
                    file.close();
                    conn.disconnect();
                    System.out.println(Thread.currentThread().getName() + ": download OK");
                }
            } catch (IOException e) {
                System.out.println(Thread.currentThread().getName() + "_Error : " + e);
            }
        }

    }
}