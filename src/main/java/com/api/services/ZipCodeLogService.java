package com.api.services;

import com.api.domain.ZipCodeLog;
import com.api.dtos.ZipCodeResponse;
import com.api.repositories.ZipCodeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZipCodeLogService {

    @Autowired
    private ZipCodeLogRepository repository;

    // Salva o log no banco
    public void saveLog(ZipCodeResponse response) {
        ZipCodeLog log = new ZipCodeLog();
        log.setCep(response.getCep());
        log.setLogradouro(response.getLogradouro());
        log.setBairro(response.getBairro());
        log.setCidade(response.getCidade());
        log.setEstado(response.getEstado());
        log.setTimestamp(LocalDateTime.now());
        repository.save(log);
    }

    // Retorna todos os logs
    public List<ZipCodeLog> findAllLogs() {
        return repository.findAll();
    }

}
