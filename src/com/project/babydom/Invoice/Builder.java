package com.project.babydom.Invoice;


interface Builder {
    void createCartTotalLineItem();
    double createSalesTaxLineItem();
    double createShippingLineItem();
    double createTotalAmountToBePaid();

    /*The following method is used to retrieve the invoice that is constructed.*/
    Invoice getInvoice();
}