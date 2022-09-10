package com.project.babydom.Discount;

public abstract class DiscountDecorator implements Discount{
    double discountRate;
    double cartTotal;

    public abstract double applyDiscount();

    public abstract String getDiscountDescription(String couponName);
}
