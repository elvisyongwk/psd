package rpn;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import rpn.exception.InvalidExpressionException;

public class Rpn {

  final static String plus = "+";
  final static String minus = "-";
  final static String multiply = "*";
  final static String divide = "/";

  List<String> operators = Arrays.asList(plus, minus, multiply, divide);

  public Double calculate(String rpnExpression) throws InvalidExpressionException {
    List<String> expression = Arrays.asList(rpnExpression.split(" "));

    if (expression.size() < 3) {
      throw new InvalidExpressionException("Expressions must be equal 3 or more");
    }

    if (!operators.contains(expression.get(expression.size() - 1))) {
      throw new InvalidExpressionException("Expression invalid");
    }

    Stack<String> stacks = new Stack();

    stacks.addAll(expression);

    Double answer = null;
    try {
      answer = calculateStack(stacks);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return answer;
  }

  private Double calculateStack(Stack<String> stacks) throws Exception {
    Double firstNum;
    Double secondNum;
    String pop = stacks.pop();
    if (operators.contains(pop)) {
      secondNum = calculateStack(stacks);
      firstNum = calculateStack(stacks);

      switch (pop) {
        case plus:
          firstNum += secondNum;
          break;
        case minus:
          firstNum -= secondNum;
          break;
        case multiply:
          firstNum *= secondNum;
          break;
        case divide:
          firstNum /= secondNum;
          break;
        default:
          throw new Exception();
      }
    } else {
      firstNum = Double.parseDouble(pop);
    }
    return firstNum;
  }
}
