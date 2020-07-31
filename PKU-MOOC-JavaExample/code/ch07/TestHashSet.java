import java.util.*;
public class TestHashSet {
	public static void main(String[] args) {
		Set h = new HashSet();
		h.add("1st");
		h.add("2nd");
		h.add("3rd");
		h.add("4th");
		h.add("5th");
		h.add(new Integer(6));
		h.add(new Double(7.0));

		h.add("2nd");          // 重复元素, 未被加入
		h.add(new Integer(6)); // 重复元素, 未被加入

		m1(h);
	}
	public static void m1(Set s){
		System.out.println(s);  // 调用了其toString()方法,注意显示时,元素无顺序
	}
}