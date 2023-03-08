package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.entity.Record;
import com.nv.aritmeticalcalculatorapi.repository.RecordRepository;
import com.nv.aritmeticalcalculatorapi.services.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    @Override
    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public List<Record> getRecordsByUserId(Long userId) {
        return recordRepository.findByUserId(userId);
    }

    @Override
    public Page<Record> getRecordsByUserId(Long userId, Pageable pageable) {
        return recordRepository.findByUserId(userId, pageable);
    }
    @Override
    public void save(Record record){
        recordRepository.save(record);
    }

}
