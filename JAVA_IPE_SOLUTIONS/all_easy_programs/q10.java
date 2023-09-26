import java.util.Stack;

public class q10 {
    public static void main(String[] args) {
        // Create a Stack
        Stack<String> stack = new Stack<>();

        // Push three items onto the Stack
        stack.push("Item 1");
        stack.push("Item 2");
        stack.push("Item 3");

        // Perform two pop operations
        stack.pop();
        stack.pop();

        // Print the Stack
        System.out.println(stack);
    }
}
