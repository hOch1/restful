package api.restful.handler;

import api.restful.dto.Response;
import api.restful.exception.*;
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

    @ExceptionHandler(NotConfirmPassword.class)
    public ResponseEntity<Response> notConfirmPassword(Exception e){
        Response response = new Response(false, e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
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

    @ExceptionHandler(AlreadyGoodException.class)
    public ResponseEntity<Response> alreadyGoodException(Exception e){
        Response response = new Response(false, e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(GoodNotFoundException.class)
    public ResponseEntity<Response> goodNotFoundException(Exception e){
        Response response = new Response(false, e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler(TokenHasNotAuthentication.class)
    public ResponseEntity<Response> tokenHasNotAuthentication(Exception e){
        Response response = new Response(false, e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
