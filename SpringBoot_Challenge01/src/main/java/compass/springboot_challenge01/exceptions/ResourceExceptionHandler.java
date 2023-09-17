package compass.springboot_challenge01.exceptions;

import compass.springboot_challenge01.errors.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.constraints.Null;
import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> NoSuchElementException(NoSuchElementException e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("ID not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> MethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        StandardError error =new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Please, complete all fields");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandardError> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Invalid type of data, insert just numbers for ID parameter");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(BrandNotAccepted.class)
    public ResponseEntity<StandardError> BrandNotAccepted(BrandNotAccepted e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Please choose one of this brands: Ford, Chevrolet, BMW or Volvo");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(InvalidFabricationYear.class)
    public ResponseEntity<StandardError> InvalidFabricationYear(InvalidFabricationYear e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Please insert a valid data in format year/year");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
