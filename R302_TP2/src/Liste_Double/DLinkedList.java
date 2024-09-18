package Liste_Double;

public class DLinkedList {
	private DNode header, trailer;
	private long size;
	
	public DLinkedList() {
		this.header = new DNode(0, null, null);
		this.trailer = new DNode(0, null, null);
		this.size = 0;
	}
	
	public DLinkedList(DNode header, DNode trailer, long size) {
		this.header = header;
		this.trailer = trailer;
		this.size = size;
	}
	
	public DNode getHeader() {
		return header;
	}
		
	public long getSize() {
		return size;
	}
	
	public DNode getTrailer() {
		return trailer;
	}
	
	public void setHeader(DNode header) {
		this.header = header;
	}
	
	public void setSize(long size) {
		this.size = size;
	}
	
	public void setTrailer(DNode trailer) {
		this.trailer = trailer;
	}
	
	// Q7
	public boolean update(int index, int element, DNode next, DNode prev) {
		DNode nodeProvisoire = this.header;
		int i = 0;
		while(nodeProvisoire != null) {
			if(i == index-1) {
				nodeProvisoire.setElement(element);
				nodeProvisoire.setNext(next);
				nodeProvisoire.setPrev(prev);
				
				return true;
			}
			nodeProvisoire = nodeProvisoire.getNext();
			++i;
		}
		return false;
	}
	
	public void inversionNoeuds (int indexX, int indexY) {
		DLinkedList listeProvisoire = new DLinkedList(this.header, this.trailer, this.size);
		
		DNode X = new DNode(0);
		DNode Y = new DNode(0);
		DNode nodeProvisoire = this.header;
		
		for(int i = 0; i < this.size; ++i) {
			if(i == indexX-1) {
				X.setElement(nodeProvisoire.getElement());
				X.setNext(nodeProvisoire.getNext());
				X.setElement(nodeProvisoire.getElement());
			} else if(i == indexY-1) {
				Y.setElement(nodeProvisoire.getElement());
				Y.setNext(nodeProvisoire.getNext());
				Y.setElement(nodeProvisoire.getElement());
			}
			nodeProvisoire = nodeProvisoire.getNext();
		}
		
		listeProvisoire.update(indexY, X.getElement(), Y.getNext(), Y.getPrev());
		listeProvisoire.update(indexX, Y.getElement(), X.getNext(), X.getPrev());
	}
	
	// Q9
	public int nbNoeuds() {
		DNode dNodeProvisoire = this.header;
		int compteur = 1;
		
		while(dNodeProvisoire.getNext() != this.header) {
			dNodeProvisoire = dNodeProvisoire.getNext();
			++compteur;
		}	
		return compteur;
	}
	
	// Q10
	
	public boolean equals(DLinkedList dListe) {
		if(dListe.getHeader().equals(this.header) && dListe.getTrailer().equals(this.trailer)
				&& dListe.getSize() == this.size) {
			return true;
		}
		return false;
	}
	
	
	public String toString() {
        DNode nodeProvisoire = this.header;       
        String affichage = "[" + header.toString();
        while (nodeProvisoire.getNext() != null) {
            nodeProvisoire = nodeProvisoire.getNext();
            affichage = affichage + ", "+ nodeProvisoire;
        }
        return (affichage + ']' +'\n');
    }
}
