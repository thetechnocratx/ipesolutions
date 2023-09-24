
/*
    * 
    * 
    * 
    * Question Number = 1
    * 
    * 
    * 
    * 
    */
import java.util.*;

class Stack {
    Scanner scan = new Scanner(System.in);
    int[] stack;
    int top, n; // n -> Size

    Stack() {
        System.out.print("Enter Size of Stack : ");
        n = scan.nextInt();
        top = -1;
        stack = new int[n];
    }

    void push(int x) {
        // x -> element
        if (top >= n - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = x;
        System.out.println("Inserted element is : " + stack[top]);
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return;
        }
        System.out.println("Deleted elemement is : " + stack[top--]);
    }

    void peep(int i) {
        // i -> index
        if (top - i + 1 <= -1) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println("Element at " + i + "th index from top is : " + stack[top - i + 1]);
    }

    void change(int x, int i) {
        if (top - i + 1 <= -1) {
            System.out.println("Stack Underflow");
            return;
        }
        stack[top - i + 1] = x;
        System.out.println("Element changed at " + i + "th index from top is : " + stack[top - i + 1]);
    }

    void display() {
        System.out.println("Stack : ");
        for (int i = top; i > -1; i--) {
            System.out.println(stack[i]);
        }
    }
}

class Main {
    // via Recursion
    Stack s = new Stack();
    Scanner scan = new Scanner(System.in);

    void options() {
        System.out.print("""
                Enter 0 : EXIT
                Enter 1 : Push an element
                Enter 2 : Pop an element
                Enter 3 : Peep an element
                Enter 4 : Change an element
                Enter 5 : Display Stack
                """);
        int choice = scan.nextInt();
        switch (choice) {
            case 0 -> {
                System.out.println("Exit");
                return;
            }
            case 1 -> {
                System.out.print("Enter element : ");
                int x = scan.nextInt();
                s.push(x);
            }
            case 2 -> {
                s.pop();
            }
            case 3 -> {
                int i;
                do {
                    System.out.print("Enter index : ");
                    i = scan.nextInt();
                    if (i <= 0) {
                        System.out.println("Invalid Index");
                    }
                } while (i <= 0);
                s.peep(i);
            }
            case 4 -> {
                int i;
                do {
                    System.out.print("Enter index : ");
                    i = scan.nextInt();
                    if (i <= 0) {
                        System.out.println("Invalid Index");
                    }
                } while (i <= 0);
                System.out.print("Enter element : ");
                int x = scan.nextInt();
                s.change(x, i);
            }
            case 5 -> {
                s.display();
            }
            default -> System.out.print("Enter a valid choice");
        }
        options();
        System.out.println();
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.options();
    }
}

/*
 * 
 * 
 * 
 * Question Number = 2
 * 
 * 
 * 
 * 
 */

class QueueUsingArray {
    int[] queue;
    int front, rear;

    public QueueUsingArray(int size) {
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    void enQueue(int element) {
        if (rear == queue.length - 1) {
            System.out.println("Overflow");
        } else {
            if (front == -1) {
                front = 0;
            }
            queue[++rear] = element;
            System.out.println("Inserted Element : " + queue[rear]);
        }
    }

    void deQueue() {
        if (front == -1) {
            System.out.println("Underflow");
        } else {
            int element = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
                System.out.println("Queue Reset");
            } else {
                front++;
            }
            System.out.println("Deleted element : " + element);
        }
    }

    // Method to get the front element of the queue (without removing it)
    public int getFront() {
        if (front <= rear) {
            System.out.println("Front element of the queue: " + queue[front]);
            return queueArray[front];
        } else {
            System.out.println("Queue is empty. Cannot get front element.");
            return -1; // Return a sentinel value for an empty queue
        }
    }

    // Method to get the rear element of the queue (without removing it)
    public int getRear() {
        if (front <= rear) {
            System.out.println("Rear element of the queue: " + queue[rear]);
            return queueArray[rear];
        } else {
            System.out.println("Queue is empty. Cannot get rear element.");
            return -1; // Return a sentinel value for an empty queue
        }
    }

