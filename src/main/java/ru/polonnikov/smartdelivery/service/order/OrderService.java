package ru.polonnikov.smartdelivery.service.order;

import ru.polonnikov.smartdelivery.dto.OrderRequestDTO;
import ru.polonnikov.smartdelivery.dto.OrderUpdateDTO;
import ru.polonnikov.smartdelivery.model.Order;

import java.util.UUID;

public interface OrderService {
    Order createOrder(OrderRequestDTO order);
    Order getOrderByIdOrThrow(UUID orderId);
    Order updateOrderByIdOrThrow(UUID orderId, OrderUpdateDTO updateOrder);
    void deleteOrderById(UUID orderId);
}
