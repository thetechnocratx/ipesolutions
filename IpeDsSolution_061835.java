//Write a program to demonstrate stack operations using an array.(i.e Push, Pop, Peep, Change,display)
import java.util.Scanner;

class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
            System.out.println(value + " pushed to the stack.");
        } else {
            System.out.println("Stack is full. Cannot push " + value);
        }
    }

    public void pop() {
        if (top >= 0) {
            int poppedValue = stackArray[top--];
            System.out.println(poppedValue + " popped from the stack.");
        } else {
            System.out.println("Stack is empty. Cannot pop.");
        }
    }

    public void peek() {
        if (top >= 0) {
            System.out.println("Top element of the stack is: " + stackArray[top]);
        } else {
            System.out.println("Stack is empty.");
        }
    }

    public void change(int index, int newValue) {
        if (index >= 0 && index <= top) {
            stackArray[index] = newValue;
            System.out.println("Value at index " + index + " changed to " + newValue);
        } else {
            System.out.println("Invalid index. Cannot change value.");
        }
    }

    public void display() {
        if (top >= 0) {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty.");
        }
    }
}

 class StackDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Change");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to push: ");
                    int valueToPush = scanner.nextInt();
                    stack.push(valueToPush);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    System.out.print("Enter the index to change: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter the new value: ");
                    int newValue = scanner.nextInt();
                    stack.change(index, newValue);
                    break;
                case 5:
                    stack.display();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

//Write a program to demonstrate queue operations using an array.(i.e Enqueue, Dequeue, display, getfront, getrear)
import java.util.Scanner;

class Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;

    public Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
    }

    public void enqueue(int value) {
        if (rear == maxSize - 1) {
            System.out.println("Queue is full. Cannot enqueue " + value);
        } else {
            queueArray[++rear] = value;
            System.out.println(value + " enqueued to the queue.");
        }
    }

    public void dequeue() {
        if (front <= rear) {
            int dequeuedValue = queueArray[front++];
            System.out.println(dequeuedValue + " dequeued from the queue.");
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
        }
    }

    public void getFront() {
        if (front <= rear) {
            System.out.println("Front element of the queue is: " + queueArray[front]);
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public void getRear() {
        if (front <= rear) {
            System.out.println("Rear element of the queue is: " + queueArray[rear]);
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public void display() {
        if (front <= rear) {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty.");
        }
    }
}

 class QueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        Queue queue = new Queue(size);

        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Get Front");
            System.out.println("4. Get Rear");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to enqueue: ");
                    int valueToEnqueue = scanner.nextInt();
                    queue.enqueue(valueToEnqueue);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.getFront();
                    break;
                case 4:
                    queue.getRear();
                    break;
                case 5:
                    queue.display();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

//Write a program to demonstrate deque operations using an array.(i.e insert from front, delete from rear, display, getfront, getrear)
import java.util.Scanner;

class Deque {
    private int maxSize;
    private int front;
    private int rear;
    private int[] dequeArray;

    public Deque(int size) {
        maxSize = size;
        dequeArray = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public void insertFront(int value) {
        if ((front == 0 && rear == maxSize - 1) || (front == rear + 1)) {
            System.out.println("Deque is full. Cannot insert at the front.");
        } else if (front == -1) {
            front = 0;
            rear = 0;
            dequeArray[front] = value;
            System.out.println(value + " inserted at the front of the deque.");
        } else if (front == 0) {
            front = maxSize - 1;
            dequeArray[front] = value;
            System.out.println(value + " inserted at the front of the deque.");
        } else {
            front--;
            dequeArray[front] = value;
            System.out.println(value + " inserted at the front of the deque.");
        }
    }

    public void deleteRear() {
        if (front == -1) {
            System.out.println("Deque is empty. Cannot delete from the rear.");
        } else if (front == rear) {
            System.out.println(dequeArray[rear] + " deleted from the rear of the deque.");
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            System.out.println(dequeArray[rear] + " deleted from the rear of the deque.");
            rear = maxSize - 1;
        } else {
            System.out.println(dequeArray[rear] + " deleted from the rear of the deque.");
            rear--;
        }
    }

    public void getFront() {
        if (front != -1) {
            System.out.println("Front element of the deque is: " + dequeArray[front]);
        } else {
            System.out.println("Deque is empty.");
        }
    }

    public void getRear() {
        if (rear != -1) {
            System.out.println("Rear element of the deque is: " + dequeArray[rear]);
        } else {
            System.out.println("Deque is empty.");
        }
    }

    public void display() {
        if (front != -1) {
            System.out.print("Deque elements: ");
            int i = front;
            while (true) {
                System.out.print(dequeArray[i] + " ");
                if (i == rear) {
                    break;
                }
                if (i == maxSize - 1) {
                    i = 0;
                } else {
                    i++;
                }
            }
            System.out.println();
        } else {
            System.out.println("Deque is empty.");
        }
    }
}

class DequeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the deque: ");
        int size = scanner.nextInt();
        Deque deque = new Deque(size);

        while (true) {
            System.out.println("\nDeque Operations:");
            System.out.println("1. Insert at Front");
            System.out.println("2. Delete from Rear");
            System.out.println("3. Get Front");
            System.out.println("4. Get Rear");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to insert at the front: ");
                    int valueToInsert = scanner.nextInt();
                    deque.insertFront(valueToInsert);
                    break;
                case 2:
                    deque.deleteRear();
                    break;
                case 3:
                    deque.getFront();
                    break;
                case 4:
                    deque.getRear();
                    break;
                case 5:
                    deque.display();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

//Write a program to demonstrate circular queue operations using an array. (i.e Enqueue, Dequeue, display, getfront, getrear)
import java.util.Scanner;

class CircularQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;

    public CircularQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Circular Queue is full. Cannot enqueue " + value);
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            System.out.println(value + " enqueued to the Circular Queue.");
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty. Cannot dequeue.");
        } else {
            int dequeuedValue = queueArray[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % maxSize;
            }
            System.out.println(dequeuedValue + " dequeued from the Circular Queue.");
        }
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty.");
            return -1;
        } else {
            return queueArray[front];
        }
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty.");
            return -1;
        } else {
            return queueArray[rear];
        }
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty.");
        } else {
            System.out.print("Circular Queue elements: ");
            int i = front;
            do {
                System.out.print(queueArray[i] + " ");
                i = (i + 1) % maxSize;
            } while (i != (rear + 1) % maxSize);
            System.out.println();
        }
    }
}

class CircularQueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the Circular Queue: ");
        int size = scanner.nextInt();
        CircularQueue circularQueue = new CircularQueue(size);

        while (true) {
            System.out.println("\nCircular Queue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Get Front");
            System.out.println("4. Get Rear");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to enqueue: ");
                    int valueToEnqueue = scanner.nextInt();
                    circularQueue.enqueue(valueToEnqueue);
                    break;
                case 2:
                    circularQueue.dequeue();
                    break;
                case 3:
                    int frontValue = circularQueue.getFront();
                    if (frontValue != -1) {
                        System.out.println("Front element of the Circular Queue is: " + frontValue);
                    }
                    break;
                case 4:
                    int rearValue = circularQueue.getRear();
                    if (rearValue != -1) {
                        System.out.println("Rear element of the Circular Queue is: " + rearValue);
                    }
                    break;
                case 5:
                    circularQueue.display();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

//Write a program to evaluate postfix expression using stack
import java.util.Stack;

 class PostfixEvaluator {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char to integer and push onto the stack
            } else if (ch == ' ') {
                // Ignore spaces
            } else {
                // Operator encountered
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "2 3 * 5 4 * +"; // Example postfix expression

        try {
            int result = evaluatePostfix(postfixExpression);
            System.out.println("Result of postfix expression: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//Write a program to evaluate prefix expression using stack
import java.util.Stack;

 class PrefixEvaluator {

    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();

        // Reverse the input expression
        String reversedExpression = new StringBuilder(expression).reverse().toString();

        for (char ch : reversedExpression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char to integer and push onto the stack
            } else if (ch == ' ') {
                // Ignore spaces
            } else {
                // Operator encountered
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid prefix expression");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String prefixExpression = "+ * 2 3 * 5 4"; // Example prefix expression

        try {
            int result = evaluatePrefix(prefixExpression);
            System.out.println("Result of prefix expression: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//Write a program to demonstrate a method insert at first to add node in first position of a singly LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    // Method to insert a node at the beginning of the linked list
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert nodes at the first position
        list.insertAtFirst(3);
        list.insertAtFirst(2);
        list.insertAtFirst(1);

        // Display the linked list
        System.out.println("Linked List after inserting nodes at the first position:");
        list.display();
    }
}

//Write a program to demonstrate a method insert at last to add node in last position of a singly LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    // Method to insert a node at the beginning of the linked list
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert a node at the last position of the linked list
    public void insertAtLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

 class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert nodes at the first position
        list.insertAtFirst(3);
        list.insertAtFirst(2);
        list.insertAtFirst(1);

        // Display the linked list
        System.out.println("Linked List after inserting nodes at the first position:");
        list.display();

        // Insert nodes at the last position
        list.insertAtLast(4);
        list.insertAtLast(5);

        // Display the linked list
        System.out.println("\nLinked List after inserting nodes at the last position:");
        list.display();
    }
}


//Write a program to demonstrate a method insert before particular value to add node in before the value entered by user in a singly LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void insertBefore(int valueToInsertBefore, int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            System.out.println("List is empty. Cannot insert before.");
            return;
        }

        if (head.data == valueToInsertBefore) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != valueToInsertBefore) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found in the list.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting some initial values
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = new Node(40);

        System.out.println("Original Linked List:");
        list.display();

        int valueToInsertBefore = 30;
        int newValue = 25;

        list.insertBefore(valueToInsertBefore, newValue);

        System.out.println("Linked List after inserting " + newValue + " before " + valueToInsertBefore + ":");
        list.display();
    }
}

