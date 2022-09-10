package com.project.babydom.Invoice;

import com.project.babydom.Constants.ShippingMap;
import com.project.babydom.Constants.StateTaxMap;

import java.util.Map;

public class InvoiceBuilder implements Builder {
    private Invoice invoice;
    private double total = 0;
    private String shippingType;
    private String state;

    double discountedTotal;

    public InvoiceBuilder (double total, String state, String shippingType) {
        this.total = total;
        this.invoice = new Invoice();
        this.state = state;
        this.shippingType = shippingType;
    }

    public InvoiceBuilder (double total, String state, String shippingType, double discountedTotal) {
        this.total = discountedTotal == 0 ? total: discountedTotal;
        this.invoice = new Invoice();
        this.state = state;
        this.shippingType = shippingType;
        this.discountedTotal = discountedTotal;
    }
    @Override
    public void createCartTotalLineItem() {
        this.invoice.add("Cart items total       : $", this.total);
    }

    @Override
    public double createSalesTaxLineItem() {
        Map<String, Double> stateTaxMap = StateTaxMap.getStateTax();

        double salesTax = (double) stateTaxMap.get(this.state);

        this.invoice.add("Sales tax              : $" , salesTax);
        return salesTax;
    }


    @Override
    public double createShippingLineItem() {
        Map shippingChargesMap = ShippingMap.getShippingCharges();
        double shippingCharge = (double) shippingChargesMap.get(this.shippingType);

        this.invoice.add("Shipping charge        : $" , shippingCharge);
        return shippingCharge;
    }

    @Override
    public double createTotalAmountToBePaid() {
        double amountToBePaid = this.total + this.createShippingLineItem() + this.createSalesTaxLineItem();
        this.invoice.add("Total amount to be paid: $" , amountToBePaid);
        return amountToBePaid;
    }

    @Override
    public Invoice getInvoice() {
        return this.invoice;
    }
}
