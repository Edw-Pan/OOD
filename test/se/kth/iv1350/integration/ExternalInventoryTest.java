package se.kth.iv1350.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.model.Sale;

public class ExternalInventoryTest {
    private ExternalInventory instance = new ExternalInventory();

    @Test
    public void testFindItemExisting() {
        ItemDTO result = instance.findItem("abc123");
        assertNotNull(result, "Should find item with id abc123");
        assertEquals("BigWheel Oatmeal", result.getName(), "Found item should be BigWheel Oatmeal");
        assertEquals(29.90, result.getCost(), "Price should be 29.90");
    }

    @Test
    public void testFindItemNonExisting() {
        ItemDTO result = instance.findItem("non-existing");
        assertNull(result, "Should return null for non-existing item");
    }

    @Test
    public void testUpdateInventory() {
        Sale sale = new Sale();
        sale.addItem(instance.findItem("abc123"));
        
        // Just verify no exceptions are thrown
        assertDoesNotThrow(() -> instance.updateInventory(sale),
            "Update inventory should execute without exceptions");
    }
}