//Write a program to demonstrate a method insert after particular value to add node in after the value entered by user in a singly LinkedList.
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void insertAfter(int valueToInsertAfter, int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            System.out.println("List is empty. Cannot insert after.");
            return;
        }

        Node current = head;
        while (current != null && current.data != valueToInsertAfter) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found in the list.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

 class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        // Inserting some initial values
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = new Node(40);

        System.out.println("Original Linked List:");
        list.display();

        System.out.print("Enter the value after which you want to insert: ");
        int valueToInsertAfter = scanner.nextInt();

        System.out.print("Enter the new value to insert: ");
        int newValue = scanner.nextInt();

        list.insertAfter(valueToInsertAfter, newValue);

        System.out.println("Linked List after inserting " + newValue + " after " + valueToInsertAfter + ":");
        list.display();

        scanner.close();
    }
}

//Write a program to demonstrate a method to insert a node in ordered way in a singly LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void insertOrdered(int newValue) {
        Node newNode = new Node(newValue);

        if (head == null || newValue <= head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data < newValue) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

 class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting some initial values in sorted order
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.insertOrdered(30);

        System.out.println("Original Linked List:");
        list.display();

        int newValue = 15;
        list.insertOrdered(newValue);

        System.out.println("Linked List after inserting " + newValue + " in ordered way:");
        list.display();
    }
}

//Write a program to demonstrate a method to delete the node at first position in a singly LinkedList
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

 class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting some initial values
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);

        System.out.println("Original Linked List:");
        list.display();

        list.deleteFirst();

        System.out.println("Linked List after deleting the first node:");
        list.display();
    }
}

//Write a program to demonstrate a method to delete the node at last position in a singly LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

 class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting some initial values
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);

        System.out.println("Original Linked List:");
        list.display();

        list.deleteLast();

        System.out.println("Linked List after deleting the last node:");
        list.display();
    }
}

//Write a program to demonstrate a method to delete the node with a value entered by user in a singly LinkedList.
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void deleteNode(int valueToDelete) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.data == valueToDelete) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.data != valueToDelete) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found in the list.");
        } else {
            previous.next = current.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

 class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        // Inserting some initial values
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = new Node(40);

        System.out.println("Original Linked List:");
        list.display();

        System.out.print("Enter the value to delete: ");
        int valueToDelete = scanner.nextInt();

        list.deleteNode(valueToDelete);

        System.out.println("Linked List after deleting " + valueToDelete + ":");
        list.display();

        scanner.close();
    }
}

