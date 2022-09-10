package com.project.babydom.Checkout;

import com.project.babydom.Invoice.InvoiceBuilder;
import com.project.babydom.Product.BabyDomProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * This class can have only one instance and uses the Singleton pattern
 */
public class Cart {

    private static Cart cart;
    static int numberOfInstances = 0;
    private static int cartSize = 0;
    private static List<BabyDomProduct> cartItems;

    private Cart() {
        numberOfInstances++;
        cartItems = new ArrayList<>();
    }

    public static synchronized Cart getInstance() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    /**
     * Add a product to cart
     * @param product as BabyDomProduct
     */
    public void addToCart (BabyDomProduct product) {
        cartSize++;
        cartItems.add(product);
        System.out.println(product.getName() +" is added to cart");
    }

    /**
     * Print all items in the cart
     */
    public void printCartItems () {
       for (BabyDomProduct product: cartItems) {
           System.out.println("Product:" + product.getName() +", Price: $" + product.getPrice()) ;
       }
    }
    public int getCartSize() {
        return cartSize;
    }

    /**
     * Empty the cart
     */
    public void clearCart() {
        cartSize = 0;
        cartItems.clear();
        System.out.println("Cart is cleared");
    }


    /**
     * Get cart total value before any discounts
     * @return cart total value
     */
    public double getCartTotal() {
        double total = 0;
        for (BabyDomProduct product: cartItems) {
            total = total + product.getPrice();
        }
        return total;
    }

    /**
     * Checkout cart directly if no discounts are available,
     * Create invoice and update invoice history
     */
    public InvoiceBuilder checkoutCart(String state, String shippingType, double discountedTotal) throws Exception {
        if (!cartItems.isEmpty() && discountedTotal == 0) {
            InvoiceBuilder invoiceBuilder = new InvoiceBuilder(cart.getCartTotal(), state, shippingType);
            cart.clearCart();
            return invoiceBuilder;
        } else if (!cartItems.isEmpty()){
            InvoiceBuilder invoiceBuilder = new InvoiceBuilder(cart.getCartTotal(), state, shippingType, discountedTotal);
            cart.clearCart();
            return invoiceBuilder;
        } else {
            throw new Exception("Cannot checkout empty cart, please add BabyDom products to cart");
        }
    }
}
