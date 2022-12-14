public class Main {
	public static void main(String[] args) {
		linkedList myList = new linkedList();

		for (int i = 0; i < 20; i++) {
			myList.add(i);
		}

//		myList.listAll();
		myList.find(5);
	}
}

// This should be separate file
public class linkedList {
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	public void add(int data) {
		Node newNode = new Node(data);

		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void addMiddle(int data) {
		Node newNode = new Node(data);
		Node current = head;
		int count = 0;
		int tempCount = 0;

		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		while(current != null) {
			current = current.next;
			// increase the count variable
			count++;
		}
		current = head;
		tempCount = count;
		while(current != null) {
			if(count/2 == tempCount) {
				
				return;
			}
			tempCount -= 1;
		}
	}

	public void listAll() {
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.print("Nodes of the linked list: ");
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void find(int find) {
		Node current = head;
		boolean found = false;

		if (head == null) {
			System.out.println("List is empty");
		}
		System.out.println("Searching for the element with " + find);
		while(current != null) {
			if (current.data == find) {
				System.out.println("Parameter found !!!");
				return;
			}
			current = current.next;
		}
		System.out.println("Parameter not found...");
	}
}
