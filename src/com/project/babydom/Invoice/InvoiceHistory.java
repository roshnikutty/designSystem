package com.project.babydom.Invoice;

import java.util.HashMap;
import java.util.Map;

/**
 * This class can have only one instance and uses the Singleton pattern
 */
public class InvoiceHistory {
    private static InvoiceHistory invoiceHistory;
    static int numberOfInstances = 0;
    private static Map<Integer, Invoice> invoiceHistoryMap;

    private InvoiceHistory() {
        numberOfInstances++;
        invoiceHistoryMap = new HashMap<>();
    }

    public static synchronized InvoiceHistory getInstance() {
        if (invoiceHistory == null) {
            invoiceHistory = new InvoiceHistory();
        }
        return invoiceHistory;
    }

    /**
     * Adds a purchase invoice to the Map of invoices
     * @param invoice as Invoice
     */
    public void addInvoice(Invoice invoice) {
        int mapSize = invoiceHistoryMap.size();
        invoiceHistoryMap.put(mapSize+1, invoice);
    }

    public boolean isNewCustomer() {
       return invoiceHistoryMap.size() == 0;
    }
}
