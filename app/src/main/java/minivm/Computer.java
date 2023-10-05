package minivm;

import java.io.File;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import minivm.exception.FileIsNotValid;
import minivm.parsing.Parser;
import minivm.instructions.Instructions;

public class Computer {

    private int a, b, c, d;
    private int ip = 1, bp, sp;
    private int zf = 1, sf = 0;
    private File file_to_execute;
    private List<List> file_instructions;


    public Computer(){};

    public Computer(File file){
        this.file_to_execute = file;
        try {
            this.file_instructions = Parser.capture_instructions(file);
            this.execute();
        } catch (FileIsNotValid e) {
            throw new RuntimeException(e);
        }

    }

    //This will execute the instructions parsed by function capture_instructions
    public void execute(){
        Instructions vm_instruction_list = new Instructions();
        while (this.ip <= file_instructions.size()){
            List<String> instruction = file_instructions.get(this.ip - 1); //this.ip - 1 because ip will be one based indexing
            switch (instruction.get(0)){
                case "mov":
                    vm_instruction_list.mov(this, instruction.get(1), instruction.get(2));
                    break;
                case "add":
                    vm_instruction_list.add(this, instruction.get(1), instruction.get(2));
                    break;
                case "sub":
                    vm_instruction_list.sub(this, instruction.get(1), instruction.get(2));
                    break;
                case "xor":
                    break;
                case "cmp":
                    vm_instruction_list.cmp(this, instruction.get(1), instruction.get(2));
                    break;
                case "mul":
                    vm_instruction_list.mul(this, instruction.get(1), instruction.get(2));
                    break;
                case "div":
                    vm_instruction_list.div(this, instruction.get(1), instruction.get(2));
                    break;
                case "inc":
                    vm_instruction_list.inc(this, instruction.get(1));
                    break;
                case "dec":
                    vm_instruction_list.dec(this, instruction.get(1));
                    break;
                case "pop":
                    break;
                case "push":
                    break;
                case "jmp":
                    vm_instruction_list.jmp(this, instruction.get(1));
                    break;
                case "je":
                    break;
                case "jne":
                    break;
                case "jge":
                    break;
                case "jz":
                    vm_instruction_list.jz(this, instruction.get(1));
                    break;
                case "jnz":
                    break;

            }
            set_register("ip", get_register("ip") + 1);
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
            this.file_instructions = Parser.capture_instructions(this.file_to_execute);
            this.execute();
        } catch (FileIsNotValid e) {
            throw new RuntimeException(e);
        }
    }

}
