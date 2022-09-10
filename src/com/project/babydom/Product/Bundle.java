package com.project.babydom.Product;

import com.project.babydom.Warehouse.Warehouse;

import java.util.ArrayList;

public class Bundle extends BabyDomProduct {
    private String bundleName;
    private float price;
    private String sku;
    private String description;

    //Holds a list of all the products the Bundle will contain
    ArrayList<BabyDomProduct> productsInBundle = new ArrayList<BabyDomProduct>();

    public Bundle(String bundleName, float price, String sku) {
        this.bundleName = bundleName;
        this.price = price;
        this.sku = sku;
    }
    public void setDescription(String bundleDetails) {
        this.description = bundleDetails;
    }

    //getters
    public String getSku() {
        return this.sku;
    }
    public String getName() {
        return this.bundleName;
    }
    public float getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean getOutOfStock() { return this.outOfStock; }

    @Override
    public void setOutOfStock() {
        //If any one of the product in the bundle is out of Stock,
        // the bundle is also out of stock
        for (BabyDomProduct product: productsInBundle) {
            if (product.getOutOfStock()) {
               this.outOfStock = true;
               break;
            }
        }
    }

    /**
     * Adds a product to the bundle
     * @param sku as String
     */
    @Override
    public void addProductToBundle (String sku) {
        Warehouse warehouse = Warehouse.getWarehouse();
        BabyDomProduct product = warehouse.getProduct(sku);
        this.productsInBundle.add(product);
    }

    /**
     * Removes a product from the bundle
     * @param sku as String
     */
    @Override
    public void removeProductFromBundle (String sku) {
        for (BabyDomProduct product: productsInBundle) {
            if (product.getSku().equals(sku)) {
                this.productsInBundle.remove(product);
            }
        }
    }

    /**
     * Bundle class's implementation of printProductDetails method, where
     * all the products in the bundle are iterated over and their details are printed
     * by calling the product's printProductDetails among other methods
     * Displays the Composite pattern at work
     */
    @Override
    public void printProductDetails() {
        String bundleDetails = "";
        System.out.println("\n--- " + this.bundleName + " contains these BabyDom products at a reduced bundled price, $" + this.price + " ---");

        for (int i = 0; i< productsInBundle.size(); i++) {
            System.out.print("\n" + this.bundleName +"'s item ");
            System.out.println(i+1);
            bundleDetails = bundleDetails + "\n -> " + productsInBundle.get(i).getName() + ": " + productsInBundle.get(i).getDescription();
            productsInBundle.get(i).printProductDetails();
            System.out.println("-------------------------------------------------------------------------------------");
        }
        this.setDescription(bundleDetails);
    }

}
