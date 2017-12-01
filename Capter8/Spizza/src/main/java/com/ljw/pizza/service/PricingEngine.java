package com.ljw.pizza.service;


import com.ljw.pizza.domain.Order;

public interface PricingEngine {
  public float calculateOrderTotal(Order order);
}
