package api.restful.exception;

public class BoardNotFoundException extends RuntimeException{
    public BoardNotFoundException() {
        super("게시물을 찾지 못하였습니다.");
    }
}
