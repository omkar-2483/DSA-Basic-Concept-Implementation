package sce;

class Node{
	int data;
	Node prev;
	Node next;
	
	//create node
	Node(int data){
		this.data=data;
		prev=null;
		next=null;
	}
}

class DLL{
	Node head=null;
	
	//insert node at front
	public void insertFront(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
		}else {
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
		}
	}
	
	//insert node at end
	public void insertEnd(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
		}else {
			Node temp=head;
			while(temp.next!=null)
				temp=temp.next;
			temp.next=newNode;
			newNode.prev=temp;
		}
	}
	
	//insert at provided index
	public void addAtIndex(int index,int data) {
		Node newNode=new Node(data);
		Node temp=head;
		for(int i=1;i<index;i++)
			temp=temp.next;
		newNode.prev=temp;
		newNode.next=temp.next;
		newNode.next.prev=newNode;
		temp.next=newNode;
	}
	
	//display DLL
	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	
}

public class DoublyLinkedList {
	public static void main(String[] args) {
		DLL List=new DLL();
		List.insertFront(1);
		List.insertFront(2);
		List.insertFront(3);
		System.out.print("After adding 1,2,3 at front, List: ");
		List.display();
		System.out.println();
		List.insertEnd(4);
		List.insertEnd(5);
		List.insertEnd(6);
		System.out.print("After adding 4,5,6 at end, List: ");
		List.display();
		System.out.println();
		List.addAtIndex(3, 0);
		List.addAtIndex(4, 0);
		List.addAtIndex(5, 0);
		System.out.print("After adding 0s at index 3,4,5 List: ");
		List.display();
		System.out.println();
	}
}
