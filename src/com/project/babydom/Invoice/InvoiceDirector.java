package com.project.babydom.Invoice;

public class InvoiceDirector {
    InvoiceBuilder invoiceBuilder;
    public InvoiceDirector(InvoiceBuilder invoiceBuilder) {
        this.invoiceBuilder = invoiceBuilder;
    }

    /**
     * Constructs the invoice
     * @param invoiceBuilder
     */
    public void construct (InvoiceBuilder invoiceBuilder) {

        invoiceBuilder.createCartTotalLineItem();
        invoiceBuilder.createSalesTaxLineItem();
        invoiceBuilder.createShippingLineItem();
        invoiceBuilder.createTotalAmountToBePaid();
    }
}
