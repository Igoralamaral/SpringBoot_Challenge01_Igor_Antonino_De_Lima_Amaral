package compass.springboot_challenge01.exceptions;

public class MethodArgumentNotValidException extends RuntimeException{

    public MethodArgumentNotValidException(String msg){
        super(msg);
    }
}
