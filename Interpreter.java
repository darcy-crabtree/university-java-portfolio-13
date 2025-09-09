package Practical_13;
import java.util.Stack;

/*
Rules:
Rule 1 indicates that valid operators include addition (+), subtraction (-),
multiplication (*) and division (/), with the operator pushed into the stack

Rule 2 indicates that any Double (as defined in Java) will be processed as an
operand, with the operand pushed into the stack

Rule 3 indicates that when the top three elements in the stack are Operand,
Operand, Operator (e.g. "4.3 25 +", with the Operator being at the top of
the stack) then the corresponding mathematical expression is evaluated (e.g.
"29.3 := 4.3 25 +"), popping the top three elements from the stack (e.g. "4.3
25 +") and pushing the result into the stack (e.g. "29.3")
 */

public class Interpreter {
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        equation("4.3 25 + 1.7 2 * - 3.2 /");
    }

    //Splitting equation into parts for calculations and then executes rules
    public static void equation(String equation){
        String[] splitEquation = equation.split(" ");
        for (String equationSection : splitEquation) {
            if (rule1(equationSection)) {
                rule3();
            } else {
                rule2(equationSection);
            }
        }
        System.out.println("Final result: " + stack.pop());
    }

    //Applies rule1
    public static boolean rule1(String section){
        if (section.equals("+") ||
                section.equals("-") ||
                section.equals("/") ||
                section.equals("*")) {
            stack.push(section);
            System.out.println("Rule 1: Operator (" +
                    section + ") := " + section);
            System.out.println("Stack:" + stack.toString());
            return true;
        }
        return false;
    }

    //Applies rule2
    public static boolean rule2(String section) {
        double number;
        try {
            number = Double.parseDouble(section);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid input for equation");
            return false;

        }
        stack.push(section);
        System.out.println("Rule 2: Operand(" +
                number +
                ") := " + number);

        System.out.println("Stack: " + stack.toString());

        return true;

    }

    //Applies rule3
    public static void rule3() {
        if (stack.size() <3) {
            return;
        }
        String operator =  stack.pop();
        double num1 = Double.parseDouble(stack.pop());
        double num2 = Double.parseDouble(stack.pop());

        double result;
        if (operator.equals("+")) {
            result = num2 + num1;
        }

        else if(operator.equals("-")) {
            result = num2 - num1;
        }

        else if(operator.equals("/")) {
            result = num2 / num1;
        }

        else {
            result = num2 * num1;

        }

        stack.push(String.valueOf(result));

        System.out.println("Rule 3: Operand (" + result +
                ") := Operand (" + num2 + ") Operand (" + num1 + ") Operator (" + operator + ")"
                );
        System.out.println("Stack: " + stack.toString());

    }
}






