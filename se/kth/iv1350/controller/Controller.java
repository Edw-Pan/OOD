package se.kth.iv1350.controller;

import se.kth.iv1350.integration.*;
import se.kth.iv1350.model.*;
import se.kth.iv1350.integration.Printer;

/**
 * The Controller class handles the interaction between the view, model, and external systems.
 * It manages sales, processes payments, and interacts with external accounting and inventory systems.
 */
public class Controller {
    private Sale sale;
    private final ExternalAccounting externalAccounting;
    private final ExternalInventory externalInventory;
    private final Printer printer;

    /**
     * Creates a new instance of Controller.
     * 
     * @param externalAccounting An instance of ExternalAccounting for accounting operations.
     * @param externalInventory An instance of ExternalInventory for inventory operations.
     * @param printer An instance of Printer for printing receipts.
     */
    public Controller(ExternalAccounting externalAccounting, 
                     ExternalInventory externalInventory, 
                     Printer printer) {
        this.externalAccounting = externalAccounting;
        this.externalInventory = externalInventory;
        this.printer = printer;
    }

    /**
     * Starts a new sale by initializing a new Sale object.
     */
    public void startNewSale() {
        this.sale = new Sale();
    }

    /**
     * Adds an item to the current sale.
     * 
     * @param itemID The ID of the item to be added.
     * @return The ItemDTO object representing the added item, or null if the item was not found.
     */
    public ItemDTO addItem(String itemID) {
        ItemDTO item = externalInventory.findItem(itemID);
        if (item != null) {
            sale.addItem(item);
        }
        return item;
    }  

    /**
     * Ends the current sale and returns the total amount due.
     * 
     * @return The total amount due for the sale.
     */
    public double endSale() {
        return sale.getRunningTotal();
    }

    /**
     * Processes the payment for the current sale.
     * 
     * @param amount The amount paid by the customer.
     * @return The change to be returned to the customer.
     */
    public double pay(double amount) {
        Payment payment = sale.processPayment(amount);
        payment.completePayment(externalAccounting, externalInventory, printer);
        return payment.getChange();
    }

    /**
     * Gets the running total of the current sale.
     * 
     * @return The total amount due for the sale.
     */
    public double getRunningTotal() {
        return sale.getRunningTotal();
    }

    /**
     * Gets the total VAT for the current sale.
     * 
     * @return The total VAT amount for the sale.
     */
    public double getTotalVAT() {
        return sale.getTotalVAT();
    }
}