package config;

import com.api.config.SwaggerConfig;
import org.junit.jupiter.api.Test;
import io.swagger.v3.oas.models.OpenAPI;
import static org.junit.jupiter.api.Assertions.assertNotNull;



class SwaggerConfigTest {
    @Test
    void testSwaggerBean() {
        SwaggerConfig config = new SwaggerConfig();
        OpenAPI openAPI = config.customOpenAPI();
        assertNotNull(openAPI);
    }
}
