package com.project.babydom.Page;

interface Builder {
    void createName();
    void createPrice();
    void createDescription();
    void createSpecification();

    /*The following method is used to retrieve the product page that is constructed.*/
    ProductPage getProductPage();
}