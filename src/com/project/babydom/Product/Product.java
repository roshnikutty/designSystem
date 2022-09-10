package com.project.babydom.Product;

import com.project.babydom.enumTypes.Size;
import com.project.babydom.enumTypes.Color;
import com.project.babydom.enumTypes.Stage;

public class Product extends BabyDomProduct {
    private String name;
    private float price;
    private  String sku;
    private String description;
    private String specification;
    private Stage stage=null;
    private Color color= null;
    private Size size=null;

    public Product (String name, float price, String sku, String description, String specification, Stage stage, Color color, Size size) {
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.description = description;
        this.specification = specification;
        this.stage = stage;
        this.color = color;
        this.size = size;
    }

    public Product (String name, float price, String sku, String description) {
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.description = description;
    }


    //setters below will be required when any of these product details need to be updated
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setStage(Stage stage) {this.stage = stage;}

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    //getters
    @Override
    public String getName() { return this.name; }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public String getSku() {
        return this.sku;
    }

    @Override
    public String getDescription() { return this.description; }

    @Override
    public String getSpecification() { return this.specification; }

    @Override
    public Stage getStage() { return this.stage; }

    @Override
    public Color getColor() { return this.color; }

    @Override
    public Size getSize() { return this.size; }

    /**
     * Printing product details for products with different details
     * Example: bottles will have color, stage, size, but blankets will not
     */
    public void printProductDetails() {
        if (this.size == null && this.color == null && this.specification == null) {
            System.out.println("\n Product: " + this.name +
                    "\n sku:" + this.sku +
                    "\n Description: " + this.description);
        } else if (this.size == null && color == null) {
            System.out.println("\n Product: " + this.name +
                    "\n sku: " + this.sku +
                    "\n Description: " + this.description+
                    "\n Specification: " + this.specification);
        } else if (this.size == null) {
            System.out.println("\n Product: " + this.name +
                    "\n sku: " + this.sku +
                    "\n Color: " + this.color +
                    "\n Description: " + this.description +
                    "\n Specification: " + this.specification);
        } else {
            System.out.println("\n Product: " + this.name +
                    "\n sku: " + this.sku +
                    "\n Color: " + this.color + "\n Size: " + this.size +
                    "\n Description: " + this.description +
                    "\n Specification: " + this.specification);
        }
    }

}
