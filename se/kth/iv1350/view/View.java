package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.ItemDTO;


/**
 * The View class is responsible for displaying information to the user.
 * It interacts with the Controller to perform operations and retrieve data.
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance of View.
     * 
     * @param contr The Controller instance to interact with.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * This method simulates a sample execution of the application.
     * It demonstrates adding items to a sale, ending the sale, and processing payment.
     */
    public void sampleExecution() {
        contr.startNewSale();
        
        System.out.println("Add 1 item with item id abc123:");
        System.out.println(formatItemInfo(contr.addItem("abc123")));
        
        System.out.println("\nAdd 1 item with item id abc123:");
        System.out.println(formatItemInfo(contr.addItem("abc123")));
        
        System.out.println("\nAdd 1 item with item id def456:");
        System.out.println(formatItemInfo(contr.addItem("def456")));
        
        System.out.println("\nEnd sale:");
        double total = contr.endSale();
        System.out.println("Total cost (incl VAT): " + total + " SEK");
        
        double cash = 100.0;
        System.out.println("\nCash: " + cash + " SEK");
        double change = contr.pay(cash);
        System.out.printf("Change to give the customer: %.2f SEK%n", change);
    }

    private String formatItemInfo(ItemDTO item) {
        if (item == null) {
            return "Item not found";
        }
        
        return String.format(
            "Item ID: %s\nItem name: %s\nItem cost: %.2f SEK\nVAT: %.0f%%\nItem description: %s\n\n" +
            "Total cost (incl VAT): %.2f SEK\nTotal VAT: %.2f SEK",
            item.getItemID(),
            item.getName(),
            item.getCost(),
            item.getVat() * 100,
            item.getDescription(),
            contr.getRunningTotal(),
            contr.getTotalVAT()
        );
    }
}