package api.restful.exception;

public class MemberEmailAlreadyExistsException extends RuntimeException{
    public MemberEmailAlreadyExistsException() {
        super("회원 이메일이 중복됩니다.");
    }
}
