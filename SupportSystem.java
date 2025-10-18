// 1. Import the necessary classes
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Main application for the IT Support Ticketing System.
 * This program will:
 * 1. Create a queue for Ticket objects.
 * 2. Prompt the user to enter 3 new tickets.
 * 3. Add those tickets to the queue.
 * 4. Process (remove) the first 2 tickets from the queue.
 * 5. Display any remaining tickets.
 */
public class SupportSystem {

    public static void main(String[] args) {

        // 2. Create a Queue to hold Ticket objects
        // We use LinkedList because it's a common class that "implements" the Queue interface
        Queue<Ticket> ticketQueue = new LinkedList<>();
        
        // We also need a Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // 3. Display a welcome message
        System.out.println("============================================");
        System.out.println(" Welcome to the IT Support Ticketing System ");
        System.out.println("============================================");

        // 4. Use a loop to get details for THREE tickets
        int ticketsToEnter = 3;
        for (int i = 0; i < ticketsToEnter; i++) {
            System.out.println("\nSubmitting Ticket " + (i + 1) + " of " + ticketsToEnter + ":");

            System.out.print("  Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("  Describe your issue: ");
            String issue = scanner.nextLine();

            // 5. Create a new Ticket and add it to the queue
            Ticket newTicket = new Ticket(name, issue);
            ticketQueue.add(newTicket); // .add() inserts the element at the tail of the queue

            System.out.println("--> Success! Your ticket has been added to the queue.");
        }

        System.out.println("\n--------------------------------------------");
        
        // 6. Print how many tickets are waiting
        System.out.println(ticketQueue.size() + " tickets are currently waiting in the queue.");
        System.out.println("--------------------------------------------\n");

        // 7. Simulate processing the FIRST TWO tickets
        System.out.println("A support agent is now processing tickets...");
        int ticketsToProcess = 2;

        for (int i = 0; i < ticketsToProcess; i++) {
            // First, check if the queue is empty
            if (ticketQueue.isEmpty()) {
                System.out.println("No more tickets to process.");
                break; // Stop the loop if the queue is empty
            }

            // 8. Remove the ticket from the front of the queue (FIFO)
            // .poll() retrieves AND removes the head (front) of the queue
            Ticket currentTicket = ticketQueue.poll(); 
            
            // 9. Print a message indicating which ticket is being resolved
            System.out.println("Resolving: " + currentTicket);
        }

        System.out.println("\n--------------------------------------------");
        
        // 10. Display all remaining tickets
        System.out.println(ticketQueue.size() + " tickets are still in the queue.");
        System.out.println("Remaining tickets: " + ticketQueue);
        System.out.println("--------------------------------------------");

        // Good practice: close the scanner when you're done
        scanner.close();
    }
}