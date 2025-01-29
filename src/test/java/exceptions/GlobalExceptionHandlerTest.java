package exceptions;

import com.api.dtos.ErrorResponse;
import com.api.exceptions.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void testHandleRuntimeException() {
        ResponseEntity<ErrorResponse> response = handler.handleRuntimeException(new RuntimeException("Error"));
        assertNotNull(response);
        assertNotNull(response.getBody());
        assert response.getStatusCode() == HttpStatus.BAD_REQUEST;
    }

    @Test
    void testHandleGenericException() {
        ResponseEntity<ErrorResponse> response = handler.handleGenericException(new Exception("Error"));
        assertNotNull(response);
        assertNotNull(response.getBody());
        assert response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR;
    }
}