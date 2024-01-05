package api.restful.handler;

import api.restful.dto.Response;
import api.restful.exception.BoardNotFoundException;
import api.restful.exception.MemberEmailAlreadyExistsException;
import api.restful.exception.MemberNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
@ResponseBody
public class CustomExceptionHandler {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<Response> memberNotFoundException(Exception e){
        Response response = new Response(false, e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler(MemberEmailAlreadyExistsException.class)
    public ResponseEntity<Response> memberEmailAlreadyExistsException(Exception e){
        Response response = new Response(false, e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler(BoardNotFoundException.class)
    public ResponseEntity<Response> boardNotFoundException(Exception e){
        Response response = new Response(false, e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
