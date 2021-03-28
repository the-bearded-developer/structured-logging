package com.beardeddeveloper.structuredlogging;

import java.math.BigDecimal;

public class Order {

    private final int userId;
    private final int orderId;
    private final BigDecimal totalSaleValue;

    public Order(int userId, int orderId, BigDecimal totalSaleValue) {
        this.userId = userId;
        this.orderId = orderId;
        this.totalSaleValue = totalSaleValue;
    }

    public int getUserId() {
        return userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public BigDecimal getTotalSaleValue() {
        return totalSaleValue;
    }
}
