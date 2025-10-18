public class Ticket {

    private static int nextTicketID = 1; // Used to auto-assign a unique ID

    int ticketID;

    String userName;

    String issueDescription;

    // Constructor to create a new Ticket

    public Ticket(String userName, String issueDescription) {

        this.ticketID = nextTicketID++; // Assign the current ID, then increment for the next one

        this.userName = userName;

        this.issueDescription = issueDescription;

    }

    // A helper method to print the ticket details in a clean format

    @Override

    public String toString() {

        return "Ticket #" + ticketID + " [User: " + userName + ", Issue: " + issueDescription + "]";

    }

}
