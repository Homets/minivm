package minivm.exception;

public class FileIsNotValid extends Exception{
    public FileIsNotValid(String error_message){
        super(error_message);
    }
}
