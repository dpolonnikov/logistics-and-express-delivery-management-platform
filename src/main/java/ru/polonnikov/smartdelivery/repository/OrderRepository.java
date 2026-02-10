package ru.polonnikov.smartdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.polonnikov.smartdelivery.model.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
