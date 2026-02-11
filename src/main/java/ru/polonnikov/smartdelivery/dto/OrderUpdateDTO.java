package ru.polonnikov.smartdelivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ru.polonnikov.smartdelivery.model.Product;
import ru.polonnikov.smartdelivery.utils.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record OrderUpdateDTO(
                @NotBlank
                String address,
                @NotBlank
                String number,
                @NotNull
                UUID customerId,
                @NotNull
                UUID restaurantId,
                @NotNull
                UUID courierId,
                Double latitude,
                Double longitude,
                @NotNull
                BigDecimal amount,
                String currency,
                OrderStatus status,
                List<Product> products
)
 {
}