    void display() {
        if (front == -1) {
            System.out.println("Underflow");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

/*
 * 
 * 
 * 
 * Question Number = 3
 * 
 * 
 * 
 * 
 */
public class DeQueUsingArray {
    int[] queue;
    int front, rear;

    DeQueUsingArray(int size) {
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    void enQueueAtRear(int element) {
        if ((rear + 1) % queue.length == front) {
            System.out.println("Overflow");
        } else {
            rear = (rear + 1) % queue.length;
            queue[rear] = element;
            if (front == -1) {
                front = 0;
            }
            System.out.println("Inserted element : " + queue[rear]);
        }
    }

    void enQueueAtFront(int element) {
        if ((front - 1) % queue.length == rear) {
            System.out.println("Overflow");
        } else {
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (front == 0) {
                front = queue.length - 1;
            } else {
                front = (front - 1) % queue.length;
            }
            queue[front] = element;
            System.out.println("Inserted element : " + queue[front]);
        }
    }

    void deQueueAtFront() {
        if (front == -1) {
            System.out.println("Underflow");
        } else {
            System.out.println("Deleted Element : " + queue[front]);
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % queue.length;
            }
        }
    }

    void deQueueAtRear() {
        if (front == -1) {
            System.out.println("Underflow");
        } else {
            System.out.println("Deleted Element : " + queue[rear]);
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (rear == 0) {
                rear = queue.length - 1;
            } else {
                rear = (rear - 1) % queue.length;
            }
        }
    }

    // Method to get the front element of the deque
    public int getFront() {
        if (front >= 0) {
            System.out.println("Front element of the deque: " + deque[front]);
            return deque[front];
        } else {
            System.out.println("Deque is empty. Cannot get front element.");
            return -1; // Return a sentinel value for an empty deque
        }
    }

    // Method to get the rear element of the deque
    public int getRear() {
        if (rear >= 0) {
            System.out.println("Rear element of the deque: " + deque[rear]);
            return deque[rear];
        } else {
            System.out.println("Deque is empty. Cannot get rear element.");
            return -1; // Return a sentinel value for an empty deque
        }
    }

    void display() {
        if (front == -1) {
            System.out.println("underflow");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(queue[i]);
                i = (i + 1) % queue.length;
            }
            System.out.println(queue[rear]);
        }
        System.out.println();
    }
}

/*
 * 
 * 
 * 
 * Question Number = 4
 * 
 * 
 * 
 * 
 */

// Write a Java program to implement operations on CIRCULAR QUEUE//
import java.util.*;

class Run
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Queue - "); //Here are we are asking the user to enter the queue size//
        int size = sc.nextInt();
        MyQueue q = new MyQueue(size); //created an object of class MyQueue & called parameterized constructor//
        int choice = 0;
        do{
            System.out.println("Enter choice of your prefered operation - ");
            choice = sc.nextInt();
            switch(choice) //using a switch case we are asking user to enter the choice operation to be performed on queue//
            {
                case 1: q.enqueue();
                break;
                
                case 2: q.dequeue();
                break;

                case 3: q.print();
                break;
                
                case 4: break;
            }
        }while(choice != 4); //until the user enters choice value 4 the loop will run continuously//
    }
}

class MyQueue {
    Scanner sc = new Scanner(System.in);
    int rear;
    int front;
    int size;
    int a[];

    MyQueue(int s) // created a parameterized constructor//
    {
        a = new int[s];
        rear = -1;
        front = -1;
        size = s;
    }

    void enqueue() // created a method which will let us insert the elements//
    {
        if ((front - 1 == rear) || (front == 0 && rear == size - 1)) // here we are checking the overflow condition//
        {
            System.out.println("Overflow");
        } else // if queue is not overflow then//
        {
            if (front == -1) // Are we adding an element for the 1st time? //
            {
                front = 0; // shifting front pointer to 0//
            }
            System.out.println("Enter no to be inserted - ");
            int num = sc.nextInt();
            rear = (rear + 1) % size;
            a[rear] = num;
        }
    }

    void dequeue() // created a method which will let us delete the element//
    {
        if (front == -1) // here we are checking the underflow condition//
        {
            System.out.println("Empty");
        } else // if queue is not underflow then//
        {
            int num;
            num = a[front];
            if (front == rear) // if queue has only one element, we need to reset it//
            {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            System.out.println("Deleted element ->" + num);
        }
    }

    int getFront() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queue[front];
        }
    }

    int getRear() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queue[rear];
        }
    }

    void print() // created a method which will display the queue element//
    {
        int i;
        if (front == -1) // checking if the queue is empty or not//
        {
            System.out.println("The queue is empty.");
        } else {
            for (i = front; i != rear; i = (i + 1) % size) // the loop will only run untill it reaches rear//
            {
                System.out.println(a[i] + " - "); // hence all values will be printed except rear//
            }
            System.out.println(a[i]); // separate SOP to print last element (Rear)//
        }
    }
}

