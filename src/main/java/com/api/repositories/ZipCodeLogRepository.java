package com.api.repositories;

import com.api.domain.ZipCodeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeLogRepository extends JpaRepository<ZipCodeLog, Long> {
    List<ZipCodeLog> findByCep(String cep);
}
