package com.example.demo.service;

import com.example.demo.dto.Supplier.SupplierRequestDto;
import com.example.demo.dto.Supplier.SupplierResponseDto;

import java.util.List;

public interface SupplierService {

    SupplierResponseDto createSupplier(SupplierRequestDto dto);

    List<SupplierResponseDto> getAllSuppliers();

    SupplierResponseDto getSupplierById(Long id);

    void deleteSupplier(Long id);
}
