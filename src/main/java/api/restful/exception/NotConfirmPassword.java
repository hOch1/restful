package api.restful.exception;

public class NotConfirmPassword extends RuntimeException{
    public NotConfirmPassword() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
