package com.api.controllers;

import com.api.domain.ZipCodeLog;
import com.api.dtos.ZipCodeResponse;
import com.api.services.interfaces.IZipCodeLogService;
import com.api.services.interfaces.IZipCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zipcode")
@SecurityRequirement(name = "bearerAuth")
public class ZipCodeController {

    private final IZipCodeService zipCodeService;
    private final IZipCodeLogService logService;

    public ZipCodeController(IZipCodeService zipCodeService, IZipCodeLogService logService) {
        this.zipCodeService = zipCodeService;
        this.logService = logService;
    }
    @Operation(summary = "Consulta informações do CEP",
            responses = {
                    @ApiResponse(responseCode = "200", description = "CEP encontrado"),
                    @ApiResponse(responseCode = "404", description = "CEP não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            })
    @GetMapping("/{cep}")
    public ResponseEntity<ZipCodeResponse> getZipCodeInfo(@PathVariable String cep) {
        ZipCodeResponse response = zipCodeService.fetchZipCodeDetails(cep);
        return ResponseEntity.ok(response);
    }



    @GetMapping("/logs")
    public ResponseEntity<List<ZipCodeLog>> getAllLogs() {
        List<ZipCodeLog> logs = logService.findAllLogs();
        return ResponseEntity.ok(logs);
    }
}
