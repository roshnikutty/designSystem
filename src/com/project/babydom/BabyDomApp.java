/**
 * Author: Roshni Kutty
 * CS665 Final project
 */

package com.project.babydom;

import com.project.babydom.Checkout.Cart;
import com.project.babydom.Constants.DiscountMap;
import com.project.babydom.Discount.DiscountDecorator;
import com.project.babydom.Discount.HolidayDiscount;
import com.project.babydom.Discount.MemberDiscount;
import com.project.babydom.Invoice.Invoice;
import com.project.babydom.Invoice.InvoiceBuilder;
import com.project.babydom.Invoice.InvoiceDirector;
import com.project.babydom.Invoice.InvoiceHistory;
import com.project.babydom.Page.BundlePageDirector;
import com.project.babydom.Page.ProductPageDirector;
import com.project.babydom.Page.PageBuilder;
import com.project.babydom.Product.BabyDomProduct;
import com.project.babydom.User.User;
import com.project.babydom.Warehouse.SimpleObserver;
import com.project.babydom.Warehouse.SimpleSubject;
import com.project.babydom.Warehouse.Warehouse;

import java.util.Map;


public class BabyDomApp {

    public static void main(String[] args) throws Exception {
        System.out.println("\n**--- ®Project BabyDom ---**");

        //-----------------------------------------------------------
        //  Initial load of all products & some bundles to Warehouse.
        //  Warehouse uses Singleton patten
        //-----------------------------------------------------------
        Warehouse warehouse = setUpWarehouse();

        //-----------------------------------------------------------
        //   Create Page for a Product and a Bundle in the Warehouse
        //   Bundle Page and Product pages use Builder patten
        //-----------------------------------------------------------
        //Create short green newborn baby bottle product page
        ProductPageDirector pageDirector = new ProductPageDirector();
        BabyDomProduct product = warehouse.getProduct("qqwwqqww");

        if (product == null) {
            System.out.println("No product with sku found");
        }

        PageBuilder productPageBuilder = new PageBuilder(product);
        pageDirector.construct(productPageBuilder);
        productPageBuilder.getProductPage();

        //Create Toddler Joy bundle page Using Bundle Director
        BundlePageDirector bundleDirector = new BundlePageDirector();
        BabyDomProduct toddlerJoyBundle = warehouse.getProduct("toddler1");
        if (toddlerJoyBundle == null) {
            System.out.println("No product with sku found");
        }
        PageBuilder bundlePageBuilder = new PageBuilder(toddlerJoyBundle);
        bundleDirector.construct(bundlePageBuilder);
        bundlePageBuilder.getProductPage();

        //-----------------------------------------------------------
        //          Low stock notification, using Observer pattern
        //-----------------------------------------------------------
        //Remove short green baby bottles from the warehouse to test the low stock notification
        //This product also is an item in newborn green bundle, so consequently, this bundle will also be out of stock
        lowStockNotificationTest(warehouse, product);


        //----------------------------------------------------------------
        // Add items to Cart, checkout, apply discounts and check invoice
        // Cart(Singleton pattern) and discounts (Using decorator pattern)
        //----------------------------------------------------------------
        System.out.println("\n --- Cart(Singleton pattern) and discounts (Using decorator pattern)--- ");
        Cart cart = Cart.getInstance();
        cart.addToCart(toddlerJoyBundle); //add toddler bundle to cart
        cart.addToCart(warehouse.getProduct("rrttsrrtt")); //tall Blue stage 2 bottle pack
        double cartTotal =  cart.getCartTotal();
        System.out.println("Cart with "+ cart.getCartSize() + " items totals to: $" + cartTotal);

        //Apply Holiday discount (BLACK_FRIDAY), then member discount (FIRST_PURCHASE) if applicable
        String holidayCoupon = "BLACK_FRIDAY";
        Map<String, Double> holidayDiscountMap = DiscountMap.getHolidayDiscountMap();
        double blackFridayRate = (double) holidayDiscountMap.get(holidayCoupon);
        DiscountDecorator blackFridayDiscount = new HolidayDiscount(cartTotal, blackFridayRate);
        double cartTotalAfterBlackFriday = blackFridayDiscount.applyDiscount();
        System.out.println(blackFridayDiscount.getDiscountDescription(holidayCoupon));

        InvoiceHistory invoiceHistory = InvoiceHistory.getInstance();
        if (invoiceHistory.isNewCustomer()){
            String memberCoupon = "FIRST_PURCHASE";
            Map<String, Double> memberDiscountMap = DiscountMap.getMemberDiscountMap();
            double firstPurchaseRate = (double) memberDiscountMap.get(memberCoupon);
            DiscountDecorator firstPurchaseDiscount = new MemberDiscount(cartTotalAfterBlackFriday, firstPurchaseRate);
            cartTotal = firstPurchaseDiscount.applyDiscount();
            System.out.println(firstPurchaseDiscount.getDiscountDescription(memberCoupon));
        }

        //----------------------------------------------------------------
        // Create invoice (Using decorator pattern)
        //----------------------------------------------------------------
        System.out.println("\n---Create invoice of Purchase---");

        buildInvoice(cart, cartTotal);

        //---------------------------------------------------------------------------------------------------------
        // User is logged off -> then logged in, can update profile -> then logged off again, cannot update profile
        // (State pattern)
        //---------------------------------------------------------------------------------------------------------
        System.out.println("\n\n*** User logged off, then login, update profile, then logoff (State pattern)***\n");
        User user = new User();
        user.clickLogOff();
        user.clickLogIn();
        user.setUserProfile();
        user.clickLogOff();
        user.setUserProfile();

    }

    public static void buildInvoice(Cart cart, double cartTotal) throws Exception {
        InvoiceBuilder invoiceBuilder = cart.checkoutCart("MA", "free", cartTotal);
        InvoiceDirector invoiceDirector = new InvoiceDirector(invoiceBuilder);
        invoiceDirector.construct(invoiceBuilder);
        Invoice invoice = invoiceBuilder.getInvoice();
        invoice.printInvoice();
    }

    public static void lowStockNotificationTest(Warehouse warehouse, BabyDomProduct product) {
        System.out.println("\n --- Low stock notification (Using Observer pattern)--- ");
        SimpleSubject subject = new SimpleSubject();
        BabyDomProduct product1 = warehouse.getProduct("qqwwqqww");
        BabyDomProduct bundleWithProduct1 = warehouse.getProduct("newbund1");
        SimpleObserver observer = new SimpleObserver(subject, product1);
        SimpleObserver bundleObserver = new SimpleObserver(subject, bundleWithProduct1);

        subject.setValue(product1, 0);
        System.out.println("Check if '" + product1.getName() + "' is out of stock: " + product.getOutOfStock());
        System.out.println("Check if bundle, " + bundleWithProduct1.getName() + " with '"
                + product1.getName() + "' is out of stock: " +bundleWithProduct1.getOutOfStock());
    }

    public static Warehouse setUpWarehouse() {
        Warehouse warehouse = Warehouse.getWarehouse();
        warehouse.addProductsToWareHouse();
        warehouse.addBundlesToWareHouse();

        //Composite Pattern is used here to print all the details of products,
        // and bundles details (these are the product details  of products it holds)
        warehouse.printAllProducts();
        System.out.println("\n");
        return warehouse;
    }
}
