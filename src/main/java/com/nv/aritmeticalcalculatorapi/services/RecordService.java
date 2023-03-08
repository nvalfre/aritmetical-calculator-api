package com.nv.aritmeticalcalculatorapi.services;

import com.nv.aritmeticalcalculatorapi.domain.entity.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecordService {
    Record saveRecord(Record record);

    List<Record> getRecordsByUserId(Long userId);

    Page<Record> getRecordsByUserId(Long userId, Pageable pageable);

    void save(Record record);
}
