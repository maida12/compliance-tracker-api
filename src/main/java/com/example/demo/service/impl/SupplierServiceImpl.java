package com.example.demo.service.impl;

import com.example.demo.dto.Supplier.SupplierRequestDto;
import com.example.demo.dto.Supplier.SupplierResponseDto;
import com.example.demo.entity.ComplianceStatus;
import com.example.demo.entity.RiskLevel;
import com.example.demo.entity.Supplier;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public SupplierResponseDto createSupplier(SupplierRequestDto dto) {

        Supplier supplier = Supplier.builder()
                .companyName(dto.getCompanyName())
                .country(dto.getCountry())
                .riskLevel(RiskLevel.MEDIUM)
                .complianceStatus(ComplianceStatus.PENDING)
                .build();

        Supplier saved = supplierRepository.save(supplier);

        return mapToDto(saved);
    }

    @Override
    public List<SupplierResponseDto> getAllSuppliers() {

        return supplierRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }
    @Override
    public SupplierResponseDto getSupplierById(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        return mapToDto(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        supplierRepository.delete(supplier);
    }

    private SupplierResponseDto mapToDto(Supplier supplier) {

        return SupplierResponseDto.builder()
                .id(supplier.getId())
                .companyName(supplier.getCompanyName())
                .country(supplier.getCountry())
                .riskLevel(supplier.getRiskLevel())
                .complianceStatus(supplier.getComplianceStatus())
                .build();
    }
}