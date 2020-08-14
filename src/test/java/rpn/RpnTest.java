package rpn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import rpn.exception.InvalidExpressionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RpnTest {

  private static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of("2 2 +", 4.0),
        Arguments.of("3 4 5 + -", -6.0),
        Arguments.of("3 4 5 * +", 23.0),
        Arguments.of("3 4 5 + *", 27.0),
        Arguments.of("3 4 5 * /", (double) 3 / 20)
    );
  }

  private static Stream<Arguments> failArguments() {
    return Stream.of(
        Arguments.of("2 +"),
        Arguments.of("2 2 2 2")
    );
  }

  @ParameterizedTest
  @MethodSource("arguments")
  void should_calculate_with_correct_answer(String rpnExpressions, Double expectedOutput) throws Exception {
    Rpn rpn = new Rpn();
    Double output = rpn.calculate(rpnExpressions);

    assertEquals(expectedOutput, output);
  }

  @ParameterizedTest
  @MethodSource("failArguments")
  void should_throw_exception_when_the_expression_is_invalid(String rpnExpressions) throws Exception {
    Rpn rpn = new Rpn();
    assertThrows(InvalidExpressionException.class, () -> rpn.calculate(rpnExpressions));
  }
}
