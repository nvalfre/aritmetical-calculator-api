package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.dto.RecordDTO;
import com.nv.aritmeticalcalculatorapi.domain.entity.Record;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import com.nv.aritmeticalcalculatorapi.repository.RecordRepository;
import com.nv.aritmeticalcalculatorapi.services.RecordService;
import com.nv.aritmeticalcalculatorapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final UserService userService;

    @Override
    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public List<RecordDTO> getRecordsByUser(String username) {
        User userByUsername = userService.getUserByUsername(username).orElseThrow(EntityNotFoundException::new);

        List<Record> byUserId = recordRepository.findByUserId(userByUsername.getId());
        return byUserId.stream().map(RecordServiceImpl::getRecordDTO).collect(Collectors.toList());
    }

    @Override
    public void save(Record record) {
        recordRepository.save(record);
    }


    private static RecordDTO getRecordDTO(Record it) {
        return RecordDTO.builder()
                .id(it.getId())
                .userId(it.getUser().getId())
                .userBalance(it.getUserBalance())
                .operation(it.getOperation())
                .amount(it.getAmount())
                .build();
    }
}
