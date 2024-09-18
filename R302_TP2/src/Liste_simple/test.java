package Liste_simple;

public class test {
	public static void main (String[] args) {
		SLinkedList l = new SLinkedList();
		
		// Q2
		l.addHeader(5);
		System.out.println(l.toString());
		l.add(6);
		System.out.println(l.toString());
		l.addHeader(0);
		System.out.println(l.toString());
		l.addHeader(2);
		System.out.println(l.toString());
		
		// Q3
		System.out.println(l.getLastValue());
		
		// Q4
		/*l.remove(2);
		System.out.println(l.toString());*/
		l.inversion();
		System.out.println(l.toString());
		
		// Q5
		l.inversionNoeuds(1, 4);
		System.out.println(l.toString());
	}
}