//Write a program to demonstrate a method insert at first to add node in first position of a circular LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public void insertAtFirst(int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            newNode.next = newNode; // Circular reference to itself
            head = newNode;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println(" (head)");
    }
}

 class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Inserting some initial values
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtFirst(30);

        System.out.println("Original Circular Linked List:");
        list.display();

        int newValue = 5;
        list.insertAtFirst(newValue);

        System.out.println("Circular Linked List after inserting " + newValue + " at first position:");
        list.display();
    }
}

//Write a program to demonstrate a method insert at last to add node in last position of a circular LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public void insertAtLast(int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            newNode.next = newNode; // Circular reference to itself
            head = newNode;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println(" (head)");
    }
}

 class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Inserting some initial values
        list.insertAtLast(10);
        list.insertAtLast(20);
        list.insertAtLast(30);

        System.out.println("Original Circular Linked List:");
        list.display();

        int newValue = 40;
        list.insertAtLast(newValue);

        System.out.println("Circular Linked List after inserting " + newValue + " at last position:");
        list.display();
    }
}

//Write a program to demonstrate a method insert before particular value to add node in before the value entered by user in a circular LinkedList
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public void insertBefore(int valueToInsertBefore, int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            System.out.println("Circular Linked List is empty. Cannot insert before.");
            return;
        }

        Node current = head;
        Node previous = null;

        do {
            if (current.data == valueToInsertBefore) {
                newNode.next = current;
                if (previous == null) {
                    // Inserting before the head
                    Node tail = head;
                    while (tail.next != head) {
                        tail = tail.next;
                    }
                    tail.next = newNode;
                    head = newNode;
                } else {
                    previous.next = newNode;
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Value not found in the list.");
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(head)");
    }
}

 class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        // Inserting some initial values
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = list.head;

        System.out.println("Original Circular Linked List:");
        list.display();

        System.out.print("Enter the value before which you want to insert: ");
        int valueToInsertBefore = scanner.nextInt();

        System.out.print("Enter the new value to insert: ");
        int newValue = scanner.nextInt();

        list.insertBefore(valueToInsertBefore, newValue);

        System.out.println("Circular Linked List after inserting " + newValue + " before " + valueToInsertBefore + ":");
        list.display();

        scanner.close();
    }
}

//Write a program to demonstrate a method insert after particular value to add node in after the value entered by user in a circular LinkedList.
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public void insertAfter(int valueToInsertAfter, int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            System.out.println("Circular Linked List is empty. Cannot insert after.");
            return;
        }

        Node current = head;

        do {
            if (current.data == valueToInsertAfter) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Value not found in the list.");
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(head)");
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        // Inserting some initial values
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = list.head;

        System.out.println("Original Circular Linked List:");
        list.display();

        System.out.print("Enter the value after which you want to insert: ");
        int valueToInsertAfter = scanner.nextInt();

        System.out.print("Enter the new value to insert: ");
        int newValue = scanner.nextInt();

        list.insertAfter(valueToInsertAfter, newValue);

        System.out.println("Circular Linked List after inserting " + newValue + " after " + valueToInsertAfter + ":");
        list.display();

        scanner.close();
    }
}

//Write a program to demonstrate a method to insert a node in ordered way in a circular LinkedList.
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public void insertOrdered(int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            newNode.next = newNode; // Circular reference to itself
            head = newNode;
        } else if (newValue <= head.data) {
            // Insert at the beginning if the new value is less than or equal to the head
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        } else {
            Node current = head;
            Node previous = null;

            do {
                if (current.data >= newValue) {
                    newNode.next = current;
                    previous.next = newNode;
                    return;
                }
                previous = current;
                current = current.next;
            } while (current != head);

            // If we reach here, the new value is the largest, so insert it at the end
            newNode.next = head;
            previous.next = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(head)");
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements to insert: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int value = scanner.nextInt();
            list.insertOrdered(value);
        }

        System.out.println("Circular Linked List after inserting elements in an ordered way:");
        list.display();

        scanner.close();
    }
}