/*
 * 
 * 
 * 
 * Question Number = 5
 * 
 * 
 * 
 * 
 */

import java.util.Stack;

public class PostfixEvaluator {
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert character to integer and push onto the stack
            } else if (ch != ' ') { // Skip spaces
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;

                switch (ch) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }

                stack.push(result);
            }
        }

        if (stack.size() == 1) {
            return stack.pop();
        } else {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
    }

    public static void main(String[] args) {
        String postfixExpression = "23*5+";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}

/*
 * 
 * 
 * 
 * Question Number = 6
 * 
 * 
 * 
 * 
 */

class Main {
    static boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();

        // iterate over the expression in reverse order
        for (int i = expression.length() - 1; i >= 0; i--) {

            // if the character is an operator, pop two elements from the stack, perform the
            // operation, and insert the result back to the stack
            if (isOperator(expression.charAt(i))) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (expression.charAt(i)) {
                    case '+':
                        stack.insert(operand1 + operand2);
                        break;
                    case '-':
                        stack.insert(operand1 - operand2);
                        break;
                    case '*':
                        stack.insert(operand1 * operand2);
                        break;
                    case '/':
                        if (operand2 != 0) {
                            stack.insert(operand1 / operand2);
                        } else {
                            System.out.println("Cannot divide by zero");
                            return -1;
                        }
                        break;
                }
            } else if (Character.isDigit(expression.charAt(i))) {
                // if the character is a digit, insert it to the stack
                stack.insert(expression.charAt(i) - '0');
            }
        }

        // if the expression was valid, the final result should be the only element left
        // in the stack
        if (stack.size() == 1) {
            return stack.pop();
        } else {
            System.out.println("Invalid expression");
            return -1;
        }
    }

    public static void main(String[] args) {
        String expression = "*+23/46";
        System.out.println(evaluatePrefix(expression));
    }
}

/*
 * 
 * 
 * 
 * Question Number = 7
 * 
 * 
 * 
 * 
 */

import java.util.*;

class SLL // operation class//
{
    class Node // created a nested class//
    {
        int data;
        Node next; // created a reference variable//

        Node(int data) // created a parameterized constructor//
        {
            this.data = data;
            next = null; // set the initial value of reference variable as null//
        }
    }

    Node First = null; // created another reference variable First with value null//

    void addFirst(int data) // created a method to insert the data at First in Linked List//
    {
        Node n = new Node(data); // created a node n//
        if (First == null) {
            First = n;
        } else {
            n.next = First; // the value for First shall be given to n's next//
            First = n; // now the new value of First shall be new node n's address//
        }
    }

    void display() // created a method to display the elements of Linked List//
    {
        Node temp = First; // created another reference variable temp which will have the same value as
                           // first//
        while (temp != null) // until we get the temp = null this loop will run//
        {
            System.out.print(temp.data + "-");
            temp = temp.next;
        }
        System.out.println("NULL"); // every linked list has the last reference as null//
    }

    /*
     * 
     * 
     * 
     * Question Number = 8
     * 
     * 
     * 
     * 
     */

    void addLast(int data) // created a method to insert the data at last in Linkedlist//
    {
        Node n = new Node(data); // created a node n//
        if (First == null) // checking if the value of first is null or not//
        {
            First = n; // then the value of new node n shall be given to First//
        } else {
            Node temp = First;
            while (temp.next != null) // untill temp's next is not null//
            {
                temp = temp.next;
            }
            temp.next = n; // once temp's next is null then new node n's value assigned to temp's next//
        }
    }
    /*
     * 
     * 
     * 
     * Question Number = 9
     * 
     * 
     * 
     * 
     */

