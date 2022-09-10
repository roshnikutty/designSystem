package com.project.babydom.Warehouse;

import com.project.babydom.Product.BabyDomProduct;
import com.project.babydom.Product.Bundle;
import com.project.babydom.Product.Product;
import com.project.babydom.enumTypes.Color;
import com.project.babydom.enumTypes.Size;
import com.project.babydom.enumTypes.Stage;

import java.util.*;

/**
 * This class maintains BabyDom's product list and stock of each product
 * Singleton Pattern (Creational design pattern)
 * There can be only one instance of the Warehouse
 */
public class Warehouse {
    private static Warehouse warehouse;
    static int numberOfInstances = 0;

    private Warehouse() {
        numberOfInstances++;
    }

    public static synchronized Warehouse getWarehouse() {
        if (warehouse == null) {
            warehouse = new Warehouse();
        }
        return warehouse;

    }
    //Store product sku with its stock count in a map
    private static Map<String, Integer> warehouseStock = new HashMap<>();

    //Set of all BabyDom products
    static Set<BabyDomProduct> productList = new HashSet<>();

    public static Integer getProductStock(String sku) {
        return warehouseStock.get(sku);
    }

    public static Map<String, Integer> getWarehouseStock() {
        return warehouseStock;
    }

    public BabyDomProduct getProduct (String sku) {
        BabyDomProduct retrievedProduct = null;

        for (BabyDomProduct product: productList) {
            if (product.getSku().equals(sku)) {
                retrievedProduct = product;
            }
        }
        return retrievedProduct;
    }


    /**
     * Remove product from Warehouse and product listing
     * @param sku as String
     */
    public void removeProduct(String sku) {
        warehouseStock.remove(sku);
        for (BabyDomProduct product: productList) {
            if (product.getSku().equals(sku)) {
                productList.remove(product);
            }
        }
        System.out.println("BabyDom no longer has product with sku " + sku);
    }

    /**
     * Prints all the products in the Set of products offered by BabyDom
     */
    public void printAllProducts() {
        for (BabyDomProduct product: productList) {
            product.printProductDetails();
        }
    }

    /**
     * Add or update Stock of a product or bundle
     * @param product product whose stock value is added or updated
     * @param count is the stock value as an integer
     */
    public void addOrUpdateProductWithStock(BabyDomProduct product, int count) {

        productList.add(product);
        String sku = product.getSku();
        Integer oldStockCount = getProductStock(sku);

        warehouseStock.put(sku, count);
        System.out.println("Updated stock from " + oldStockCount+ " to " + getProductStock(sku));
    }


