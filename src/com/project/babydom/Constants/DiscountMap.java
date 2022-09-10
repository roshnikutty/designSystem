package com.project.babydom.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Class with a map of coupon names and their discount rates
 */
public final class DiscountMap {

    public static Map<String, Double> getHolidayDiscountMap(){
        Map<String, Double> holidayDiscountMap = new HashMap<>();

        holidayDiscountMap.put("MOTHERS_DAY", 0.02);
        holidayDiscountMap.put("FATHERS_DAY", 0.02);
        holidayDiscountMap.put("BLACK_FRIDAY", 0.5);

        return holidayDiscountMap;
    }

    public static Map<String, Double> getMemberDiscountMap(){
        Map<String, Double> memberDiscountMap = new HashMap<>();

        memberDiscountMap.put("EMPLOYEE", 0.05);
        memberDiscountMap.put("FIRST_PURCHASE", 0.05);
        memberDiscountMap.put("FIVE_YEAR_MEMBER", 0.15);
        memberDiscountMap.put("BABYDOM_BIRTHDAY", 0.6);

        return memberDiscountMap;
    }
}
