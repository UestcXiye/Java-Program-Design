import java.util.*;

class GenericTreeClass {
	public static void main(String[] args){ 
		TNode<String> t = new TNode<>("Roo");
		t.add("Left"); t.add("Middle"); t.add("Right");
		t.getChild(0).add("aaa");
		t.getChild(0).add("bbb");
		t.traverse();
	}
}

class TNode<T>
{
  private T value;
  private ArrayList<TNode<T>> children = new ArrayList<>();

  TNode(T v) { this.value = v; } 
  public T getValue() { return this.value; } 
  public void add(T v) {
    TNode<T> child = new TNode<>(v);
    this.children.add(child);
  }
  public TNode<T> getChild(int i) {
    if ((i < 0) || (i > this.children.size())) return null;
    return (TNode<T>)this.children.get(i);
  }

  public void traverse() {
    System.out.println(this.value);
    for (TNode child : this.children)
      child.traverse();
  }
}