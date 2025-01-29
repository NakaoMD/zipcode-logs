package config;

import com.api.config.RestTemplateConfig;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RestTemplateConfigTest {
    @Test
    void testRestTemplateBean() {
        RestTemplateConfig config = new RestTemplateConfig();
        RestTemplate restTemplate = config.restTemplate();
        assertNotNull(restTemplate);
    }
}

