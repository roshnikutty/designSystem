package com.project.babydom.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Class with a map with shipping rates
 */
public final class ShippingMap {

    public static Map<String, Double> getShippingCharges() {
        Map<String, Double> shippingChargesMap = new HashMap<>();

        shippingChargesMap.put("free", 0.0);
        shippingChargesMap.put("next-day", 30.0);

        return shippingChargesMap;
    }
}