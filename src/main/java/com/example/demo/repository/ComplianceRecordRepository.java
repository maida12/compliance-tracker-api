package com.example.demo.repository;

import com.example.demo.entity.ComplianceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplianceRecordRepository extends JpaRepository<ComplianceRecord, Long> {
}
