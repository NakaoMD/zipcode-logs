package com.api.services.interfaces;

import com.api.domain.ZipCodeLog;
import java.util.List;

public interface IZipCodeLogService {
    void saveLog(ZipCodeLog log);
    List<ZipCodeLog> findAllLogs();
}