    /**
     * Initial load - Add products to Warehouse with stock
     */
    public void addProductsToWareHouse(){
        System.out.println("\n***--- Stock up warehouse ---***");

        //Add bottles to warehouse
        Product smallGreenNewBornBottle = new Product("BabyDom Baby bottle",
                25, "qqwwqqww", "A perfect green baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Newborn, Color.Green, Size.Short);
        addOrUpdateProductWithStock(smallGreenNewBornBottle,20000);

        Product smallBlueNewBornBottle = new Product("BabyDom Baby bottle",
                25, "qqwwqqw1", "A perfect blue baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Newborn, Color.Blue, Size.Short);
        addOrUpdateProductWithStock(smallBlueNewBornBottle,20000);

        Product smallPinkNewBornBottle = new Product("BabyDom Baby bottle",
                25, "qqwwqqw2", "A perfect pink baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Newborn, Color.Pink, Size.Short);
        addOrUpdateProductWithStock(smallPinkNewBornBottle,30);

        Product smallPurpleNewBornBottle = new Product("BabyDom Baby bottle",
                25, "qqwwqqw3", "A perfect purple baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Newborn, Color.Purple, Size.Short);
        addOrUpdateProductWithStock(smallPurpleNewBornBottle,20000);

        Product tallPinkStageOneBottle = new Product("Baby bottle",
                25, "rrttrrtt", "A perfect pink baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.One, Color.Pink, Size.Tall);
        addOrUpdateProductWithStock(tallPinkStageOneBottle,1000);
        Product tallBlueStageOneBottle = new Product("Baby bottle",
                25, "rrttrrtd", "A perfect pink baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.One, Color.Blue, Size.Tall);
        addOrUpdateProductWithStock(tallBlueStageOneBottle,7600);
        Product tallGreenStageOneBottle = new Product("Baby bottle",
                25, "rrttrrth", "A perfect pink baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.One, Color.Green, Size.Tall);
        addOrUpdateProductWithStock(tallGreenStageOneBottle,4377);
        Product tallPurpleStageOneBottle = new Product("Baby bottle",
                25, "rrttrrtn", "A perfect pink baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.One, Color.Purple, Size.Tall);
        addOrUpdateProductWithStock(tallPurpleStageOneBottle,567);

        Product tallPinkStageTwoBottle = new Product("Baby bottle",
                25, "rrttrdtt", "A perfect pink baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Two, Color.Pink, Size.Tall);
        addOrUpdateProductWithStock(tallPinkStageTwoBottle,4732);
        Product tallBlueStageTwoBottle = new Product("Baby bottle",
                25, "rrttsrrtt", "A perfect blue baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Two, Color.Blue, Size.Tall);
        addOrUpdateProductWithStock(tallBlueStageTwoBottle,7848);
        Product tallGreenStageTwoBottle = new Product("Baby bottle",
                25, "rkytrrtt", "A perfect green baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Two, Color.Green, Size.Tall);
        addOrUpdateProductWithStock(tallGreenStageTwoBottle,9996);
        Product tallPurpleStageTwoBottle = new Product("Baby bottle",
                25, "rruegrtt", "A perfect purple baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Two, Color.Purple, Size.Tall);
        addOrUpdateProductWithStock(tallPurpleStageTwoBottle,9000);

        Product tallPinkStageThreeBottle = new Product("Baby bottle",
                25, "etuejjjjs", "A perfect pink baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Three, Color.Pink, Size.Tall);
        addOrUpdateProductWithStock(tallPinkStageThreeBottle,677);
        Product tallBlueStageThreeBottle = new Product("Baby bottle",
                25, "rtuiyukk", "A perfect blue baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Three, Color.Blue, Size.Tall);
        addOrUpdateProductWithStock(tallBlueStageThreeBottle,8900);
        Product tallGreenStageThreeBottle = new Product("Baby bottle",
                25, "68fkflif", "A perfect green baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Three, Color.Green, Size.Tall);
        addOrUpdateProductWithStock(tallGreenStageThreeBottle,9000);
        Product tallPurpleStageThreeBottle = new Product("Baby bottle",
                25, "yyyyeegg", "A perfect purple baby bottle",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Three, Color.Purple, Size.Tall);
        addOrUpdateProductWithStock(tallPurpleStageThreeBottle,6000);

        //Add pacifiers to warehouse
        Product newbornGreenPacifier = new Product("BabyDom pacifier",
                12, "ffeeaaff", "A perfect green pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Newborn, Color.Green, null);
        addOrUpdateProductWithStock(newbornGreenPacifier,6000);
        Product newbornPinkPacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf1", "A perfect pink pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Newborn, Color.Pink, null);
        addOrUpdateProductWithStock(newbornPinkPacifier,6000);
        Product stageOneBluePacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf2", "A perfect blue pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.One, Color.Blue, null);
        addOrUpdateProductWithStock(stageOneBluePacifier,6000);
        Product stageOnePinkPacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf3", "A perfect pink pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.One, Color.Pink, null);
        addOrUpdateProductWithStock(stageOnePinkPacifier,6000);
        Product stageOneGreenPacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf4", "A perfect green pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.One, Color.Green, null);
        addOrUpdateProductWithStock(stageOneGreenPacifier,6000);
        Product stageOnePurplePacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf5", "A perfect purple pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.One, Color.Purple, null);
        addOrUpdateProductWithStock(stageOnePurplePacifier,6000);
        Product stageTwoBluePacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf6", "A perfect blue pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Two, Color.Blue, null);
        addOrUpdateProductWithStock(stageTwoBluePacifier,6000);
        Product stageTwoPinkPacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf7", "A perfect pink pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Two, Color.Pink, null);
        addOrUpdateProductWithStock(stageTwoPinkPacifier,6000);
        Product stageTwoGreenPacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf8", "A perfect green pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Two, Color.Green, null);
        addOrUpdateProductWithStock(stageTwoGreenPacifier,6000);
        Product stageTwoPurplePacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf9", "A perfect purple pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Two, Color.Purple, null);
        addOrUpdateProductWithStock(stageTwoPurplePacifier,6000);
        Product stageThreeBluePacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf0", "A perfect blue pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Three, Color.Blue, null);
        addOrUpdateProductWithStock(stageThreeBluePacifier,6000);
        Product stageThreePinkPacifier = new Product("BabyDom pacifier",
                12, "ffeeaa97", "A perfect pink pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Three, Color.Pink, null);
        addOrUpdateProductWithStock(stageThreePinkPacifier,6000);
        Product stageThreeGreenPacifier = new Product("BabyDom pacifier",
                12, "ffeeaaf0", "A perfect green pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Three, Color.Green, null);
        addOrUpdateProductWithStock(stageThreeGreenPacifier,6000);
        Product stageThreePurplePacifier = new Product("BabyDom pacifier",
                12, "ffeeaa97", "A perfect purple pacifier",
                "Polyamide - BPA, BPS, BPF & Phthalate free", Stage.Three, Color.Purple, null);
        addOrUpdateProductWithStock(stageThreePurplePacifier,6000);

        //Add Sippy cups to warehouse
        Product greenSippyCup = new Product("BabyDom Sippy Cup",
                20, "qqqqqqq0", "A perfect green sippy cup",
                "Polyamide - BPA, BPS, BPF & Phthalate free", null, Color.Green, null);
        addOrUpdateProductWithStock(greenSippyCup,6000);
        Product purpleSippyCup = new Product("BabyDom Sippy Cup",
                20, "qqqqqqq7", "A perfect purple sippy cup",
                "Polyamide - BPA, BPS, BPF & Phthalate free", null, Color.Purple, null);
        addOrUpdateProductWithStock(purpleSippyCup,6000);

        //Add bibs to warehouse
        Product bibs = new Product("BabyDom Bibs",
                20, "rrrk5kjj", "Soft, Durable bibs, protective of all messes in your toddler's life",
                "Polyamide - BPA, BPS, BPF & Phthalate free", null, Color.Orange, null);
        addOrUpdateProductWithStock(bibs,10000);

        //Add blanket to warehouse
        Product babyBlanket = new Product("BabyDom Baby Blankie",
                20, "rrrk5k6k", "Soft, Durable, machine washable baby blanket",
                "Polyamide - BPA, BPS, BPF & Phthalate free", null, Color.White, null);
        addOrUpdateProductWithStock(babyBlanket,10000);

        //Add gift card to warehouse
        Product fiftyValueGC = new Product("BabyDom Gift Card",
                50, "ggggcccc", "Gift Card worth $50 for BabyDom product purchases");
        addOrUpdateProductWithStock(fiftyValueGC,10000);

        Product hundredValueGC = new Product("BabyDom Gift Card",
                100, "ggggcccc", "Gift Card worth $100 for BabyDom product purchases");
        addOrUpdateProductWithStock(hundredValueGC,10000);
    }

    /**
     * Uses Composite Design pattern(structural design pattern)
     * Adds Products to bundles to create a new bundle
     */
    public void addBundlesToWareHouse(){
        //A newborn bundle valued at $55. It includes short bottles and are at
        // stage newborn. It also includes the newborn pacifiers and baby blanket
        BabyDomProduct newbornGreenBundle = new Bundle("Newborn bundle", 55, "newbund1");
        newbornGreenBundle.addProductToBundle("qqwwqqww"); //small green newborn bottle
        newbornGreenBundle.addProductToBundle("ffeeaaff"); //green pacifier
        newbornGreenBundle.addProductToBundle("rrrk5k6k"); //blanket
        addOrUpdateProductWithStock(newbornGreenBundle,10000);

        BabyDomProduct newbornBlueBundle = new Bundle("Newborn bundle", 55, "newbund2");
        newbornBlueBundle.addProductToBundle("qqwwqqw1"); //small blue newborn bottle
        newbornBlueBundle.addProductToBundle("ffeeaaff"); //green pacifier
        newbornBlueBundle.addProductToBundle("rrrk5k6k"); //blanket
        addOrUpdateProductWithStock(newbornBlueBundle,10000);

        BabyDomProduct newbornPinkBundle = new Bundle("Newborn bundle", 55, "newbund3");
        newbornPinkBundle.addProductToBundle("qqwwqqw2"); //small pink newborn bottle
        newbornPinkBundle.addProductToBundle("ffeeaaff"); //green pacifier
        newbornPinkBundle.addProductToBundle("rrrk5k6k"); //blanket
        addOrUpdateProductWithStock(newbornPinkBundle,10000);

        BabyDomProduct newbornPurpleBundle = new Bundle("Newborn bundle", 55, "newbund4");
        newbornPurpleBundle.addProductToBundle("qqwwqqw3"); //small purple newborn bottle
        newbornPurpleBundle.addProductToBundle("ffeeaaff"); //green pacifier
        newbornPurpleBundle.addProductToBundle("rrrk5k6k"); //blanket
        addOrUpdateProductWithStock(newbornPurpleBundle,10000);

        //Bundles each for stages 1 through 3 are the same as the newborn bundle, but the bottles are all large.
        // The pacifier is also stage dependent.
        //I am just creating one of different stages
        BabyDomProduct stagePink1 = new Bundle("Stage 1 Baby Pink bundle", 55, "bundles1");
        stagePink1.addProductToBundle("rrttrrtt"); //Stage 1 tall pink bottle
        stagePink1.addProductToBundle("ffeeaaf3"); //Stage 1 pink pacifier
        stagePink1.addProductToBundle("rrrk5k6k"); //blanket
        addOrUpdateProductWithStock(stagePink1,10000);

        BabyDomProduct stagePink2 = new Bundle("Stage 2 Baby Pink bundle", 55, "bundles2");
        stagePink2.addProductToBundle("rrttrdtt"); //Stage 2 tall pink bottle
        stagePink2.addProductToBundle("ffeeaaf7"); //Stage 2 pink pacifier
        stagePink2.addProductToBundle("rrrk5k6k"); //blanket
        addOrUpdateProductWithStock(stagePink2,10000);

        BabyDomProduct stageBlue3 = new Bundle("Stage 3 Baby Blue bundle", 55, "bundles3");
        stageBlue3.addProductToBundle("rtuiyukk"); //Stage 3 tall blue bottle
        stageBlue3.addProductToBundle("ffeeaaf0"); //Stage 3 blue pacifier
        stageBlue3.addProductToBundle("rrrk5k6k"); //blanket
        addOrUpdateProductWithStock(stageBlue3,10000);

        //A large gift bundle that holds 2 packs of a color of short baby bottles, 2 packs of the same color of a
        // large baby bottle, baby blanket, newborn pacifier. This set originally values at $262 but is offered at $200 because you buy the bundle.
        BabyDomProduct largeBlueBundle = new Bundle("Large Baby Bundle in Blue", 200, "largebun");
        largeBlueBundle.addProductToBundle("qqwwqqw1");//newborn small bottle blue
        largeBlueBundle.addProductToBundle("qqwwqqw1");//newborn small bottle blue
        largeBlueBundle.addProductToBundle("rrttrrtd");//stage 1 blue bottle
        largeBlueBundle.addProductToBundle("rrttrrtd");//stage 1 blue bottle
        largeBlueBundle.addProductToBundle("rrttsrrtt");//stage 2 blue bottle
        largeBlueBundle.addProductToBundle("rrttsrrtt");//stage 2 blue bottle
        largeBlueBundle.addProductToBundle("rtuiyukk");//stage 3 blue bottle
        largeBlueBundle.addProductToBundle("rtuiyukk");//stage 3 blue bottle
        largeBlueBundle.addProductToBundle("ffeeaaff");//newborn green pacifier
        largeBlueBundle.addProductToBundle("rrrk5k6k");//blanket
        addOrUpdateProductWithStock(largeBlueBundle, 300);

        //Toddler Joy Bundle with any colored Sippy cup pack and a bib pack at $30
        BabyDomProduct toddlerBundle = new Bundle("Toddler Joy Bundle", 30, "toddler1");
        toddlerBundle.addProductToBundle("qqqqqqq7");//purple sippy cup
        toddlerBundle.addProductToBundle("rrrk5kjj");//bib pack
        addOrUpdateProductWithStock(toddlerBundle, 300);
    }
    //implement low threshold notification
}
