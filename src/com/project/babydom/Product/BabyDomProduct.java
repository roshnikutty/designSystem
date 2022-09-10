package com.project.babydom.Product;

import com.project.babydom.enumTypes.Color;
import com.project.babydom.enumTypes.Size;
import com.project.babydom.enumTypes.Stage;

public abstract class BabyDomProduct {
    boolean outOfStock = false;
    public void addProductToBundle (String sku){
        throw new UnsupportedOperationException();
    }

    public void removeProductFromBundle (String sku){
        throw new UnsupportedOperationException();
    }
    public String getSku() {throw new UnsupportedOperationException();};
    public String getName() {throw new UnsupportedOperationException(); }

    public float getPrice() {
        throw new UnsupportedOperationException();
    }


    public String getDescription() { throw new UnsupportedOperationException();}

    public String getSpecification() { throw new UnsupportedOperationException();}

    public Stage getStage() { throw new UnsupportedOperationException(); }

    public Color getColor() {throw new UnsupportedOperationException(); }

    public Size getSize() { throw new UnsupportedOperationException(); }

    public boolean getOutOfStock() { return this.outOfStock; }

    public void setOutOfStock() {this.outOfStock = true;}
    public abstract void printProductDetails();

}