//Write a program to demonstrate a method to delete the node at first position in a circular LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Circular Linked List is empty. Nothing to delete.");
            return;
        }

        if (head.next == head) {
            head = null; // Single node circular list
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            head = head.next;
            tail.next = head;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(head)");
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Inserting some initial values
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = list.head;

        System.out.println("Original Circular Linked List:");
        list.display();

        list.deleteFirst();

        System.out.println("Circular Linked List after deleting the first node:");
        list.display();
    }
}

//Write a program to demonstrate a method to delete the node at last position in a circular LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public void deleteLast() {
        if (head == null) {
            System.out.println("Circular Linked List is empty. Nothing to delete.");
            return;
        }

        if (head.next == head) {
            head = null; // Single node circular list
            return;
        }

        Node current = head;
        Node previous = null;

        while (current.next != head) {
            previous = current;
            current = current.next;
        }

        previous.next = head;
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(head)");
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Inserting some initial values
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = list.head;

        System.out.println("Original Circular Linked List:");
        list.display();

        list.deleteLast();

        System.out.println("Circular Linked List after deleting the last node:");
        list.display();
    }
}

//Write a program to demonstrate a method to delete the node with a value entered by user in a circular LinkedList.
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public void deleteNode(int valueToDelete) {
        if (head == null) {
            System.out.println("Circular Linked List is empty. Nothing to delete.");
            return;
        }

        if (head.data == valueToDelete) {
            if (head.next == head) {
                head = null; // Single node circular list
            } else {
                Node tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                head = head.next;
                tail.next = head;
            }
            return;
        }

        Node current = head;
        Node previous = null;

        do {
            if (current.data == valueToDelete) {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Value not found in the list.");
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(head)");
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements to insert: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int value = scanner.nextInt();
            list.insertOrdered(value);
        }

        System.out.println("Circular Linked List:");
        list.display();

        System.out.print("Enter the value to delete: ");
        int valueToDelete = scanner.nextInt();

        list.deleteNode(valueToDelete);

        System.out.println("Circular Linked List after deleting " + valueToDelete + ":");
        list.display();

        scanner.close();
    }
}

//Write a program to demonstrate a method insert at first to add node in first position of a doubly LinkedList.
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void insertAtFirst(int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            // If the list is empty, set both head and tail to the new node
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Inserting some initial values
        list.insertAtFirst(30);
        list.insertAtFirst(20);
        list.insertAtFirst(10);

        System.out.println("Original Doubly Linked List:");
        list.display();

        int newValue = 5;
        list.insertAtFirst(newValue);

        System.out.println("Doubly Linked List after inserting " + newValue + " at first position:");
        list.display();
    }
}

//Write a program to demonstrate a method insert at last to add node in last position of a doubly LinkedList
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void insertAtLast(int newValue) {
        Node newNode = new Node(newValue);

        if (tail == null) {
            // If the list is empty, set both head and tail to the new node
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Inserting some initial values
        list.insertAtLast(10);
        list.insertAtLast(20);
        list.insertAtLast(30);

        System.out.println("Original Doubly Linked List:");
        list.display();

        int newValue = 40;
        list.insertAtLast(newValue);

        System.out.println("Doubly Linked List after inserting " + newValue + " at last position:");
        list.display();
    }
}

//Write a program to demonstrate a method insert before particular value to add node in before the value entered by user in a doubly LinkedList.
import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void insertBefore(int valueToInsertBefore, int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            System.out.println("Doubly Linked List is empty. Cannot insert before.");
            return;
        }

        Node current = head;

        while (current != null) {
            if (current.data == valueToInsertBefore) {
                if (current == head) {
                    // Insert before the head
                    newNode.next = current;
                    current.prev = newNode;
                    head = newNode;
                } else {
                    newNode.prev = current.prev;
                    newNode.next = current;
                    current.prev.next = newNode;
                    current.prev = newNode;
                }
                return;
            }
            current = current.next;
        }

        System.out.println("Value not found in the list.");
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        // Inserting some initial values
        list.insertAtLast(10);
        list.insertAtLast(20);
        list.insertAtLast(30);

        System.out.println("Original Doubly Linked List:");
        list.display();

        System.out.print("Enter the value before which you want to insert: ");
        int valueToInsertBefore = scanner.nextInt();

        System.out.print("Enter the new value to insert: ");
        int newValue = scanner.nextInt();

        list.insertBefore(valueToInsertBefore, newValue);

        System.out.println("Doubly Linked List after inserting " + newValue + " before " + valueToInsertBefore + ":");
        list.display();

        scanner.close();
    }
}

