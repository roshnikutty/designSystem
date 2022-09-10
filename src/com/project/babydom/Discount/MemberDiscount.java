package com.project.babydom.Discount;

public class MemberDiscount extends DiscountDecorator {

    public MemberDiscount(double cartTotal, double discountRate) {
        this.cartTotal = cartTotal;
        this.discountRate = discountRate;
    }

    /**
     * Discount rate is applied to cart, the cart is free is discounts are larger than cart value
     * @return discounted cart total
     */
    @Override
    public double applyDiscount() {
        if (cartTotal - (this.discountRate * cartTotal) > 0){
            return cartTotal - (this.discountRate * cartTotal);
        } else return 0;
    }

    /**
     * Description of Member coupon applied
     * @param couponName as String
     * @return description
     */
    @Override
    public String getDiscountDescription(String couponName) {
        return "Cart total after Member coupon '"+ couponName.toUpperCase() + "' is applied: $" +this.applyDiscount();
    }

}
