/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    private int ticketCount = 0;
    private double discount ;
    private int actualPrice;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */ 
    public TicketMachine(int price)
    {   
        if (price >= 0){
            this.price = price;
        } else {
            System.out.println("Price can't be negative");
            price = 0;
        }

        balance = 0;
        total = 0;
        
        setDiscount(0.2);
    }

    public void setDiscount(double discount){
        this.discount = discount;
        int saving = (int)(price * discount);
        actualPrice = price - saving;
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    public int getTicketCounter()
    {
        return ticketCount;
    }

    public int getTotal(){
        return total;
    }
    public int getMean(){
        // Assignment 5:
        int mean = total/ticketCount;
        // Assignment 6: this method returns the mean,
        // such that it can be used by other classes.
        // note that the mean is computed every time
        // this method is called.
        return mean;
    }
    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(int amount)
    {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Please insert a positive amount");
        }
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        int price = actualPrice;
        if (balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
            ticketCount++;
            // Update the total collected
            total = total + price;
            // Update the balance.
            balance = balance - price;
        } else{
            System.out.println("Not enough money inserted");
            System.out.println("You've inserted " + balance);
            System.out.println("Ticket price is " + price);

        } 
    }

    public int refundBalance(){
        int balance = this.balance;
        this.balance = 0;
        return balance;
    }

    
    
    
}
