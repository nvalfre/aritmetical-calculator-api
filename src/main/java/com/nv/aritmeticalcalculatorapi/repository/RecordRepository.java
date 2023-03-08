package com.nv.aritmeticalcalculatorapi.repository;
import com.nv.aritmeticalcalculatorapi.domain.entity.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserId(Long userId);
    Page<Record> findByUserId(Long userId, Pageable pageable);
}
