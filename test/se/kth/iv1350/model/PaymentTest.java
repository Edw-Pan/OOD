package se.kth.iv1350.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.integration.ExternalAccounting;
import se.kth.iv1350.integration.ExternalInventory;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.integration.ItemDTO;

public class PaymentTest {
    private Sale sale;
    private Payment instance;
    private ExternalAccounting accounting = new ExternalAccounting();
    private ExternalInventory inventory = new ExternalInventory();
    private Printer printer = new Printer();

    @Test
    public void testCalculateChange() {
        sale = new Sale();
        sale.addItem(new ItemDTO("abc123", "TestItem", 25.0, "Test item", 1, 0.06));
        instance = new Payment(50.0, sale);
        assertEquals(25.0, instance.getChange(), "Change should be 25.0 when paying 50.0 for 25.0 purchase");
    }

    @Test
    public void testCompletePayment() {
        sale = new Sale();
        sale.addItem(new ItemDTO("abc123", "TestItem", 10.0, "Test item", 1, 0.06));
        instance = new Payment(15.0, sale);
        
        // Just verify no exceptions are thrown
        assertDoesNotThrow(() -> instance.completePayment(accounting, inventory, printer),
            "Complete payment should execute without exceptions");
    }
}