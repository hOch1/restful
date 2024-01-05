package api.restful.exception;

public class AlreadyGoodException extends RuntimeException{
    public AlreadyGoodException() {
        super("이미 추천한 게시물 입니다.");
    }
}
