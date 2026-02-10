package ru.polonnikov.smartdelivery.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.polonnikov.smartdelivery.dto.OrderRequestDTO;
import ru.polonnikov.smartdelivery.dto.OrderResponseDTO;
import ru.polonnikov.smartdelivery.dto.OrderUpdateDTO;
import ru.polonnikov.smartdelivery.mapper.OrderResponseMapper;
import ru.polonnikov.smartdelivery.service.order.OrderService;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/v1/orders")
@Validated
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderResponseMapper orderResponseMapper;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody @Valid OrderRequestDTO orderDTO) {
        var savedOrder = orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseMapper.toOrderResponseDTO(savedOrder));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable("id") UUID orderId) {
        var foundOrder = orderService.getOrderByIdOrThrow(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseMapper.toOrderResponseDTO(foundOrder));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> updateOrderById(@PathVariable("id") UUID orderId, @RequestBody OrderUpdateDTO orderUpdateDTO) {
        var updatedOrder = orderService.updateOrderByIdOrThrow(orderId, orderUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseMapper.toOrderResponseDTO(updatedOrder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable UUID orderId) {
        orderService.deleteOrderById(orderId);
        return ResponseEntity.noContent().build();
    }

}
