import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    // Queue implementation
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addElements();
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    generatePermutations();
                    break;

                case 4:
                    generateCombinations();
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    
    static void addElements() {

        System.out.print("Enter number of elements to add: ");
        int n = input.nextInt();

        queue.clear();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter element " + i + ": ");
            queue.add(input.next());
        }
        System.out.println("Queue: " + queue);
    }

    
    static void displayQueue() {

        System.out.println("Queue: " + queue);
        if (queue.isEmpty()) return;
        System.out.println("Front: " + queue.peek());

        System.out.print("Dequeue 2 elements? (y/n): ");
        if (input.next().equalsIgnoreCase("y")) {
            for (int i = 0; i < 2 && !queue.isEmpty(); i++) {
                System.out.println("Removed: " + queue.poll());
            }
            System.out.println("Queue: " + queue);
        }
    }

    
    static void generatePermutations() {

        String[] items = queue.toArray(new String[0]);

        System.out.println("Queue: " + queue);
        System.out.println();
        System.out.print("Enter number of elements to arrange: ");
        int r = input.nextInt();
        System.out.println();

        Queue<String> work = new LinkedList<>(); 
        work.add("");
        int count = 0;

        while (!work.isEmpty()) {
            String path = work.poll();

            if (path.length() == r) {
                for (char c : path.toCharArray()) System.out.print(items[c - '0']);
                System.out.println();
                count++;
            } else {
                for (int i = 0; i < items.length; i++) {
                    if (path.indexOf('0' + i) < 0) work.add(path + i); 
                }
            }
        }

        System.out.println("\nTotal Permutations: " + count);
    }

    
    static void generateCombinations() {

        String[] items = queue.toArray(new String[0]);

        System.out.println("Queue: " + queue);
        System.out.println();
        System.out.print("Enter number of elements to select: ");
        int r = input.nextInt();
        System.out.println();

        Queue<String> work = new LinkedList<>(); 
        work.add("");
        int count = 0;

        while (!work.isEmpty()) {
            String path = work.poll();

            if (path.length() == r) {
                for (char c : path.toCharArray()) System.out.print(items[c - '0']);
                System.out.println();
                count++;
            } else {
                
                int start = path.isEmpty() ? 0 : path.charAt(path.length() - 1) - '0' + 1;
                for (int i = start; i < items.length; i++) work.add(path + i);
            }
        }

        System.out.println("\nTotal Combinations: " + count);
    }
}