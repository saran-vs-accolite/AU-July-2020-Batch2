import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class InvalidEquationException extends Exception {
    String equation;
    public InvalidEquationException(String equation) {
        this.equation = equation;
    }
    @Override
    public String toString() {
        return "InvalidEquationException{" +
                "equation='" + equation + '\'' +
                '}';
    }
}


class Calculator {
    private String equation;
    private Map<Character, Integer> operatorPrecedence;

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public Calculator(String equation) {
        this.equation = equation;

        this.operatorPrecedence = new HashMap<Character, Integer>();
        this.operatorPrecedence.put('+', 1);
        this.operatorPrecedence.put('-', 1);
        this.operatorPrecedence.put('*', 2);
        this.operatorPrecedence.put('/', 2);
        this.operatorPrecedence.put('%', 2);
    }

    private boolean isNumber(char c) {
        return ( c >= '0' && c <= '9');
    }

    private boolean isValidOperator(char c) {
        String operators = "+-*/%";
        return (operators.contains(Character.toString(c)));
    }

    private int getValueOfOperation(int operand1, int operand2, char currOperator) {
        switch (currOperator)
        {
            case '+': return operand1 + operand2;
            case '-': return operand1 - operand2;
            case '*': return operand1 * operand2;
            case '/': return operand1 / operand2;
            case '%': return operand1 % operand2;
        }
        return 0;
    }

    private boolean isLowerPrecedence(Character peek, char currentCharacter) {
        return (this.operatorPrecedence.get(peek) < this.operatorPrecedence.get(currentCharacter));
    }

    public int calculateValue() throws InvalidEquationException{

        Stack<Integer> operandStack = new Stack<Integer>();
        Stack<Character> operatorStack = new Stack<Character>();

        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < this.equation.length(); i++) {
            char currentCharacter = this.equation.charAt(i);

            if (isNumber(currentCharacter) || (currentNumber.length() == 0 && currentCharacter == '-'))
                currentNumber.append(currentCharacter);

            else if (currentCharacter == '(')
            {
                if(currentNumber.length() != 0)
                    throw new InvalidEquationException(this.equation);
                operatorStack.push(currentCharacter);
            }

            else if (currentCharacter == ')') {
                if(currentNumber.length() == 0)
                    throw new InvalidEquationException(this.equation);
                operandStack.push(Integer.valueOf(String.valueOf(currentNumber)));
                currentNumber = new StringBuilder();

                while (!operatorStack.isEmpty() && (operatorStack.peek() != '(')) {
                    char currOperator = operatorStack.pop();
                    int operand2 = operandStack.pop();
                    int operand1 = operandStack.pop();
                    int currResult = getValueOfOperation(operand1, operand2, currOperator);
                    operandStack.push(currResult);
                }

                if (operatorStack.isEmpty())
                    throw new InvalidEquationException(this.equation);
                operatorStack.pop();
            }

            else if (isValidOperator(currentCharacter)) {
                if(currentNumber.length() != 0) {
                    operandStack.push(Integer.valueOf(String.valueOf(currentNumber)));
                    currentNumber = new StringBuilder();
                }

                if (!operatorStack.empty() && (operatorStack.peek() != '(') && !isLowerPrecedence(operatorStack.peek(), currentCharacter)) {
                    while (!operatorStack.isEmpty() && (operatorStack.peek() != '(') && !isLowerPrecedence(operatorStack.peek(), currentCharacter)) {
                        char currOperator = operatorStack.pop();
                        int operand2 = operandStack.pop();
                        int operand1 = operandStack.pop();
                        int currResult = getValueOfOperation(operand1, operand2, currOperator);
                        operandStack.push(currResult);
                    }
                }
                operatorStack.push(currentCharacter);
            }

            else {
                throw new InvalidEquationException(equation);
            }
        }

        if(currentNumber.length() != 0)
            operandStack.push(Integer.valueOf(String.valueOf(currentNumber)));

        while(!operatorStack.isEmpty() && (operatorStack.peek() != '('))
        {
            char currOperator = operatorStack.pop();
            int operand2 = operandStack.pop();
            int operand1 = operandStack.pop();
            int currResult = getValueOfOperation(operand1, operand2, currOperator);
            operandStack.push(currResult);
        }

        if(!operatorStack.isEmpty())
            throw new InvalidEquationException(this.equation);
        return operandStack.pop();
    }
}


public class CalculatorExecutor {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String equation = s.next();
        Calculator calc = new Calculator(equation);
        try
        {
            int finalValue = calc.calculateValue();
            System.out.println("Value of the equation \"" + calc.getEquation() + "\" is: " + Integer.toString(finalValue));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}