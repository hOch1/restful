package api.restful.exception;

public class TokenHasNotAuthentication extends RuntimeException{
    public TokenHasNotAuthentication() {
        super("권한 정보가 없는 토큰입니다.");
    }
}