    void insertBeforeValue(int data, int value) // created a method to add the value before a particular value in the
                                                // linked list
    {

        int flag = 0;
        if (First == null) {
            System.out.println("Linked is empty");
        } else {
            Node dummy = First;
            while (dummy != null) {
                if (dummy.data == value) {
                    flag = 1;
                }
                dummy = dummy.next;
            }
            if (flag == 0) {
                System.out.println("The asked value is not inside the linked list");
            } else {
                Node n = new Node(data);
                if (First.next == null) {
                    System.out.println("It will be inserted at first");
                    addFirst(data);
                } else if (First.data == value) {
                    addFirst(data);
                } else {
                    Node temp = First;
                    while (temp.next.data != value) {
                        temp = temp.next;
                    }
                    n.next = temp.next;
                    temp.next = n;
                }
            }
        }
    }
    /*
     * 
     * 
     * 
     * Question Number = 10
     * 
     * 
     * 
     * 
     */

    void insertAfterValue(int data, int value) // created a method to add the value after a particular value in the
                                               // linked list//
    {

        int flag = 0;
        if (First == null) {
            System.out.println("Linked is empty");
        } else {
            Node dummy = First;
            while (dummy != null) {
                if (dummy.data == value) {
                    flag = 1;
                }
                dummy = dummy.next;
            }
            if (flag == 0) {
                System.out.println("The asked value is not inside the linked list");
            } else {
                Node n = new Node(data);
                if (First.data == value && First.next == null) {
                    First.next = n;
                } else if (First.data == value) {
                    n.next = First.next;
                    First.next = n;
                } else {
                    Node temp = First;
                    while (temp.data != value) {
                        temp = temp.next;
                    }
                    n.next = temp.next;
                    temp.next = n;
                }
            }
        }
    }

    /*
     * 
     * 
     * 
     * Question Number = 11
     * 
     * 
     * 
     * 
     */

    /* Inserts a new Node in order in this list. */
    public void insertInOrder(int data) {
        /* Allocate the Node & Put in the data */
        Node n = new Node(data);

        /* Special case for First node */
        if (First == null || First.data >= n.data) {
            n.next = First;
            First = n;
        } else {

            /* Locate the node before point of insertion */
            Node current = First;

            while (current.next != null && current.next.data < n.data) {
                current = current.next;
            }

            n.next = current.next;
            current.next = n;
        }
    }
    /*
     * 
     * 
     * 
     * Question Number = 12
     * 
     * 
     * 
     * 
     */

    Node deleteFirst() // created a method to delete the element from the start of the linked list//
    {
        if (First == null) // checking for underflow condition//
        {
            System.out.println("Underflow");
            return null;
        } else {
            Node del = First;
            First = First.next;
            return del;
        }
    }
    /*
     * 
     * 
     * 
     * Question Number = 13
     * 
     * 
     * 
     * 
     */

    void deleteLast() // created a method to delete the element of a linked list from last//
    {
        if (First == null) // checking if the linked list is empty or not//
        {
            System.out.println("No Elements in LinkedList");
        } else {
            Node del = First;
            while (del.next.next != null) {
                del = del.next;
            }
            del.next = null;
        }
    }
    /*
     * 
     * 
     * 
     * Question Number = 14
     * 
     * 
     * 
     * 
     */

    void deleteValue(int value) // created a method to delete the particular value from the linked list//
    {
        int flag = 0;
        if (First == null) {
            System.out.println("Linked is empty");
        } else {
            Node dummy = First;
            while (dummy != null) // checking that the value we want to delete is already a part of linked list or
                                  // not//
            {
                if (dummy.data == value) {
                    flag = 1;
                }
                dummy = dummy.next;
            }
            if (flag == 0) {
                System.out.println("The asked value is not inside the linked list");
            } else {
                if (First.data == value && First.next == null) {
                    First = null;
                } else if (First.data == value) {
                    First = First.next;
                } else {
                    Node temp = First;
                    while (temp.next.data != value) {
                        temp = temp.next;
                    }
                    Node q = temp.next;
                    temp.next = q.next;
                    q = null;
                }
            }
        }
    }
}

class Run // created the run class to call the method by making objects//
{
    public static void main(String args[]) {
        SLL s = new SLL();
        s.addFirst(10);
        s.display();
        s.addFirst(5);
        s.display();
        s.addFirst(11);
        s.display();
        s.addLast(15);
        s.display();
        s.deleteFirst();
        s.display();
        s.deleteLast();
        s.display();
        s.insertBeforeValue(100, 5);
        s.display();
        s.insertAfterValue(200, 10);
        s.display();
        s.deleteValue(5);
        s.display();
        s.deleteValue(100);
        s.display();
    }
}
/*
 * 
 * 
 * 
 * Question Number = 15
 * 
 * 
 * 
 * 
 */

