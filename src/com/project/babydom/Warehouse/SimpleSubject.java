package com.project.babydom.Warehouse;

import com.project.babydom.Product.BabyDomProduct;

import java.util.ArrayList;
import java.util.List;

public class SimpleSubject implements Subject {

    private List<Observer> observers;

    private int value;

    public SimpleSubject() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notify all observers of value change
     */
    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
                observer.update(value);
        }
    }

    /**
     * Update stock value of the product and notify all registered observers of this update
     * @param product as BabyDomProduct
     * @param value is updated value
     */
    public void setValue(BabyDomProduct product, int value) {
        Warehouse warehouse = Warehouse.getWarehouse();
        warehouse.addOrUpdateProductWithStock(product, value);
        notifyObservers();
    }
}
