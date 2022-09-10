package com.project.babydom.Page;

import java.util.LinkedList;

public class ProductPage {
    private LinkedList<String> productPageList;

    public ProductPage() {
        this.productPageList = new LinkedList<String>();
    }

    /**
     * Adds each page part to the productPageList
     * @param pagePart as String
     */
    public void add(String pagePart) {
        //Adding pagePart items to the list of productPage parts
        productPageList.addLast(pagePart);
    }
}