class CSLL {
    Node head = null;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    void addFirst(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            n.next = head;
        } else {
            Node temp = head;
            n.next = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = n;
            head = n;
        }
        System.out.println(n.data + " inserted at first");
    }
    /*
     * 
     * 
     * 
     * Question Number = 16
     * 
     * 
     * 
     * 
     */

    void addLast(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            n.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = n;
            n.next = head;
        }
        System.out.println(n.data + " inserted at last");
    }
    /*
     * 
     * 
     * 
     * Question Number = 17
     * 
     * 
     * 
     * 
     */

    void addBefore(int value, int data) {
        if (head == null) {
            System.out.println("Undeflow");
        } else {
            Node n = new Node(data);
            Node temp = head;
            do {
                if (temp.next.data == value) {
                    break;
                }
                temp = temp.next;
            } while (temp != head);
            if (temp == head && temp.next.data != value) {
                System.out.println("Data not found");
            } else {
                n.next = temp.next;
                temp.next = n;
                if (head.data == value) {
                    head = n;
                }
                System.out.println(data + " has been inserted before " + value);
            }
        }
    }
    /*
     * 
     * 
     * 
     * Question Number = 18
     * 
     * 
     * 
     * 
     */

    void addAfter(int value, int data) {
        if (head == null) {
            System.out.println("Undeflow");
        } else {
            Node n = new Node(data);
            Node temp = head;
            do {
                if (temp.data == value) {
                    break;
                }
                temp = temp.next;
            } while (temp != head);
            if (temp == head && temp.data != value) {
                System.out.println("Data not found");
            } else {
                Node a = temp.next;
                temp.next = n;
                n.next = a;
                System.out.println(data + " has been inserted after " + value);
            }
        }
    }
    /*
     * 
     * 
     * 
     * Question Number = 19
     * 
     * 
     * 
     * 
     */

    void addSort(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            if (head.data > data) {
                addFirst(data);
            } else {
                Node temp = head;
                do {
                    if (temp.next.data > data) {
                        break;
                    }
                    temp = temp.next;
                } while (temp.next != head);
                n.next = temp.next;
                temp.next = n;
            }
        }
    }
    /*
     * 
     * 
     * 
     * Question Number = 20
     * 
     * 
     * 
     * 
     */

    void deleteFirst() {
        if (head == null) {
            System.out.println("Undeflow");
        } else if (head.next == head) {
            System.out.println(head.data + " has been deleted from the first");
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            System.out.println(head.data + " has been deleted from the first");
            head = head.next;
            temp.next = head;
        }
    }
    /*
     * 
     * 
     * 
     * Question Number = 21
     * 
     * 
     * 
     * 
     */

    void deleteLast() {
        if (head == null) {
            System.out.println("Undeflow");
        } else if (head.next == head) {
            System.out.println(head.data + " has been deleted from the last");
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            System.out.println(temp.next.data + " has been deleted from the last");
            temp.next = null;
            temp.next = head;
        }
    }
    /*
     * 
     * 
     * 
     * Question Number = 22
     * 
     * 
     * 
     * 
     */

    void delete(int data) {
        if (head == null) {
            System.out.println("Undeflow");
        } else {
            Node temp = head;
            do {
                if (temp.next.data == data) {
                    break;
                }
                temp = temp.next;
            } while (temp != head);
            if (temp == head && temp.next.data != data) {
                System.out.println("Data not found");
            } else {
                temp.next = temp.next.next;
                if (head.data == data) {
                    head = head.next;
                }
                System.out.println(data + " has been deleted");
            }
        }
    }

    void display() {
        if (head == null) {
            System.out.println("Undeflow");
        } else {
            Node temp = head;
            do {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }

}

/*
 * 
 * 
 * 
 * Question Number = 23
 * 
 * 
 * 
 * 
 */

class DLL {
    Node head = null;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    void addFirst(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    /*
     * 
     * 
     * 
     * Question Number = 24
     * 
     * 
     * 
     * 
     */

    void addLast(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
    }

    /*
     * 
     * 
     * 
     * Question Number = 25
     * 
     * 
     * 
     * 
     */

    void addBefore(int value, int data) {
        Node n = new Node(data);
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                break;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("value Not found");
        } else {
            n.prev = temp.prev;
            if (temp.prev != null) {
                temp.prev.next = n;
            }
            if (temp.prev == null) {
                head = n;
            }
            temp.prev = n;
            n.next = temp;
        }
    }

    /*
     * 
     * 
     * 
     * Question Number = 26
     * 
     * 
     * 
     * 
     */

    void addAfter(int value, int data) {
        Node n = new Node(data);
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                break;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("value Not found");
        } else {
            n.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = n;
            }
            temp.next = n;
            n.prev = temp;
        }
    }

    /*
     * 
     * 
     * 
     * Question Number = 27
     * 
     * 
     * 
     * 
     */

    void addSort(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else if (head.data > data) {
            n.next = head;
            head.prev = n;
            head = n;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data > data) {
                    break;
                }
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next.prev = n;
            temp.next = n;
            n.prev = temp;
        }
    }

    /*
     * 
     * 
     * 
     * Question Number = 28
     * 
     * 
     * 
     * 
     */

    void deleteFirst() {
        if (head == null) {
            System.out.println("Underflow");
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    /*
     * 
     * 
     * 
     * Question Number = 29
     * 
     * 
     * 
     * 
     */

    void deleteLast() {
        if (head == null) {
            System.out.println("Underflow");
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
            temp.prev = null;
        }
    }

    /*
     * 
     * 
     * 
     * Question Number = 30
     * 
     * 
     * 
     * 
     */

    void delete(int data) {
        if (head == null) {
            System.out.println("Underflow");
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.data == data) {
                    break;
                }
                temp = temp.next;
            }
            if (temp.next == null && temp.data != data) {
                System.out.println("Data not found");
            } else {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                if (temp.prev == null) {
                    head = head.next;
                }
            }
        }
    }

}

