package minivm;

import java.io.File;
import java.util.List;

import minivm.exception.FileIsNotValid;
import minivm.parsing.Parser;

public class Computer {

    private String a, b, c, d;
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


    //instruction function


    //All getter and setter
    public int get_ip() {return this.ip;}
    public int get_bp() {return this.bp;}
    public int get_sp() {return this.sp;}
    public int get_zf(){return this.zf;}
    public int get_sf(){return this.sf;}
    public String get_a() {return this.a;}
    public String get_b() {return this.b;}
    public String get_c() {return this.c;}
    public String get_d() {return this.d;}
    public List get_instructions() {return this.file_instructions;}

    public void set_ip(int ip) {this.ip = ip;}
    public void set_bp(int bp) {this.bp = bp;}
    public void set_sp(int sp) {this.sp = sp;}
    public void set_zf(int zf){this.zf = zf;}
    public void set_sf(int sf){this.sf = sf;}
    public void set_a(String a) {this.a = a;}
    public void set_b(String b) {this.b = b;}
    public void set_c(String c) {this.c = c;}
    public void set_d(String d) {this.d = d;}
    public void set_file(File file){
        this.file_to_execute = file;
        try {
            this.file_instructions = Parser.capture_instruction(this.file_to_execute);
        } catch (FileIsNotValid e) {
            throw new RuntimeException(e);
        }
    }

}
