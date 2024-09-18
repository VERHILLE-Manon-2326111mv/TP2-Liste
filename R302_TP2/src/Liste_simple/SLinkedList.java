package Liste_simple;

import java.util.LinkedList;

public class SLinkedList {
	private Node head;
	private long size;
	
	public SLinkedList() {
		head = null;
		size = 0;
	}
	
	public SLinkedList(Node head){
		super();
		this.head = head;
	}
	
	public SLinkedList(long size, Node head) {
		super();
		this.size = size;
		this.head = head;
	}
	
	public Node getHead() {
		return head;
	} 
	
	public long getSize() {
		return size;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	public void setSize(long size) {
		this.size = size;
	}
	
	// Q2
	
	public void add(int newValue) {
		Node newNode = new Node(newValue);
		// Création d'un nouveau noeud
		if (head == null) {
			head = newNode;
			// Si la liste est vide, on insère la tête.
			++this.size;
		} else {
			Node valeurActuelle = head;
			while(valeurActuelle.getNext() != null) {
				valeurActuelle = valeurActuelle.getNext();
			}
			valeurActuelle.setNext(newNode);
			++this.size;
			// Sinon, on recheche un moment où la variable next vaut null
			// pour implémenter.
		}
	}
	
	public void addHeader(int newValue) {
		Node newHeader = new Node (newValue);
		// Création d'un nouveau noeud
		newHeader.setNext(head);
		// newHeader devient la tête de la liste.
		this.head = newHeader;
		++this.size;
		// On augmente la taille de la liste.
	}
	
	// Q3
	public int getLastValue() {
		int lastValue = 0;
		Node nodeProvisoire;
		if(head.getNext() == null) {
			lastValue = head.getElement();
		}else{
			nodeProvisoire = head.getNext();
			while(nodeProvisoire.getNext().getNext() != null) {
				nodeProvisoire = nodeProvisoire.getNext();
			}
			lastValue = nodeProvisoire.getElement();
		}
		return lastValue;
	}
		
	//Q4
	public boolean remove(long index) {
		if(head == null) return false;
		
		if(index == 0) {
			head = head.getNext();
			return true;
		}
		
		Node nodeAvant = null;
		Node nodeProvisoire = head;
		int i = 0;
		
		while(nodeProvisoire != null) {
			if(i == index) {
				if(nodeAvant != null) {
					nodeAvant.setNext(nodeProvisoire.getNext());
				}
				return true;
			}
			nodeAvant = nodeProvisoire;
			nodeProvisoire = nodeProvisoire.getNext();
			++i;
		}	
		return false;
	}
	
	public void inversion() {
		SLinkedList listeInversee = new SLinkedList();
		// Création d'une liste qui contiendra la liste inversée.
		
		SLinkedList listeProvisoire = new SLinkedList(this.size, this.head);
		Node nodeProvisoire = this.head;
		long sizeProvisoire = this.size;
		// Création des variables provisoires.
		
		while(sizeProvisoire > 0) {
			for(int i = 0; i < sizeProvisoire-1; ++i) {
				if(nodeProvisoire.getNext() != null)
				nodeProvisoire = nodeProvisoire.getNext();
			}
			listeInversee.add(nodeProvisoire.getElement());
			listeProvisoire.remove(size);
			nodeProvisoire = listeProvisoire.getHead();
			--sizeProvisoire;
		}
		this.head.setElement(listeInversee.getHead().getElement());
		this.head.setNext(listeInversee.getHead().getNext());
	}
	
	// Q5
	public boolean update(int index, int element, Node next) {
		Node nodeProvisoire = this.head;
		int i = 0;
		while(nodeProvisoire != null) {
			if(i == index-1) {
				nodeProvisoire.setElement(element);
				nodeProvisoire.setNext(next);
				return true;
			}
			nodeProvisoire = nodeProvisoire.getNext();
			++i;
		}
		return false;
	}
	
	public void inversionNoeuds (int indexX, int indexY) {
		SLinkedList listeProvisoire = new SLinkedList(this.size, this.head);
		
		Node X = new Node(0);
		Node Y = new Node(0);
		Node nodeProvisoire = this.head;
		
		for(int i = 0; i < this.size; ++i) {
			if(i == indexX-1) {
				X.setElement(nodeProvisoire.getElement());
				X.setNext(nodeProvisoire.getNext());
			} else if(i == indexY-1) {
				Y.setElement(nodeProvisoire.getElement());
				Y.setNext(nodeProvisoire.getNext());
			}
			nodeProvisoire = nodeProvisoire.getNext();
		}
		
		listeProvisoire.update(indexY, X.getElement(), Y.getNext());
		listeProvisoire.update(indexX, Y.getElement(), X.getNext());
	}
	
	public String toString() {
        Node nodeProvisoire = head;       
        String affichage = "[" + head.toString();
        while (nodeProvisoire.getNext() != null) {
            nodeProvisoire = nodeProvisoire.getNext();
            affichage = affichage + ", "+ nodeProvisoire;
        }
        return (affichage + ']' +'\n');
    }
	
}
