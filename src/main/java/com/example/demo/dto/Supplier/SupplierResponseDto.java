package com.example.demo.dto.Supplier;

import com.example.demo.entity.ComplianceStatus;
import com.example.demo.entity.RiskLevel;
import lombok.*;

@Getter
@Setter
@Builder
public class SupplierResponseDto {

    private Long id;

    private String companyName;

    private String country;

    private RiskLevel riskLevel;

    private ComplianceStatus complianceStatus;
}