package com.api.services.implementations;

import com.api.dtos.ZipCodeResponse;
import com.api.services.interfaces.IZipCodeLogService;
import com.api.services.interfaces.IZipCodeService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ZipCodeService implements IZipCodeService {

    private final RestTemplate restTemplate;
    private final IZipCodeLogService logService;

    public ZipCodeService(RestTemplate restTemplate, IZipCodeLogService logService) {
        this.restTemplate = restTemplate;
        this.logService = logService;
    }

    @Override
    public ZipCodeResponse fetchZipCodeDetails(String cep) {
        String url = "http://wiremock-container:8080/address/" + cep;
        try {
            ZipCodeResponse response = restTemplate.getForObject(url, ZipCodeResponse.class);

            if (response == null || response.getCep() == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP não encontrado");
            }

            logService.saveLog(response.toZipCodeLog());
            return response;
        } catch (HttpClientErrorException.NotFound ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP não encontrado");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar informações do CEP");
        }
    }
}
