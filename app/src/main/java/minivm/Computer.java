package minivm;

import java.io.File;
import java.util.List;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import minivm.exception.FileIsNotValid;
import minivm.parsing.Parser;

public class Computer {

    private int a, b, c, d;
    private int ip = 1, bp, sp;
    private int zf, sf;
    private File file_to_execute;
    private List<List> file_instructions;


    public Computer(){};
    public Computer(File file){
        this.file_to_execute = file;

        try {
            this.file_instructions = Parser.capture_instruction(file);
        } catch (FileIsNotValid e) {
            throw new RuntimeException(e);
        }

    }

    public void execute(){
        while (this.ip < file_instructions.size()){
            List<String> instruction = file_instructions.get(this.ip - 1);
            switch (instruction.get(0)){
                case "mov":
                    break;
                case "add":
                    break;
                case "sub":
                    break;
                case "xor":
                    break;
                case "cmp":
                    break;
                case "mul":
                    break;
                case "div":
                    break;
                case "pop":
                    break;
                case "push":
                    break;
                case "jmp":
                    break;
                case "je":
                    break;
                case "jne":
                    break;
                case "jge":
                    break;
                case "jz":
                    break;
                case "jnz":
                    break;

            }
        }
    }

    //Getter and Setter for register will one function for all register
    //To make easier the writing of the instructions
    public int get_register(String register){
        switch (register){
            case "a":
                return this.a;
            case "b":
                return this.b;
            case "c":
                return this.c;
            case "d":
                return this.d;
            case "ip":
                return this.ip;
            case "bp":
                return this.bp;
            case "sp":
                return this.sp;
            case "zf":
                return this.zf;
            case "sf":
                return this.sf;
            default:
                throw new ValueException("Register are not valid");
        }
    }
    public void set_register(String register, int value){
        switch (register){
            case "a":
                this.a = value;
                break;
            case "b":
                this.b = value;
                break;
            case "c":
                this.c = value;
                break;
            case "d":
                this.d = value;
                break;
            case "ip":
                this.ip = value;
                break;
            case "bp":
                this.bp = value;
                break;
            case "sp":
                this.sp = value;
                break;
            case "zf":
                this.zf = value;
                break;
            case "sf":
                this.sf = value;
                break;
            default:
                throw new ValueException("Register are not valid");
        }
    }
    public List get_instructions() {return this.file_instructions;}

    public void set_file(File file){
        this.file_to_execute = file;
        try {
            this.file_instructions = Parser.capture_instruction(this.file_to_execute);
        } catch (FileIsNotValid e) {
            throw new RuntimeException(e);
        }
    }

}
