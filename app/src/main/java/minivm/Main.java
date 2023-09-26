package minivm;

import java.io.File;
import minivm.parsing.Parser;

public class Main {
    public static void main(String[] args) {
        //Parsing argument for
        File file = new File("/home/homets/Documents/project/java/minivm/app/file_exemples/one.txt");
        Parser.capture_instruction(file);
    }
}
