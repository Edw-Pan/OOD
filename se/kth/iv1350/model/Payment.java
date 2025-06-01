package se.kth.iv1350.model;


import se.kth.iv1350.integration.ExternalAccounting;
import se.kth.iv1350.integration.ExternalInventory;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.integration.SaleDTO;


/**
 * This class represents a payment made for a sale.
 * It calculates the change to be returned to the customer
 * and handles the completion of the payment process.
 */
public class Payment {
    private final double amount;
    private final double change;
    private final Sale sale;

    /**
     * Creates a new Payment instance.
     *
     * @param amount The amount paid by the customer.
     * @param sale The Sale object representing the sale being paid for.
     */
    public Payment(double amount, Sale sale) {
        this.amount = amount;
        this.sale = sale;
        this.change = calculateChange(amount, sale.getRunningTotal());
    }
    
    /**
     * Calculates the change to be returned to the customer.
     *
     * @param amountPaid The amount paid by the customer.
     * @param totalCost The total cost of the sale.
     * @return The change to be returned, rounded to two decimal places.
     */
    private double calculateChange(double amountPaid, double totalCost) {
        return Math.round((amountPaid - totalCost) * 100.0) / 100.0;
    }
    
    /**
     * Completes the payment process by updating the external accounting and inventory systems,
     * and printing a receipt.
     *
     * @param accounting An instance of ExternalAccounting for updating accounting records.
     * @param inventory An instance of ExternalInventory for updating inventory records.
     * @param printer An instance of Printer for printing the receipt.
     */
    public void completePayment(ExternalAccounting accounting, 
                              ExternalInventory inventory,
                              Printer printer) {
        SaleDTO saleInfo = new SaleDTO(
            sale.getRunningTotal(),
            sale.getTotalVAT(),
            sale.getSaleTime(),
            amount,
            change,
            sale.getItems()
        );
        inventory.updateInventory(sale);
        accounting.updateAccounting(saleInfo);
        printer.printReceipt(new Receipt(saleInfo));
    }

    /**
     * Returns the amount paid by the customer.
     *
     * @return The amount paid.
     */ 
    public double getAmount() {
        return amount;
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
