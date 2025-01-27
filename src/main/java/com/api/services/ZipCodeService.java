package com.api.services;

import com.api.dtos.ZipCodeResponse;
import com.api.services.ZipCodeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ZipCodeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ZipCodeLogService logService;

    public ZipCodeResponse fetchZipCodeDetails(String cep) {
        String url = "http://wiremock-container:8080/address/" + cep;

        try {
            // Faz a chamada externa
            ZipCodeResponse response = restTemplate.getForObject(url, ZipCodeResponse.class);
            logService.saveLog(response);
            return response;
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("CEP não encontrado: " + cep);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar o CEP: " + e.getMessage());
        }
    }
}
