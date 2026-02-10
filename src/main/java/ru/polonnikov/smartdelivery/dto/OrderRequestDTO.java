package ru.polonnikov.smartdelivery.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.UUID;

public record OrderRequestDTO(
        @NotEmpty
        String address,
        @Positive
        @NotNull
        UUID restaurantId,
        @NotEmpty
        List<ProductRequestDTO> products
) {}
