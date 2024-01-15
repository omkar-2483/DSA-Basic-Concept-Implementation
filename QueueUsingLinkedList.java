package ass9;
import java.util.Scanner;

class node{
	int data;
	node next;
	//constructor to create node
	public node(int value) {
		this.data=value;
		this.next=null;
	}
}

//class to implement queue using linked list
class QueueLinkedList{
	private node front;
	private node rear;
	//constructor
	public QueueLinkedList() {
		this.front=null;
		this.rear=null;
	}
	
	//isEmpty function
	public boolean isEmpty() {
		return front==null;
	}
	
	//enqueue function
	public void enqueue(node newNode) {
		if(front==null) {
			front=newNode;
		    rear=newNode;
		}
		else {
			rear.next=newNode;
			rear=newNode;
		}
		System.out.println(newNode.data+" is added to queue");
	}
	
	//dequeue function
	public void dequeue() {
		if(isEmpty())
			System.out.println("queue is empty...");
		else {
			node temp=front;
			front=front.next;
			System.out.println(temp.data+" is removed from quque");
			temp=null;
		}
	}
	
	//display function
	public void displayQueue() {
		if(isEmpty())
			System.out.println("queue is empty...");
		else {
			System.out.println("queue elements are: ");
			node temp=front;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
}

public class QueueUsingLinkedList {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		QueueLinkedList IntQueue=new QueueLinkedList();
		int choice;
		while(true){
			System.out.println("1.add element \n2.delet element \n3.display elements");
			System.out.println("Enter choice:");
			choice=sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter value to be added: ");
				int value=sc.nextInt();
				node newNode=new node(value);
				IntQueue.enqueue(newNode);
				break;
			case 2:
				IntQueue.dequeue();
				break;
			case 3:
				IntQueue.displayQueue();
				break;
			default:
				return;
			}
		}
	}

}