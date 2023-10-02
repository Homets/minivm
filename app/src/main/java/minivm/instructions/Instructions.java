package minivm.instructions;

import minivm.Computer;
public class Instructions {

    protected void add(Computer computer, String op1, String op2){
        if (op2.equals("a") || op2.equals("b") || op2.equals("c") || op2.equals("d")){
            computer.set_register(op1, computer.get_register(op1) + computer.get_register(op2));
        } else {
            computer.set_register(op1, computer.get_register(op1) + Integer.parseInt(op2));
        }
    }


}
