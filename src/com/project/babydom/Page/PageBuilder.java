package com.project.babydom.Page;

import com.project.babydom.Product.BabyDomProduct;

public class PageBuilder implements Builder {
    BabyDomProduct product;
    ProductPage productPage;

    public PageBuilder(BabyDomProduct product){
        this.product = product;
        productPage = new ProductPage();
    }

    //All the methods below describe the steps to create a product/bundle page
    @Override
    public void createName() {
        System.out.println("Page's Name created for: " + product.getName());
        productPage.add(product.getName());
    }

    @Override
    public void createPrice() {
        System.out.println("Page's Price created: $" + product.getPrice());
        productPage.add(String.valueOf(product.getPrice()));
    }

    @Override
    public void createDescription() {
        System.out.println("Page's Description created: "+product.getDescription());
        productPage.add(String.valueOf(product.getDescription()));
    }

    @Override
    public void createSpecification() {
        System.out.println("Page's Specification created: " + product.getSpecification());
        productPage.add(product.getSpecification());
    }

    @Override
    public ProductPage getProductPage() {
        return this.productPage;
    }
}
