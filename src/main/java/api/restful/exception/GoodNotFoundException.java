package api.restful.exception;

public class GoodNotFoundException extends RuntimeException{
    public GoodNotFoundException() {
        super("추천을 하지 않았습니다.");
    }
}
