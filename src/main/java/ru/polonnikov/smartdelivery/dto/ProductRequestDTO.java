package ru.polonnikov.smartdelivery.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record ProductRequestDTO(
        @NotNull
        UUID id,
        @NotNull
        @Positive
        Integer quantity
) {}
