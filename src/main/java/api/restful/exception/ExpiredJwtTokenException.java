package api.restful.exception;

public class ExpiredJwtTokenException extends RuntimeException{
    public ExpiredJwtTokenException() {
        super("만료된 토큰 입니다.");
    }
}
