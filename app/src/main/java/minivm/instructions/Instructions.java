package minivm.instructions;

import minivm.Computer;
public class Instructions {

    public void modify_flag(Computer computer, int value){
        if (value == 0){computer.set_register("zf", 1 ); computer.set_register("sf", 0);}
        else if (value > 0) {computer.set_register("zf", 0); computer.set_register("sf",0);}
        else { computer.set_register("zf", 0); computer.set_register("sf", 1);}
    }
    public void add(Computer computer, String op1, String op2){
        int result;
        if (op2.equals("a") || op2.equals("b") || op2.equals("c") || op2.equals("d")){
            result = computer.get_register(op1) + computer.get_register(op2);
        } else {
            result = computer.get_register(op1) + Integer.parseInt(op2);
        }
        modify_flag(computer, result);
        computer.set_register(op1, result);
    }

    public void mul(Computer computer, String op1, String op2){
        int result;
        if (op2.equals("a") || op2.equals("b") || op2.equals("c") || op2.equals("d")){
            result = computer.get_register(op1) * computer.get_register(op2);
        } else {
            result = computer.get_register(op1) * Integer.parseInt(op2);
        }
        modify_flag(computer, result);
        computer.set_register(op1, result);
    }

    public void sub(Computer computer, String op1, String op2){
        int result;
        if (op2.equals("a") || op2.equals("b") || op2.equals("c") || op2.equals("d")){
            result = computer.get_register(op1) - computer.get_register(op2);
        } else {
            result = computer.get_register(op1) - Integer.parseInt(op2);
        }
        modify_flag(computer, result);
        computer.set_register(op1, result);
    }
    public void div(Computer computer, String op1, String op2) {
        int result;
        if (op2.equals("a") || op2.equals("b") || op2.equals("c") || op2.equals("d")) {
            result = computer.get_register(op1) / computer.get_register(op2);
        } else {
            result = computer.get_register(op1) / Integer.parseInt(op2);
        }
        modify_flag(computer, result);
        computer.set_register(op1, result);
    }
    public void mov(Computer computer, String op1, String op2){
            if (op2.equals("a") || op2.equals("b") || op2.equals("c") || op2.equals("d")){
                computer.set_register(op1, computer.get_register(op2));
            } else {
                computer.set_register(op1, Integer.parseInt(op2));
            }
        }
    public void cmp(Computer computer, String op1, String op2){
        //need two int value, to check if operands are register or integer value;
        //This permit to have an easier read of conditions
        int first_value, second_value;
        if (op1.equals("a") || op1.equals("b") || op1.equals("c") || op1.equals("d")){
            first_value = computer.get_register(op1);
        } else { first_value = Integer.parseInt(op1);}

        if (op2.equals("a") || op2.equals("b") || op2.equals("c") || op2.equals("d")){
            second_value = computer.get_register(op2);
        } else {second_value = Integer.parseInt(op2);}
        modify_flag(computer, Math.abs(first_value) - Math.abs(second_value));
    }
}