//Write a program to demonstrate a method insert after particular value to add node in after the value entered by user in a doubly LinkedList.
import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void insertAfter(int valueToInsertAfter, int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            System.out.println("Doubly Linked List is empty. Cannot insert after.");
            return;
        }

        Node current = head;

        while (current != null) {
            if (current.data == valueToInsertAfter) {
                if (current == tail) {
                    // Insert after the tail
                    newNode.prev = current;
                    current.next = newNode;
                    tail = newNode;
                } else {
                    newNode.prev = current;
                    newNode.next = current.next;
                    current.next.prev = newNode;
                    current.next = newNode;
                }
                return;
            }
            current = current.next;
        }

        System.out.println("Value not found in the list.");
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        // Inserting some initial values
        list.insertAtLast(10);
        list.insertAtLast(20);
        list.insertAtLast(30);

        System.out.println("Original Doubly Linked List:");
        list.display();

        System.out.print("Enter the value after which you want to insert: ");
        int valueToInsertAfter = scanner.nextInt();

        System.out.print("Enter the new value to insert: ");
        int newValue = scanner.nextInt();

        list.insertAfter(valueToInsertAfter, newValue);

        System.out.println("Doubly Linked List after inserting " + newValue + " after " + valueToInsertAfter + ":");
        list.display();

        scanner.close();
    }
}

//Write a program to demonstrate a method to insert a node in ordered way in a doubly LinkedList.
import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void insertOrdered(int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            // If the list is empty, set both head and tail to the new node
            head = tail = newNode;
        } else if (newValue <= head.data) {
            // Insert at the beginning if the new value is less than or equal to the head
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = head;

            while (current != null) {
                if (current.data >= newValue) {
                    newNode.prev = current.prev;
                    newNode.next = current;
                    if (current.prev != null) {
                        current.prev.next = newNode;
                    }
                    current.prev = newNode;
                    return;
                }
                current = current.next;
            }

            // If we reach here, the new value is the largest, so insert it at the end
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements to insert: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int value = scanner.nextInt();
            list.insertOrdered(value);
        }

        System.out.println("Doubly Linked List after inserting elements in an ordered way:");
        list.display();

        scanner.close();
    }
}

//Write a program to demonstrate a method to delete the node at first position in a doubly LinkedList.
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Doubly Linked List is empty. Nothing to delete.");
            return;
        }

        if (head == tail) {
            // If there is only one node in the list
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Inserting some initial values
        list.insertAtLast(10);
        list.insertAtLast(20);
        list.insertAtLast(30);

        System.out.println("Original Doubly Linked List:");
        list.display();

        list.deleteFirst();

        System.out.println("Doubly Linked List after deleting the first node:");
        list.display();
    }
}

//Write a program to demonstrate a method to delete the node at last position in a doubly LinkedList.
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void deleteLast() {
        if (head == null) {
            System.out.println("Doubly Linked List is empty. Nothing to delete.");
            return;
        }

        if (head == tail) {
            // If there is only one node in the list
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Inserting some initial values
        list.insertAtLast(10);
        list.insertAtLast(20);
        list.insertAtLast(30);

        System.out.println("Original Doubly Linked List:");
        list.display();

        list.deleteLast();

        System.out.println("Doubly Linked List after deleting the last node:");
        list.display();
    }
}

