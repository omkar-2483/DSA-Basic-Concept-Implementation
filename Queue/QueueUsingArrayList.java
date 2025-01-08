package ass8;
import java.util.*;
class Queue{
	int front,rear;
	ArrayList<Integer> queue;
	
	//constructor
	Queue(){
		front=-1;
		rear=-1;
		queue=new ArrayList<Integer>();
	}
	
	//enqueue function
	public void enqueue(int value) {
		if(front==-1)
			front=0;
		rear++;
		queue.add(value);
		System.out.println(value+" added to queue");
	}
	
	//dequeue function
	public void dequeue() {
		if(queue.isEmpty()) {
			System.out.println("queue is empty");
			return;
		}
		int temp=queue.get(front);
		queue.remove(front);
		rear--;
		System.out.println(temp+" is removed from queue");
	}
	
	//isEmpty function
	public boolean isEmpty() {
		if(front==-1 || front>rear)
			return true;
		else
			return false;
	}
	
	//isFull function
	//we are using ArrayList so queue will never be full
	/*public boolean isFull() {
		if(rear==queue.size()-1)
			return true;
		else
			return false;
	}*/
	
	//display function
	public void display() {
		if(queue.isEmpty()) {
			System.out.println("queue is empty");
			return;
		}
		System.out.println("elements of queue are: ");
		for(int i=front;i<=rear;i++) {
			System.out.print(queue.get(i)+" ");
		}
		System.out.println();
	}
}

public class QueueUsingArrayList {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Queue IntQueue=new Queue();
		int choice;
		while(true){
			System.out.println("1.add element \n2.delet element \n3.display elements");
			System.out.println("Enter choice:");
			choice=sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter value to be added: ");
				int value=sc.nextInt();
				IntQueue.enqueue(value);
				break;
			case 2:
				IntQueue.dequeue();
				break;
			case 3:
				IntQueue.display();
				break;
			default:
				return;
			}
		}
	}
}
