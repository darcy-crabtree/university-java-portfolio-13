# univeristy-java-portfolio-13

## Brief

In this practical you are implementing an interpreter for mathematical expressions,
based on Java’s Stack.

We are used to mathematical expressions such as "( (4.3 + 25) - (1.7 * 2) ) / 3.2", also
known as infix notation, where operators are used in-between operands. However,
for a calculator it is easier to process a postfix notation such as "4.3 25 + 1.7 2 * -
3.2 /", where the operator is written after the operands (separated by a single
whitespace character).

We can define an interpreter that can evaluate inputs written in postfix notation
based on the following grammar rules:

1. Operator := + | - | * | /
2. Operand := Double
3. Operand := Operand Operand Operator
4. 
The interpretation of the abovementioned grammar rules is as follows:
- Rule 1 indicates that valid operators include addition (+), subtraction (-),
multiplication (*) and division (/), with the operator pushed into the stack
- Rule 2 indicates that any Double (as defined in Java) will be processed as an
operand, with the operand pushed into the stack
- Rule 3 indicates that when the top three elements in the stack are Operand,
Operand, Operator (e.g. "4.3 25 +", with the Operator being at the top of the
stack) then the corresponding mathematical expression is evaluated (e.g. "29.3
:= 4.3 25 +"), popping the top three elements from the stack (e.g. "4.3 25 +")
and pushing the result into the stack (e.g. "29.3")

Implement class Interpreter, which:

- Takes as input a postfix expression and processes the given postfix
expression left to right
- Uses a stack in order to interpret the postfix expression, following the grammar
as defined above
- Prints as output (for valid inputs) every rule application, the stack after each
rule application and the final result
- Prints out useful messages to the user in case of invalid inputs (explaining
why processing failed)
 Contains a main function driving events
