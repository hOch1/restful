package api.restful.exception;

public class InvalidJwtTokenException extends RuntimeException{
    public InvalidJwtTokenException() {
        super("잘못된 토큰 입니다.");
    }
}
