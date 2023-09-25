package minivm.parsing;
import com.google.common.collect.ImmutableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public List capture_instruction(File file){
        List<String> all_instructions = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(file);

        } catch (FileNotFoundException err){
            System.out.println(err.fillInStackTrace());
        }
        return null;
    }
 }
