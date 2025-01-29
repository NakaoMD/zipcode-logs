package com.api.services.implementations;

import com.api.dtos.ZipCodeResponse;
import com.api.services.interfaces.IZipCodeLogService;
import com.api.services.interfaces.IZipCodeService;
import org.springframework.stereotype.Service;
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
        ZipCodeResponse response = restTemplate.getForObject(url, ZipCodeResponse.class);
        logService.saveLog(response.toZipCodeLog());
        return response;
    }
}
