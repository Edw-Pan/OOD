package se.kth.iv1350.integration;

import se.kth.iv1350.integration.ItemDTO;



/**
 * This class represents a Data Transfer Object (DTO) for an item in the inventory.
 * It contains information about the item such as its ID, name, cost, description, quantity, and VAT.
 */
public class ItemDTO {
    private String itemID;
    private String name; 
    private double cost; 
    private String description; 
    private int quantity; 
    private double vat; 

    /**
     * Creates an instance of ItemDTO with the specified parameters.
     * 
     * @param itemID The unique identifier for the item.
     * @param name The name of the item.
     * @param cost The cost of the item.
     * @param description A description of the item.
     * @param quantity The quantity of the item available.
     * @param vat The VAT applicable to the item.
     */
    public ItemDTO(String itemID, String name, double cost, String description, int quantity, double vat) {
        this.itemID = itemID; 
        this.name = name; 
        this.cost = cost;
        this.description = description; 
        this.quantity = quantity;
        this.vat = vat;
    }

    /**
     * Returns the unique identifier for the item.
     * 
     * @return The item ID.
     */
    public String getItemID(){
        return itemID;
    }

    /**
     * Returns the name of the item.
     * 
     * @return The name of the item.
     */
    public String getName(){
        return name;
    }


    /**
     * Returns the cost of the item.
     * 
     * @return The cost of the item.
     */
    public double getCost(){
        return cost;
    }

    /**
     * Returns the description of the item.
     * 
     * @return The description of the item.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Returns the quantity of the item available.
     * 
     * @return The quantity of the item.
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Returns the VAT applicable to the item.
     * 
     * @return The VAT for the item.
     */
    public double getVat(){
        return vat;
    }
}