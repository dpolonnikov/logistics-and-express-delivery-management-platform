package ru.polonnikov.smartdelivery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.polonnikov.smartdelivery.dto.OrderRequestDTO;
import ru.polonnikov.smartdelivery.model.Order;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderRequestMapper {
    Order toOrderEntity(OrderRequestDTO orderRequestDTO);
    OrderRequestDTO toOrderRequestDTO(Order order);
}
