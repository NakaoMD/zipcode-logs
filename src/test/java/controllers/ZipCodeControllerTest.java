package controllers;

import com.api.controllers.ZipCodeController;
import com.api.dtos.ZipCodeResponse;
import com.api.domain.ZipCodeLog;
import com.api.services.interfaces.IZipCodeLogService;
import com.api.services.interfaces.IZipCodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ZipCodeControllerTest {
    @Mock
    private IZipCodeService zipCodeService;

    @Mock
    private IZipCodeLogService logService;

    @InjectMocks
    private ZipCodeController controller;

    private ZipCodeResponse response;
    private ZipCodeLog log;

    @BeforeEach
    void setUp() {
        response = new ZipCodeResponse();
        response.setCep("12345-678");
        response.setCidade("TestCity");

        log = new ZipCodeLog();
    }

    @Test
    void testGetZipCodeInfo() {
        when(zipCodeService.fetchZipCodeDetails("12345-678")).thenReturn(response);
        ResponseEntity<ZipCodeResponse> result = controller.getZipCodeInfo("12345-678");
        assertNotNull(result);
        assertNotNull(result.getBody());
    }

    @Test
    void testGetAllLogs() {
        when(logService.findAllLogs()).thenReturn(Collections.singletonList(log));
        ResponseEntity<List<ZipCodeLog>> result = controller.getAllLogs();
        assertNotNull(result);
        assertNotNull(result.getBody());
    }
}
