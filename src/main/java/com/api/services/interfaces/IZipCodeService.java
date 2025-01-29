package com.api.services.interfaces;

import com.api.dtos.ZipCodeResponse;

public interface IZipCodeService {
    ZipCodeResponse fetchZipCodeDetails(String cep);
}