package Liste_simple;

public class Node {
	private int element;
	private Node next;
	
	public Node(int element) {
		this.element = element;
		this.next = null;
	}
	
	public Node(int element, Node node) {
		this.element = element;
		this.next = node;
	}
	
	public int getElement() {
		return element;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setElement(int element) {
		this.element = element;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.element);
	}
}
