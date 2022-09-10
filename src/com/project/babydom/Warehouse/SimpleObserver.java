package com.project.babydom.Warehouse;

import com.project.babydom.Product.BabyDomProduct;

public class SimpleObserver implements Observer {

    private Subject subject;
    private BabyDomProduct product;
    private int value;


    public SimpleObserver (Subject subject, BabyDomProduct product) {
        this.subject = subject;
        this.product = product;
        subject.registerObserver(this);
    }

    /**
     * Updates the value when the subject updates the value
     * @param value as int
     */
    @Override
    public void update(int value) {
        this.value = value;

        if (value <= STOCK_LOW_THRESHOLD) {
            product.setOutOfStock();
        }

        this.display();
    }

    public void display() {
        System.out.println("Stock for " + this.product.getName() + " is updated to: " + this.value);
    }
}
