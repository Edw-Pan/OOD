package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.integration.*;


/**
 * Sale represents a sale transaction in the system.
 * It contains details about the items sold, the time of sale,
 * and methods to add items and process payments.
 */
public class Sale {
    private LocalDateTime saleTime;
    private List<ItemDTO> items = new ArrayList<>();
    private double runningTotal;
    private double totalVAT;

    /**
     * Constructs a Sale object with the current time as the sale time.
     */
    public Sale() {
        this.saleTime = LocalDateTime.now();
    }


    /**
     * Adds an item to the sale. If the item already exists in the sale,
     * it increments the quantity of that item.
     * 
     * @param newItem The ItemDTO object representing the item to be added.
     */
    public void addItem(ItemDTO newItem) {
        for (ItemDTO existingItem : items) {
            if (existingItem.getItemID().equals(newItem.getItemID())) {
                items.set(items.indexOf(existingItem), 
                    new ItemDTO(
                        existingItem.getItemID(),
                        existingItem.getName(),
                        existingItem.getCost(),
                        existingItem.getDescription(),
                        existingItem.getQuantity() + 1,
                        existingItem.getVat()
                    ));
                updateTotals(newItem);
                return;
            }
        }
        items.add(new ItemDTO(
            newItem.getItemID(),
            newItem.getName(),
            newItem.getCost(),
            newItem.getDescription(),
            1,
            newItem.getVat()
        ));
        updateTotals(newItem);
    }

    /**
     * Updates the running total and total VAT based on the cost of the item added.
     * 
     * @param item The ItemDTO object representing the item added to the sale.
     */
    private void updateTotals(ItemDTO item) {
        runningTotal += item.getCost();
        totalVAT += item.getCost() * item.getVat();
    }

    /**
     * Processes the payment for the sale.
     * 
     * @param amount The amount paid by the customer.
     * @return A Payment object representing the processed payment.
     */
    public Payment processPayment(double amount) {
        return new Payment(amount, this);
    }

    /**
     * Returns the running total of the sale.
     * 
     * @return The total amount due for the sale.
     */
    public double getRunningTotal() {
        return runningTotal;
    }

    /**
     * Returns the total VAT for the sale.
     * 
     * @return The total VAT amount for the sale.
     */
    public double getTotalVAT() {
        return totalVAT;
    }

    /**
     * Returns the time when the sale occurred.
     * 
     * @return The time of sale as a LocalDateTime object.
     */
    public LocalDateTime getSaleTime() {
        return saleTime;
    }

    /**
     * Returns a list of items included in the sale.
     * 
     * @return A list of ItemDTO objects representing the items in the sale.
     */
    public List<ItemDTO> getItems() {
        return new ArrayList<>(items);
    }
}
