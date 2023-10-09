package minivm.parsing;

import minivm.exception.FileIsNotValid;

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
    public static List capture_instructions(File file) throws FileIsNotValid {
        List<List> all_instructions = new ArrayList<List>();
        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String instruction = scanner.nextLine();
                if(instruction_is_valid(instruction)){
                    all_instructions.add(cut_instruction(instruction.trim()));
                }
            }

        } catch (FileNotFoundException err){
            throw new FileIsNotValid("File is empty or not valid");
        }
        return all_instructions;
    }

    //Use regex to check if an instruction line is valid. One regex for each syntax possible
    //If the line is valid return true so that the function capture_instruction
    //can add this line to the instructions list
    private static boolean instruction_is_valid(String instruction){
        if (instruction.isEmpty()) {
            return false;
        } else{
            if(Pattern.matches("(add|mov|sub|xor|mul|div)\\s+([abcd])\\s*,\\s*(a|b|c|d|[0-9]+)\\s*", instruction)){
                return true;
            } else if (Pattern.matches("cmp\\s+(a|b|c|d|[0-9]+)\\s*,\\s*(a|b|c|d|[0-9]+)\\s*", instruction)){
                return true;
            }else if (Pattern.matches("(push\\s+(a|b|c|d|(0|[1-9][0-9]*))\\s*|pop\\s+([abcd])\\s*)", instruction)){
                return true;
            } else if(Pattern.matches("(jmp|je|jne|jge|jz|jnz|jg|jl)\\s+(0|[1-9][0-9]*)\\s*", instruction)){
                return true;
            } else {return Pattern.matches("(inc|dec)\\s+([abcd])", instruction);}
        }
    }
    //This function is use to seperate all element of an instruction.
    //List returned will be like => [instruction, first operand, second operand (optionnal)]
    private static List cut_instruction(String instruction){
        List<String> token_list = new ArrayList<String>();
        String first_part = instruction.substring(0, instruction.indexOf(" ")); //instruction
        String second_part = instruction.substring(instruction.indexOf(" "), instruction.length()); //all operand

        token_list.add(first_part);
        if (second_part.contains(",")){
            token_list.add(second_part.split(",")[0].trim());
            token_list.add(second_part.split(",")[1].trim());
        } else {
            token_list.add(second_part.trim());
        }


        return token_list;
    }
 }
