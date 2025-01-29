package services.implementations;

import com.api.dtos.ZipCodeResponse;
import com.api.services.implementations.ZipCodeService;
import com.api.services.interfaces.IZipCodeLogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ZipCodeServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @Mock
    private IZipCodeLogService logService;

    @InjectMocks
    private ZipCodeService zipCodeService;

    @Test
    void testFetchZipCodeDetails() {
        // Mock da resposta esperada
        ZipCodeResponse response = new ZipCodeResponse();
        response.setCep("12345-678");

        // Uso correto do Mockito ArgumentMatchers
        when(restTemplate.getForObject(anyString(), eq(ZipCodeResponse.class))).thenReturn(response);

        // Executando o método
        ZipCodeResponse result = zipCodeService.fetchZipCodeDetails("12345-678");

        // Validando o resultado
        assertNotNull(result);
    }
}
