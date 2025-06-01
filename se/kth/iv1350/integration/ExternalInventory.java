package se.kth.iv1350.integration;

import se.kth.iv1350.integration.ExternalInventory;
import se.kth.iv1350.model.Sale;  


/**
 * This class represents an external inventory system that provides item details
 * and allows updating the inventory based on sales.
 */ 
public class ExternalInventory {

    /**
     * Retrieves item details based on the provided item ID.
     * 
     * @param itemID The ID of the item to be retrieved.
     * @return An ItemDTO object containing the item's details, or null if the item is not found.
     */
    public ItemDTO findItem(String itemID) {
        if (itemID.equals("abc123")) {
            return new ItemDTO(
                "abc123",
                "BigWheel Oatmeal",
                29.90,
                "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free",
                1,
                0.06
            );
        } else if (itemID.equals("def456")) {
            return new ItemDTO(
                "def456",
                "YouGoGo Blueberry",
                14.90,
                "YouGoGo Blueberry 240g, low sugar youghurt, blueberry flavour",
                1,
                0.06
            );
        }
        return null;
    }

    /**
     * Updates the inventory based on the items sold in the provided sale.
     * 
     * @param sale The Sale object containing the items sold.
     */
    public void updateInventory(Sale sale) {
    }
}