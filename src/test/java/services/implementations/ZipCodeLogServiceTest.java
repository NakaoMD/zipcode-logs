package services.implementations;

import com.api.domain.ZipCodeLog;
import com.api.repositories.ZipCodeLogRepository;
import com.api.services.implementations.ZipCodeLogService;
import com.api.services.interfaces.IZipCodeLogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ZipCodeLogServiceTest {
    @Mock
    private ZipCodeLogRepository repository;

    @InjectMocks
    private ZipCodeLogService logService;

    @Test
    void testFindAllLogs() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        List<ZipCodeLog> logs = logService.findAllLogs();
        assertNotNull(logs);
    }
}
