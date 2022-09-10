package com.project.babydom.Page;

public class BundlePageDirector {

    PageBuilder productPageBuilder;

    /**
     * Construct productPage for the Bundle
     * @param productPageBuilder
     */
    public void construct(PageBuilder productPageBuilder) {
        this.productPageBuilder = productPageBuilder;
        System.out.println("\n|--------------------------------- Bundle page starts --------------------------------------------------|");
        productPageBuilder.createName();
        productPageBuilder.createPrice();
        productPageBuilder.createDescription();
        System.out.println("|--------------------------------- Bundle page ends --------------------------------------------------|\n");
    }
}