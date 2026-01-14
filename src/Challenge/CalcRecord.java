package Challenge;

public record CalcRecord <T extends Number> (T num1, T num2, OperatorType operator, double result) {
}
