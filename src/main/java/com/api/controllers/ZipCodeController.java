package com.api.controllers;

import com.api.domain.ZipCodeLog;
import com.api.dtos.ZipCodeResponse;
import com.api.services.ZipCodeLogService;
import com.api.services.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zipcode")
public class ZipCodeController {

    @Autowired
    private ZipCodeService zipCodeService;

    @Autowired
    private ZipCodeLogService logService;

    // consultar informações de um CEP
    @GetMapping("/{cep}")
    public ResponseEntity<?> getZipCodeInfo(@PathVariable String cep) {
        try {
            ZipCodeResponse response = zipCodeService.fetchZipCodeDetails(cep);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // listar todos os logs
    @GetMapping("/logs")
    public ResponseEntity<List<ZipCodeLog>> getAllLogs() {
        List<ZipCodeLog> logs = logService.findAllLogs();
        return ResponseEntity.ok(logs);
    }

}
