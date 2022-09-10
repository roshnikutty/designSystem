package com.project.babydom.Invoice;


import java.util.LinkedHashMap;
import java.util.Map;

public class Invoice {
    private Map<String, Double> lineItems;

    public Invoice(){
        //Using LinkedHashMap to maintain order of entries in the invoice
        //that ends with total price
        lineItems = new LinkedHashMap<>();
        this.updateInvoiceHistory();
    }

    public void add(String lineItem, double cost) {
        lineItems.put(lineItem, cost);
    }
    /**
     * Update Invoice history with the current invoice
     */
    public void updateInvoiceHistory(){
        InvoiceHistory invoiceHistory = InvoiceHistory.getInstance();
        invoiceHistory.addInvoice(this);
        System.out.println("invoice created and added to invoice history");
    }

    public void printInvoice() {
        System.out.println("\n--------Invoice ----------\n");

        for (Map.Entry<String,Double> entry : lineItems.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("\n------Invoice ENDS------");
    }
}
