package ass10;

public class FixedSizeArrayQueue {
	//Array used to implement the circular queue
	int[] arrayQueue;
	int size,front,rear,capacity;
	public FixedSizeArrayQueue(int capacity){
		this.capacity=capacity;
		arrayQueue=new int[capacity];
		size=capacity;
		front=-1;
		rear=-1;
	}
	
	//function to insert an element in circular queue
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("queue is full");
			return;
		}
		else {
			if(front==-1)
				front++;
			rear=(rear+1)%capacity;
			arrayQueue[rear]=value;
			System.out.println(value+" is inserted in queue");
			size--;
		}
	}
	
	//function to delete element from circular queue
	public void dequeue(){
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		else {
			int temp=arrayQueue[front];
			front=(front+1)%capacity;
			System.out.println(temp+" is removed from queue");
			size++;
		}
	}
	
	//function to get available slots
	public void getSize() {
		System.out.println("Available slots: "+size);
	}
	
	//check empty condition
	public boolean isEmpty() {
		if(size==capacity)
			return true;
		else
			return false;
	}
	
	//check Full condition
	public boolean isFull() {
		if(size==0)
			return true;
		else
			return false;
	}
	
	//Display function
	public void display() {
		System.out.println("Queue elements are: ");
		if(front<=rear) {
			for(int i=front;i<=rear;i++)
				System.out.print(arrayQueue[i]+" ");
			System.out.println();
		}
		else {
			for(int i=front;i<capacity;i++)
				System.out.print(arrayQueue[i]+" ");
			for(int i=0;i<=rear;i++)
				System.out.print(arrayQueue[i]+" ");
			System.out.println();
		}
	}
	
	//main function
	public static void main(String[] args) {
		FixedSizeArrayQueue queue=new FixedSizeArrayQueue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.display();
		queue.dequeue();
		queue.dequeue();
		queue.getSize();
		queue.enqueue(6);
		queue.display();
	}
	
}