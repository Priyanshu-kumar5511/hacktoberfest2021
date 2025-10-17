public class DoublyLinkedList {
    
    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private Node head;

    // Insert a new node at the start
    public void push(int newData) {
        Node newNode = new Node(newData);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    // Insert a new node before a given node (search by data)
    public void insertBefore(int nextData, int newData) {
        Node current = head;
        while (current != null && current.data != nextData) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node with data " + nextData + " not found.");
            return;
        }

        Node newNode = new Node(newData);
        newNode.prev = current.prev;
        newNode.next = current;

        if (current.prev != null) {
            current.prev.next = newNode;
        } else {
            head = newNode;
        }
        current.prev = newNode;
    }

    // Print the list forward and backward
    public void printList() {
        Node last = null;
        System.out.println("\nTraversal in forward direction:");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            last = temp;
            temp = temp.next;
        }

        System.out.println("\nTraversal in reverse direction:");
        temp = last;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(7);
        list.push(1);
        list.push(4);
        list.insertBefore(1, 8);  // insert 8 before 1
        System.out.println("Created DLL is:");
        list.printList();
    }
}
