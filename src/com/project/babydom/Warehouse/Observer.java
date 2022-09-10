package com.project.babydom.Warehouse;

public interface Observer {
    final int STOCK_LOW_THRESHOLD = 100;
    public void update(int value);
}
