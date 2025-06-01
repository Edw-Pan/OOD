package se.kth.iv1350.integration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * SaleDTO is a Data Transfer Object that encapsulates the details of a sale.
 * It includes information such as total price, total VAT, time of sale,
 * amount paid, change, and a list of items included in the sale.
 */
public class SaleDTO {
    private double totalPrice;
    private double totalVat;
    private LocalDateTime timeOfSale;
    private double amountPaid;
    private double change;
    private List<ItemDTO> items;

    /**
     * Constructs a SaleDTO object with the specified details.
     *
     * @param totalPrice The total price of the sale.
     * @param totalVat The total VAT of the sale.
     * @param timeOfSale The time when the sale occurred.
     * @param amountPaid The amount paid by the customer.
     * @param change The change to be returned to the customer.
     * @param items A list of items included in the sale.
     */
    public SaleDTO(double totalPrice, double totalVat, LocalDateTime timeOfSale, double amountPaid, double change, List<ItemDTO> items) {
        this.totalPrice = totalPrice;
        this.totalVat = totalVat;
        this.timeOfSale = timeOfSale;
        this.amountPaid = amountPaid;
        this.change = change;
        this.items = new ArrayList<>(items);
    }

    /**
     * Returns the list of items in the sale.
     *
     * @return A list of ItemDTO objects representing the items in the sale.
     */
    public List<ItemDTO> getItems() {
        return new ArrayList<>(items);
    }

    /**
     * Returns the total price of the sale.
     *
     * @return The total price.
     */
    public double getTotalPrice() { 
        return totalPrice; 
    }

    /**
     * Returns the total VAT of the sale.
     *
     * @return The total VAT.
     */
    public double getTotalVat() { 
        return totalVat; 
    }

    /**
     * Returns the time when the sale occurred.
     *
     * @return The time of sale.
     */
    public LocalDateTime getTimeOfSale() { 
        return timeOfSale; 
    }

    /**
     * Returns the amount paid by the customer.
     *
     * @return The amount paid.
     */
    public double getAmountPaid() { 
        return amountPaid; 
    }

    /**
     * Returns the change to be returned to the customer.
     *
     * @return The change amount.
     */
    public double getChange() { 
        return change; 
    }
}