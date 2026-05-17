package com.example.demo.controller;

import com.example.demo.dto.Supplier.SupplierRequestDto;
import com.example.demo.dto.Supplier.SupplierResponseDto;
import com.example.demo.service.SupplierService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponseDto> createSupplier(
            @Valid @RequestBody SupplierRequestDto dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(supplierService.createSupplier(dto));
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponseDto>> getAllSuppliers() {

        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> getSupplierById(@PathVariable Long id) {

        return ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {

        supplierService.deleteSupplier(id);

        return ResponseEntity.ok("Supplier deleted successfully");
    }
}