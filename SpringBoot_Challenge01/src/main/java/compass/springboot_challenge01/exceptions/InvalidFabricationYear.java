package compass.springboot_challenge01.exceptions;

public class InvalidFabricationYear extends RuntimeException{

    public InvalidFabricationYear(String msg){
        super(msg);
    }
}
