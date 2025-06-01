package se.kth.iv1350.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ExternalAccountingTest {
    private ExternalAccounting instance = new ExternalAccounting();

    @Test
    public void testUpdateAccounting() {
        List<ItemDTO> items = new ArrayList<>();
        items.add(new ItemDTO("abc123", "TestItem", 10.0, "Test item", 1, 0.06));
        
        SaleDTO saleInfo = new SaleDTO(
            10.0, 
            0.6, 
            LocalDateTime.now(),
            15.0, 
            5.0, 
            items
        );
        
        // Just verify no exceptions are thrown
        assertDoesNotThrow(() -> instance.updateAccounting(saleInfo),
            "Update accounting should execute without exceptions");
    }
}