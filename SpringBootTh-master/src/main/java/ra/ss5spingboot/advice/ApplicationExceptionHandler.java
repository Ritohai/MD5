package ra.ss5spingboot.advice;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ra.ss5spingboot.exception.UserException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // cho phep can thiep vao qua trinh tiep nhan request cua cac controller khac neu xay ra exception
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
 @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> invalidRequest(MethodArgumentNotValidException ex){
     Map<String,String> err = new HashMap<>();
     ex.getBindingResult().getFieldErrors().forEach(c->{
         err.put(c.getField(), c.getDefaultMessage());
     });
     return err;
 }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserException.class)
    public String existed(UserException ex){

        return ex.getMessage();
    }
}
