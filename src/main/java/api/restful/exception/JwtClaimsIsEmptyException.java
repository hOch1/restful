package api.restful.exception;

public class JwtClaimsIsEmptyException extends RuntimeException{
    public JwtClaimsIsEmptyException() {
        super("토큰이 비어있습니다.");
    }
}
