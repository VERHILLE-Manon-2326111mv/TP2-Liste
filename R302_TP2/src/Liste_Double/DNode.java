package Liste_Double;

public class DNode {
	private int element;
	private DNode next, prev;
	
	public DNode(int element) {
		this.element = element;
		this.next = null;
		this.prev = null;
	}
	
	public DNode(int element, DNode next, DNode prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}
	
	public int getElement() {
		return element;
	}
	
	public DNode getNext() {
		return next;
	}
	
	public DNode getPrev() {
		return prev;
	}
	
	public void setElement(int element) {
		this.element = element;
	}
	
	public void setNext(DNode next) {
		this.next = next;
	}
	
	public void setPrev(DNode prev) {
		this.prev = prev;
	}
	
	public boolean equals(DNode node) {
		if(node.getElement() == this.element && node.getNext() == this.next
				&& node.getPrev() == this.prev) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Element : " + String.valueOf(this.element) + ", Next : " +  String.valueOf(this.next)
		+ ", Prev :" +  String.valueOf(this.prev);
	}
}
