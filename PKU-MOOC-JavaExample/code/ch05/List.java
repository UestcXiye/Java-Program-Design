import java.io.IOException;

public class List {
	private Node Head = null;
	private Node Tail = null;
	private Node Pointer = null;
	private int Length = 0;

	public void deleteAll() {
		Head = null;
		Tail = null;
		Pointer = null;
		Length = 0;
	}

	public void reset() {
		Pointer = null;
	}

	public boolean isEmpty() {
		return (Length == 0);
	}

	public boolean isEnd() {
		if (Length == 0) throw new java.lang.NullPointerException();
		else if (Length == 1) return true;
		else return (cursor() == Tail);
	}

	public Object nextNode() {
		if (Length == 1) throw new java.util.NoSuchElementException();
		else if (Length == 0) throw new java.lang.NullPointerException();
		else {
			Node temp = cursor();
			Pointer = temp;
			if (temp != Tail) return (temp.next.data);
			else throw new java.util.NoSuchElementException();
		}
	}

	public Object currentNode() {
		Node temp = cursor();
		return temp.data;
	}

	public void insert(Object d) {
		Node e = new Node(d);
		if (Length == 0) {
			Tail = e;
			Head = e;
		} else {
			Node temp = cursor();
			e.next = temp;
			if (Pointer == null) Head = e;
			else Pointer.next = e;
		}
		Length++;
	}

	public int size() {
		return (Length);
	}

	public Object remove() {
		Object temp;
		if (Length == 0) throw new java.util.NoSuchElementException();
		else if (Length == 1) {
			temp = Head.data;
			deleteAll();
		} else {
			Node cur = cursor();
			temp = cur.data;
			if (cur == Head) Head = cur.next;
			else if (cur == Tail) {
				Pointer.next = null;
				Tail = Pointer;
				reset();
			} else Pointer.next = cur.next;
			Length--;
		}
		return temp;
	}

	private Node cursor() {
		if (Head == null) throw new java.lang.NullPointerException();
		else if (Pointer == null) return Head;
		else return Pointer.next;
	}

	public static void main(String[] args) throws IOException{
		List a = new List();
		for (int i = 1; i <= 10; i++) a.insert(new Integer(i));
		System.out.println(a.currentNode());
		while (!a.isEnd()) System.out.println(a.nextNode());
		a.reset();
		while (!a.isEnd()) {
			a.remove();
		}
		a.remove();
		a.reset();
		if (a.isEmpty()) System.out.println("There  is  no  Node  in  List  n");
		System.out.println("You  can  press  return  to  quitn");
		try {
			System. in .read();
		} catch(IOException e) {}
		
	}
}

class Node {
	Object data;
	Node next;

	Node(Object d) {
		data = d;
		next = null;
	}
}
