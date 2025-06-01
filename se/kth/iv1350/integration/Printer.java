package se.kth.iv1350.integration;

import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.model.Receipt;


/**
 * This class is responsible for printing the receipt to the console.
 * It simulates a printer that outputs the receipt details.
 */
public class Printer {

    
    /**
     * Prints the receipt to the console.
     * 
     * @param receipt The receipt to be printed.
     */
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.createReceiptString());
    }
}