/*
 * 
 * 
 * 
 * Question Number = 31
 * 
 * 
 * 
 * 
 */

class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    void removeDuplicates() {
        Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;

        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;

            while (ptr2.next != null) {
                if (ptr1.data == ptr2.next.data) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    /*
     * 
     * 
     * 
     * Question Number = 32
     * 
     * 
     * 
     * 
     */

    void removeEvenValues() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    /*
     * 
     * 
     * 
     * Question Number = 33
     * 
     * 
     * 
     * 
     */

    void removeOddValues() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            if (current.data % 2 != 0) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    void insert(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

class Main2 {
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(12);
        list.insert(11);
        list.insert(11);
        list.insert(12);
        list.insert(11);
        list.insert(10);

        System.out.println("Linked List before removing duplicates : \n ");
        list.printList();

        list.removeDuplicates();

        System.out.println("\nLinked List after removing duplicates : \n ");
        list.printList();
    }
}

/*
 * 
 * 
 * 
 * Question Number = 34
 * 
 * 
 * 
 * 
 */

class LinkedList2 {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    LinkedList2() {
        head = null;
    }

    // Function to insert a node at the end of the linked list
    void insert(int data) {
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

    // Function to delete nodes at odd positions
    void deleteOddNodes() {
        Node current = head;
        while (current != null && current.next != null) {
            current.next = current.next.next;
            current = current.next;
        }
    }

    // Function to display the linked list
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Main3 {
    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();

        // Insert some elements into the linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("Original Linked List:");
        list.display();

        // Delete nodes at odd positions
        list.deleteOddNodes();

        System.out.println("Linked List after deleting odd-positioned nodes:");
        list.display();
    }
}

/*
 * 
 * 
 * 
 * Question Number = 35
 * 
 * 
 * 
 * 
 */

class LinkedList3 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    LinkedList3() {
        head = null;
    }

    // Function to insert a node at the end of the linked list
    void insert(int data) {
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

    // Function to delete nodes at even positions
    void deleteEvenNodes() {
        Node current = head;
        Node prev = null;
        int position = 1;

        while (current != null) {
            if (position % 2 == 0) {
                // Delete even-positioned node
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
            position++;
        }
    }

    // Function to display the linked list
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Main4 {
    public static void main(String[] args) {
        LinkedList3 list = new LinkedList3();

        // Insert some elements into the linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("Original Linked List:");
        list.display();

        // Delete nodes at even positions
        list.deleteEvenNodes();

        System.out.println("Linked List after deleting even-positioned nodes:");
        list.display();
    }
}
