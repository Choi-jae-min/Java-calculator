package Challenge;

import java.util.ArrayList;
// 클래스 타입을 제네릭으로 선언
public class Calculator <T> {
    // 컬랙션의 타입을 제네릭으로 변경
    private ArrayList<T> calculateResult = new ArrayList<>();

    // 받는 매개변수 또한 단순 double이 아닌 제네릭으로 받으나
    // 반환 타입은 제네릭으로 하면 코드상에서 반환 타입을 알 수없어서 double타입으로 고정하였습니다.
    public double CalculateNumber(T positiveNumber1, T positiveNumber2 , OperatorType operator) {
        double number1 = Double.parseDouble(positiveNumber1.toString());
        double number2 = Double.parseDouble(positiveNumber2.toString());

        return switch (operator) {
            case OperatorType.PLUS ->  number1 + number2;
            case OperatorType.MINUS -> number1 - number2;
            case OperatorType.MULTIPLY ->  number1 * number2;
            case OperatorType.DIVIDE -> {
                if (number2 == 0) {
                    throw new ArithmeticException("0으로는 나눌 수 없습니다.");
                }
                yield number1 / number2;
            }
        };
    }
    // 정수 유효성 검사 로직 분리
    void checkValidNumber(T number) {
        double doubleNumber = Double.parseDouble(number.toString());
        if(doubleNumber < 0) {
            throw new IllegalArgumentException("양의 정수만 입력 할 수 있습니다 입력값 " + number + "는 음수입니다.");
        }
    }

    public void setCalculateResult(ArrayList<T> calculateResult) {
        this.calculateResult = calculateResult;
    }

    public ArrayList<T> getCalculateResult() {return calculateResult;}

    public void addCalculateResult(T number) {this.calculateResult.add(number);}

    public void removeFristCalculateResult() {
        this.calculateResult.removeFirst();
        System.out.println("삭제 후 결과 : " + this.calculateResult);
    }
}
