package ru.polonnikov.smartdelivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ru.polonnikov.smartdelivery.utils.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderUpdateDTO(
                @NotEmpty
                @NotBlank
                String address,
                @NotEmpty
                @NotBlank
                String number,
                @NotNull
                @Positive
                UUID customerId,
                @NotNull
                @Positive
                UUID restaurantId,
                @NotNull
                @Positive
                UUID courierId,
                Double latitude,
                Double longitude,
                @NotNull
                @Positive
                BigDecimal amount,
                String currency,
                OrderStatus status)
 {
}
