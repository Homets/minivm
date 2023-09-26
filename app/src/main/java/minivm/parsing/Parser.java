package minivm.parsing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.io.FileNotFoundException;

public class Parser {
    /*
    Parse all line of a file with instruction
    All line who is not a blank line will be a list with instruction and operand of this line
    Each instruction list will be in a global list where index will be the instruction pointer
    Exemple:

    O---------------------O
    |  *---------------*  |
    |  |   add, a, 50  | <--- instruction pointer = 1 |START HERE|
    |  *---------------*  |
    |  *---------------*  |
    |  |   mov, c, a   | <--- instruction pointer = 2
    |  *---------------*  |
    O------------------- -O

     */
    public static List capture_instruction(File file){
        List<String> all_instructions = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                if(instruction_is_valid(scanner.nextLine())){
                    System.out.println("instruction is valid");
                }
            }

        } catch (FileNotFoundException err){
            System.out.println(err.fillInStackTrace());
        }
        return null;
    }

    private static boolean instruction_is_valid(String instruction){
        if (instruction.isEmpty()) {
            return false;
        } else{
            if(Pattern.matches("(add|mov|sub)\\s+(a|b|c|d)\\s*,\\s*(a|b|c|d|[0-9]+)", instruction)){
                return true;
            }
        }
        return true;
    }
 }
