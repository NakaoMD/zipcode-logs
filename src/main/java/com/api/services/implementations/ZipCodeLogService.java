package com.api.services.implementations;

import com.api.domain.ZipCodeLog;
import com.api.dtos.ZipCodeResponse;
import com.api.repositories.ZipCodeLogRepository;
import com.api.services.interfaces.IZipCodeLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZipCodeLogService implements IZipCodeLogService {

    private final ZipCodeLogRepository repository;

    public ZipCodeLogService(ZipCodeLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveLog(ZipCodeLog log) {
        repository.save(log);
    }

    @Override
    public List<ZipCodeLog> findAllLogs() {
        return repository.findAll();
    }
}
