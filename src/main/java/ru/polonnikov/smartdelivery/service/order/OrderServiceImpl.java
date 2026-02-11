package ru.polonnikov.smartdelivery.service.order;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.polonnikov.smartdelivery.dto.OrderRequestDTO;
import ru.polonnikov.smartdelivery.dto.OrderUpdateDTO;
import ru.polonnikov.smartdelivery.mapper.OrderRequestMapper;
import ru.polonnikov.smartdelivery.mapper.OrderUpdateMapper;
import ru.polonnikov.smartdelivery.model.Order;
import ru.polonnikov.smartdelivery.repository.OrderRepository;
import ru.polonnikov.smartdelivery.utils.enums.OrderStatus;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final OrderRequestMapper orderRequestMapper;
    private final OrderUpdateMapper orderUpdateMapper;
    @Override
    @Transactional
    public Order createOrder(OrderRequestDTO order) {
        Order mappedOrder = orderRequestMapper.toOrderEntity(order);
        mappedOrder.setStatus(OrderStatus.CREATED);
        return orderRepository.save(mappedOrder);
    }

    @Override
    public Order getOrderByIdOrThrow(UUID orderId) {
        Order foundOrder = orderRepository.findById(orderId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with id `%s` not found".formatted(orderId)));
        return foundOrder;
    }

    @Override
    @Transactional
    public Order updateOrderByIdOrThrow(UUID orderId, OrderUpdateDTO updateOrderDTO) {
        Order orderFromDB = getOrderByIdOrThrow(orderId);
        orderUpdateMapper.updateOrder(updateOrderDTO, orderFromDB);
        return orderRepository.save(orderFromDB);

    }

    @Override
    public void deleteOrderById(UUID orderId) {
        orderRepository.deleteById(orderId);
    }
    /*
    private boolean isOrderExists(UUID id) {
        return orderRepository.existsById(id);
    }
     */
}
