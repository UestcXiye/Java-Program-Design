import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.fluent.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class HttpSuggestion extends JFrame {

	JTextField txtInput = new JTextField();
	JList<String> lstSuggestion = new JList<>();

	public HttpSuggestion() {
		super("auto suggestion");
		getContentPane().add(BorderLayout.NORTH, txtInput);
		getContentPane().add(BorderLayout.CENTER,
				new JScrollPane(lstSuggestion));
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		txtInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				new Thread(() -> {
					try {
						String word = txtInput.getText();
						String[] suggestion = fetchSuggestion(word);
						SwingUtilities.invokeLater(() -> {
							lstSuggestion.removeAll();
							lstSuggestion.setListData(suggestion);
							lstSuggestion.updateUI();
						});
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}).start();
			}
		});

		lstSuggestion.addListSelectionListener(e -> {
			txtInput.setText(lstSuggestion.getSelectedValue());
		});
	}

	public static void main(String... args) throws Exception {
		// String word = "人";
		// fetchSuggestion(word);

		SwingUtilities.invokeLater(() -> {
			new HttpSuggestion();
		});

	}

	public static String[] fetchSuggestion(String word)
			throws UnsupportedEncodingException, ClientProtocolException,
			IOException {
		if (word == null || word.length() == 0)
			return new String[0];

		String url = "http://suggestion.baidu.com/su?wd="
				+ URLEncoder.encode(word, "utf-8");
		url += "&rnd=" + Math.random();

		String content = Request.Get(url)
				.addHeader("cookie", "BDUSS=Aadasdfsfee").execute()
				.returnContent().asString();

		System.out.println(content);
		// window.baidu.sug({q:"人",p:false,s:["人体艺术","人体艺术图片","人人网","人体艺术摄影","人民币对美元汇率","人体","人人贷","人人影视"]});

		String[] sug = content.replaceAll(".*,s:\\[([^\\]]*)\\].*", "$1")
				.replaceAll("\"", "").split(",");
		return sug;
	}

}
