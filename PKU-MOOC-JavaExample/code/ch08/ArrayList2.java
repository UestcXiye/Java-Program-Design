import java.util.Arrays;
import java.util.concurrent.locks.*;

public class ArrayList2 {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Object[] list;
    private int next;
   
    public ArrayList2(int capacity) {
        list = new Object[capacity];
    }

    public ArrayList2() {
        this(16);
    }

    public void add(Object o) {
        try {
            lock.writeLock().lock();
            if (next == list.length) {
                list = Arrays.copyOf(list, list.length * 2);
            }
            list[next++] = o;
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    public Object get(int index) {
        try {
            lock.readLock().lock();
            return list[index];
        } finally {
            lock.readLock().unlock();
        }
    }
    
    public int size() {
        try {
            lock.readLock().lock();
            return next;
        } finally {
            lock.readLock().unlock();
        }
    }
	
	public static void main(String[] args){
		ArrayList2 ary = new ArrayList2();
	}
}
