package com.example.demo.dto.Supplier;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class SupplierRequestDto {

    @NotBlank
    private String companyName;

    @NotBlank
    private String country;
}