package se.kth.iv1350.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.integration.SaleDTO;

public class ReceiptTest {
    @Test
    public void testCreateReceiptString() {
        List<ItemDTO> items = new ArrayList<>();
        items.add(new ItemDTO("abc123", "TestItem1", 10.0, "Test item 1", 2, 0.06));
        items.add(new ItemDTO("def456", "TestItem2", 20.0, "Test item 2", 1, 0.12));
        
        SaleDTO saleInfo = new SaleDTO(
            40.0, // totalPrice (2*10 + 1*20)
            3.2,  // totalVat (2*10*0.06 + 1*20*0.12)
            LocalDateTime.now(),
            50.0, // amountPaid
            10.0,  // change
            items
        );
        
        Receipt receipt = new Receipt(saleInfo);
        String receiptString = receipt.createReceiptString();
        
        // Print actual output for debugging
        System.out.println("Actual receipt output:\n" + receiptString);
        
        // Check item lines - match the exact format from Receipt class
        // Format: "%-20s %2d x %6.2f %8.2f SEK\n"
        String expectedItemLine1 = String.format("%-20s %2d x %6.2f %8.2f SEK", 
            "TestItem1", 2, 10.0, 20.0);
        String expectedItemLine2 = String.format("%-20s %2d x %6.2f %8.2f SEK", 
            "TestItem2", 1, 20.0, 20.0);
            
        assertTrue(receiptString.contains(expectedItemLine1), 
            "Receipt should contain first item with correct formatting");
        assertTrue(receiptString.contains(expectedItemLine2), 
            "Receipt should contain second item with correct formatting");
        
        // Check totals - match the exact format from Receipt class
        assertTrue(receiptString.contains(String.format("Total: %26.2f SEK", 40.0)),
            "Receipt should show correct total");
        assertTrue(receiptString.contains(String.format("VAT: %28.2f SEK", 3.2)),
            "Receipt should show correct VAT");
        assertTrue(receiptString.contains(String.format("Cash: %25.2f SEK", 50.0)),
            "Receipt should show correct amount paid");
        assertTrue(receiptString.contains(String.format("Change: %23.2f SEK", 10.0)),
            "Receipt should show correct change");
    }
}