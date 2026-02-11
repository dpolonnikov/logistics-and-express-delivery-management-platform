package ru.polonnikov.smartdelivery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import ru.polonnikov.smartdelivery.dto.OrderUpdateDTO;
import ru.polonnikov.smartdelivery.model.Order;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderUpdateMapper {
    Order toOrderEntity(OrderUpdateDTO orderUpdateDTO);
    void updateOrder(OrderUpdateDTO orderUpdateDTO, @MappingTarget Order order);
}
