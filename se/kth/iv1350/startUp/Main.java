package se.kth.iv1350.startUp;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.ExternalAccounting;
import se.kth.iv1350.integration.ExternalInventory;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.view.View;


/**
 * The main class that starts the application.
 * It initializes the necessary components and starts the view.
 */
public class Main {

    /**
     * The main method that starts the application.
     * It creates instances of the necessary components and starts the view.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ExternalAccounting externalAccounting = new ExternalAccounting();
        ExternalInventory externalInventory = new ExternalInventory();
        Printer printer = new Printer();
        
        Controller contr = new Controller(externalAccounting, externalInventory, printer);
        View view = new View(contr);
        view.sampleExecution();
    }
}