package ru.polonnikov.smartdelivery.dto;

import java.util.UUID;

public record OrderResponseDTO(
        String address,
        String number,
        UUID customerId,
        UUID restaurantId,
        UUID courierId
) {
}
