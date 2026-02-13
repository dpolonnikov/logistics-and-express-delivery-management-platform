package ru.polonnikov.smartdelivery.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import ru.polonnikov.smartdelivery.dto.OrderRequestDTO;
import ru.polonnikov.smartdelivery.model.Order;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderRequestMapper {
    Order toOrderEntity(OrderRequestDTO orderRequestDTO);
    OrderRequestDTO toOrderRequestDTO(Order order);

    @AfterMapping
    default void linkProducts(@MappingTarget Order order) {
        if(order.getProducts() != null) {
            order.getProducts().forEach(orderItem -> orderItem.setOrder(order));
        }
    }
}
