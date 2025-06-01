package se.kth.iv1350.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.integration.ItemDTO;

public class SaleTest {
    private Sale instance;
    private ItemDTO testItem1 = new ItemDTO("abc123", "TestItem1", 10.0, "Test item 1", 1, 0.06);
    private ItemDTO testItem2 = new ItemDTO("def456", "TestItem2", 20.0, "Test item 2", 1, 0.12);

    @Test
    public void testAddItemNewItem() {
        instance = new Sale();
        instance.addItem(testItem1);
        assertEquals(10.0, instance.getRunningTotal(), "Running total should be 10.0 after adding first item");
        assertEquals(0.6, instance.getTotalVAT(), "Total VAT should be 0.6 after adding first item");
    }

    @Test
    public void testAddItemExistingItem() {
        instance = new Sale();
        instance.addItem(testItem1);
        instance.addItem(testItem1);
        assertEquals(20.0, instance.getRunningTotal(), "Running total should be 20.0 after adding same item twice");
        assertEquals(1.2, instance.getTotalVAT(), "Total VAT should be 1.2 after adding same item twice");
    }

    @Test
    public void testAddMultipleDifferentItems() {
        instance = new Sale();
        instance.addItem(testItem1);
        instance.addItem(testItem2);
        assertEquals(30.0, instance.getRunningTotal(), "Running total should be 30.0 after adding two different items");
        assertEquals(3.0, instance.getTotalVAT(), "Total VAT should be 3.0 after adding two different items");
    }

    @Test
    public void testProcessPayment() {
        instance = new Sale();
        instance.addItem(testItem1);
        Payment payment = instance.processPayment(15.0);
        assertNotNull(payment, "Process payment should return a Payment object");
        assertEquals(5.0, payment.getChange(), "Change should be 5.0 when paying 15.0 for 10.0 purchase");
    }
}