package com.project.babydom.Page;

public class ProductPageDirector {
    PageBuilder productPageBuilder;

    /**
     * Construct productPage for the product
     * @param productPageBuilder
     */
    public void construct (PageBuilder productPageBuilder) {
        this.productPageBuilder = productPageBuilder;
        System.out.println("|--------------------------------- Product Page starts --------------------------------------------------|");
        productPageBuilder.createName();
        productPageBuilder.createPrice();
        productPageBuilder.createDescription();
        productPageBuilder.createSpecification();

        System.out.println("|--------------------------------- Product Page ends --------------------------------------------------|");
    }
}
