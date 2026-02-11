package ru.polonnikov.smartdelivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ru.polonnikov.smartdelivery.model.Product;

import java.util.List;
import java.util.UUID;

public record OrderRequestDTO(
        @NotBlank
        String address,
        @NotNull
        UUID restaurantId,
        @NotEmpty
        List<Product> products
) {}
