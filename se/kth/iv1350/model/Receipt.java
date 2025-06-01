package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.integration.SaleDTO;


/**
 * This class represents a receipt that is generated after a sale.
 * It contains the sale information and formats it into a string representation.
 */
public class Receipt {
    private SaleDTO saleInfo;
    

    /**
     * Creates a new instance of Receipt with the provided sale information.
     *
     * @param saleInfo The SaleDTO object containing details of the sale.
     */
    public Receipt(SaleDTO saleInfo) {
        this.saleInfo = saleInfo;
    }

    /**
     * Generates a string representation of the receipt.
     * The receipt includes the time of sale, item details, total price, VAT, amount paid, and change.
     *
     * @return A formatted string representing the receipt.
     */
    public String createReceiptString() {
        StringBuilder receiptBuilder = new StringBuilder();
        appendNewLine(receiptBuilder);
        receiptBuilder.append("--- Begin receipt ---\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).format(formatter);
        receiptBuilder.append("Time of sale: ").append(formattedDateTime).append("\n");
        appendNewLine(receiptBuilder);
        
        if (saleInfo.getItems() != null) {
            for (ItemDTO item : saleInfo.getItems()) {
                receiptBuilder.append(String.format("%-20s %2d x %6.2f %8.2f SEK\n",
                    item.getName(),
                    item.getQuantity(),
                    item.getCost(),
                    item.getCost() * item.getQuantity()));
            }
        }
    
        receiptBuilder.append("\nTotal: ").append(String.format("%26.2f SEK\n", saleInfo.getTotalPrice()));
        receiptBuilder.append("VAT: ").append(String.format("%28.2f SEK\n", saleInfo.getTotalVat()));
        receiptBuilder.append("\nCash: ").append(String.format("%25.2f SEK\n", saleInfo.getAmountPaid()));
        receiptBuilder.append("Change: ").append(String.format("%23.2f SEK\n", saleInfo.getChange()));
        receiptBuilder.append("--- End receipt ---");
        
        return receiptBuilder.toString();
    }

    /**
     * Appends a new line to the StringBuilder.
     *
     * @param builder The StringBuilder to which the new line is appended.
     */
    private void appendNewLine(StringBuilder builder) {
        builder.append("\n");
    }
}