//Write a program to demonstrate a method to delete the node with a value entered by user in a doubly LinkedList.
import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void deleteNode(int valueToDelete) {
        if (head == null) {
            System.out.println("Doubly Linked List is empty. Nothing to delete.");
            return;
        }

        Node current = head;

        while (current != null) {
            if (current.data == valueToDelete) {
                if (current == head) {
                    // Deleting the head node
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null; // List is empty after deletion
                    }
                } else if (current == tail) {
                    // Deleting the tail node
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }

        System.out.println("Value not found in the list.");
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        // Inserting some initial values
        list.insertAtLast(10);
        list.insertAtLast(20);
        list.insertAtLast(30);

        System.out.println("Original Doubly Linked List:");
        list.display();

        System.out.print("Enter the value to delete: ");
        int valueToDelete = scanner.nextInt();

        list.deleteNode(valueToDelete);

        System.out.println("Doubly Linked List after deleting " + valueToDelete + ":");
        list.display();

        scanner.close();
    }
}

//Write a program to delete duplicate values from a given singly LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void deleteDuplicates() {
        if (head == null || head.next == null) {
            return; // No duplicates to delete in an empty or single-node list
        }

        Node current = head;

        while (current != null) {
            Node runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    // Duplicate found, remove the node
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Inserting some values with duplicates
        list.insert(10);
        list.insert(20);
        list.insert(10);
        list.insert(30);
        list.insert(20);

        System.out.println("Original Singly Linked List:");
        list.display();

        list.deleteDuplicates();

        System.out.println("Singly Linked List after deleting duplicates:");
        list.display();
    }
}

//Write a program to delete only even values from a given singly LinkedList
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void deleteEvenValues() {
        if (head == null) {
            return; // Nothing to delete in an empty list
        }

        // Handle cases where even values are at the beginning of the list
        while (head != null && head.data % 2 == 0) {
            head = head.next;
        }

        if (head == null) {
            return; // List is empty after removing even values
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data % 2 == 0) {
                // Delete the even node
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Inserting some values with even and odd numbers
        list.insert(10);
        list.insert(5);
        list.insert(20);
        list.insert(30);
        list.insert(15);
        list.insert(25);
        list.insert(12);

        System.out.println("Original Singly Linked List:");
        list.display();

        list.deleteEvenValues();

        System.out.println("Singly Linked List after deleting even values:");
        list.display();
    }
}

//Write a program to delete only odd values from a given singly LinkedList
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void deleteOddValues() {
        if (head == null) {
            return; // Nothing to delete in an empty list
        }

        // Handle cases where odd values are at the beginning of the list
        while (head != null && head.data % 2 != 0) {
            head = head.next;
        }

        if (head == null) {
            return; // List is empty after removing odd values
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data % 2 != 0) {
                // Delete the odd node
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Inserting some values with even and odd numbers
        list.insert(10);
        list.insert(5);
        list.insert(20);
        list.insert(30);
        list.insert(15);
        list.insert(25);
        list.insert(12);

        System.out.println("Original Singly Linked List:");
        list.display();

        list.deleteOddValues();

        System.out.println("Singly Linked List after deleting odd values:");
        list.display();
    }
}

//Write a program to delete odd positioned nodes from a given singly LinkedList.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void deleteOddPositionedNodes() {
        if (head == null || head.next == null) {
            return; // No nodes to delete or only one node in the list
        }

        Node current = head;

        while (current != null && current.next != null) {
            current.next = current.next.next; // Delete the node at the odd position
            current = current.next; // Move to the next node
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Inserting some values
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);

        System.out.println("Original Singly Linked List:");
        list.display();

        list.deleteOddPositionedNodes();

        System.out.println("Singly Linked List after deleting odd positioned nodes:");
        list.display();
    }
}

//Write a program to delete even positioned nodes from a given singly LinkedList 
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void deleteEvenPositionedNodes() {
        if (head == null || head.next == null) {
            return; // No nodes to delete or only one node in the list
        }

        Node current = head;
        Node prev = null;
        int position = 1;

        while (current != null) {
            if (position % 2 == 0) {
                // Delete the even positioned node
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
            position++;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Inserting some values
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);

        System.out.println("Original Singly Linked List:");
        list.display();

        list.deleteEvenPositionedNodes();

        System.out.println("Singly Linked List after deleting even positioned nodes:");
        list.display();
    }
}

