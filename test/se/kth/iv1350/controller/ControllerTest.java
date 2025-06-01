package se.kth.iv1350.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.integration.ExternalAccounting;
import se.kth.iv1350.integration.ExternalInventory;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.integration.Printer;


public class ControllerTest {
    private ExternalAccounting accounting = new ExternalAccounting();
    private ExternalInventory inventory = new ExternalInventory();
    private Printer printer = new Printer();
    private Controller instance = new Controller(accounting, inventory, printer);

    @Test
    public void testAddItemExisting() {
        instance.startNewSale();
        ItemDTO result = instance.addItem("abc123");
        assertNotNull(result, "Should find item with id abc123");
        assertEquals(29.90, instance.getRunningTotal(), "Running total should be 29.90 after adding first item");
    }


    @Test
    public void testAddItemNonExisting() {
        instance.startNewSale();
        ItemDTO result = instance.addItem("non-existing");
        assertNull(result, "Should return null for non-existing item");
        assertEquals(0.0, instance.getRunningTotal(), "Running total should remain 0.0 for non-existing item");
    }

    @Test
    public void testEndSale() {
        instance.startNewSale();
        instance.addItem("abc123");
        double result = instance.endSale();
        assertEquals(29.90, result, "End sale should return running total");
    }

    @Test
    public void testPay() {
        instance.startNewSale();
        instance.addItem("abc123");
        instance.endSale();
        double change = instance.pay(40.0);
        assertEquals(10.10, change, 0.001, "Change should be 10.10 when paying 40.0 for 29.90 purchase");
    }
}