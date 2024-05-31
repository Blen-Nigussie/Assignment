package IndividualAsssignment2;
class Node{
    int data;
    Node next;
    Node (int data) {
        this.data = data;
        next = null;
    }
}

public class SinglyLinkedList {
    Node head;

    public SinglyLinkedList() {
        head = null;
    }

    void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

    }

    // question 1: Inserting a Node at Any Given Position in a Singly Linked List:
public void insertAtPos(int d, int place) {
    Node nodeNew = new Node(d);
    if (head == null || place == 0) {
        nodeNew.next = head;
        head = nodeNew;
        return;
    }
    if (place == 1) {
        nodeNew.next = head.next;
        head.next = nodeNew;
        return;
    }
    Node prevNode = head;
    for (int i = 0; i < place - 2; i++) {
        if (prevNode.next == null) {
            System.out.println("Position out of range");
        }
        prevNode = prevNode.next;
    }
    if (prevNode.next == null) {
        prevNode.next = nodeNew;
        return;
    }
    nodeNew.next = prevNode.next;
    prevNode.next = nodeNew;
}

    // question 2: Deleting a Node at Any Given Position in a Singly Linked List:
    public void deleteAtPosition(int position) {
        if (head == null || position == 1) {
            head = (head == null) ? null : head.next;
        }
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of range");
            }
            current = current.next;

            if (current.next == null) {
                System.out.println("Position out of range");
            }
            current.next = current.next.next;
        }
    }

    //question 3 : Deleting a Node After a Given Node in a Singly Linked List:
    public void deleteAfterNode(Node node) {
        if (head == null || node == null) {
            System.out.println("The node is not valid");
        }
        if (node.next == null) {
            System.out.println("The node is last node");
        }
        node.next = node.next.next;
    }

    // question 4 Searching a Node in a Singly Linked List:
    public boolean searchNode(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // question 5 Implementing a Stack Using Linked Lists:
    static class StackUsingLinkedLIst {
        private Node top;

        public StackUsingLinkedLIst() {
            this.top = null;
        }

        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }

        public int pop() {
            if (top == null) {
                System.out.println("Stack is empty");
            }
            int deleted = top.data;
            top = top.next;
            return deleted;
        }

        public int peek() {
            if (top == null) {
                System.out.println("Stack is empty");
            }
            return top.data;
        }

    }
    void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


        public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insertAtPos(5, 5);
        list.deleteAtPosition(3);
        Node secondNode = list.head.next;
        list.deleteAfterNode(secondNode);
        boolean exist = list.searchNode(5);
        System.out.println("Node with value 3 exist? " + exist);
        StackUsingLinkedLIst stack = new StackUsingLinkedLIst();
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.pop();
        stack.peek();
        list.display();

    }
}
