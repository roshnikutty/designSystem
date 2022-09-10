## BabyDom project

The main method is housed in the BabyDomApp class. 
This has various tests to run the design pattern outputs.

This solution uses the following design patterns

#### Creational Pattern
1. Singleton pattern is used in these classes -
 - Warehouse (package: Warehouse)
 - Cart (package: Cart)
 - InvoiceHistory (package: Invoice)
2. Builder pattern is used in
 - the webpage creation of Product & Bundle pages (package: Page)
 - Invoice (package: Invoice)

#### Structural Pattern
1. Decorator pattern
 - Used to add Discount coupons (package: Discount)
2. Composite pattern
 - Bundle descriptions are composed of Product description (package: Product)


#### Behavioral Pattern
1. State pattern
 - User logged in or out (package: User)
2. Observer pattern
 - warehouse notify subscribers (package: Warehouse)
