package api.restful.exception;

public class UnsupportedJwtTokenException extends RuntimeException{
    public UnsupportedJwtTokenException() {
        super("지원되지 않는 토큰 입니다.");
    }
}
