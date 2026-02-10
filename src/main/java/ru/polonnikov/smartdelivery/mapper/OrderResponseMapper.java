package ru.polonnikov.smartdelivery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.polonnikov.smartdelivery.dto.OrderResponseDTO;
import ru.polonnikov.smartdelivery.model.Order;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderResponseMapper {
    Order toOrderEntity(OrderResponseDTO orderResponseDTO);
    OrderResponseDTO toOrderResponseDTO(Order order);
}
