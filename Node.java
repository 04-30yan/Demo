package interview;

//Á´±í
public class Node {
	Node next = null;
	int value;
	public Node(int value) {
		this.value = value;
	}
	public void add(int value) {
		Node node = new Node(value);
		Node node1 = this;
		if(node1 != null) {
			this.next = node1.next;
		}
		node1.next = node;
	}
}
