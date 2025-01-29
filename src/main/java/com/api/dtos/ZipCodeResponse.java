package com.api.dtos;

import com.api.domain.ZipCodeLog;

import java.time.LocalDateTime;

public class ZipCodeResponse {

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;

    // Getters e Setters
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ZipCodeLog toZipCodeLog() {
        ZipCodeLog log = new ZipCodeLog();
        log.setCep(this.cep);
        log.setLogradouro(this.logradouro);
        log.setBairro(this.bairro);
        log.setCidade(this.cidade);
        log.setEstado(this.estado);
        log.setTimestamp(LocalDateTime.now());
        return log;
    }
}
