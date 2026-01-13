package Challenge;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    double readPositiveDouble(Scanner input , int count) {
        while (true) {
            try {
                System.out.println(count + "번째 양의 실수를 입력하세요.");
                double value = input.nextDouble();
                if (value <= 0) {
                    System.out.println("양의 실수만 입력 가능합니다 현재 값 :" + value);
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("숫자가 아닌 다른 데이터가 입력 되었습니다.");
                input.nextLine();
            }
        }
    }
//
//    // 정수 유효성 검사 로직 분리
//    boolean checkValidNumber(T number) {
//        double doubleNumber = Double.parseDouble(number.toString());
//        try {
//            if(doubleNumber < 0) {
//                throw new IllegalArgumentException();
//            }
//        }catch (IllegalArgumentException _) {
//            System.out.println("양의 정수만 입력 할 수 있습니다 입력값 " + number + "는 음수입니다.");
//            System.out.println("다시 입력 해 주세요.");
//            return false;
//        }
//        return true;
//    }

    public void setCalculateResult(ArrayList<T> calculateResult) {
        this.calculateResult = calculateResult;
    }

    public ArrayList<T> getCalculateResult() {return calculateResult;}

    public void addCalculateResult(T number) {this.calculateResult.add(number);}

    public void removeFristCalculateResult() {
        if(this.calculateResult.isEmpty()){
            System.out.println("계산된 결과가 없습니다, 먼저 계산을 진행 해 주세요.");
            return ;
        }
        this.calculateResult.removeFirst();
        System.out.println("삭제 후 결과 : " + this.calculateResult);
    }

    // ✅ 한 줄로 표현 가능
    //List<Integer> ret2 = arrayList.stream() // 1. 데이터 준비
    //    .map(num -> num * 10)               // 2. 중간 연산 등록
    //    .collect(Collectors.toList());  // 3. 최종 연산
    public ArrayList<T> findResultsGreaterThan(double comparisonNumber) {
        if(this.calculateResult.isEmpty()){
            System.out.println("계산된 결과가 없습니다, 먼저 계산을 진행 해 주세요.");
            return null;
        }

        return this.calculateResult.stream().filter( num -> {
            double doubleNumber = Double.parseDouble(num.toString());
            return doubleNumber > comparisonNumber;
        }).collect(Collectors.toCollection(ArrayList::new));
    }
}
