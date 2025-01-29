package com.api.controllers;

import com.api.domain.ZipCodeLog;
import com.api.dtos.ZipCodeResponse;
import com.api.services.interfaces.IZipCodeLogService;
import com.api.services.interfaces.IZipCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zipcode")
public class ZipCodeController {

    private final IZipCodeService zipCodeService;
    private final IZipCodeLogService logService;

    // Injeção de dependência via construtor (boas práticas)
    public ZipCodeController(IZipCodeService zipCodeService, IZipCodeLogService logService) {
        this.zipCodeService = zipCodeService;
        this.logService = logService;
    }

    // Consultar informações de um CEP
    @GetMapping("/{cep}")
    public ResponseEntity<ZipCodeResponse> getZipCodeInfo(@PathVariable String cep) {
        ZipCodeResponse response = zipCodeService.fetchZipCodeDetails(cep);
        return ResponseEntity.ok(response);
    }

    // Listar todos os logs
    @GetMapping("/logs")
    public ResponseEntity<List<ZipCodeLog>> getAllLogs() {
        List<ZipCodeLog> logs = logService.findAllLogs();
        return ResponseEntity.ok(logs);
    }
}
