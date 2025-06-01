package se.kth.iv1350.model;

public class Printer {
    public Printer(){

    }
    /**
     * Prints the receipt to the console.
     * 
     * @param receipt The receipt to be printed.
     */
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.createReceiptString());
    }
}