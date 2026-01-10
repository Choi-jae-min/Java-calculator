package Challenge;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String isExitString = "";
        // chapter1 에서 반복문 안쪽에 있었는데 반복할때마다
        // Scanner 객체가 계속 생성 되기 때문에 바깥으로 빼줌
        Scanner input = new Scanner(System.in);

        while (!isExitString.equals("exit")) {

            System.out.println("첫 번째 양의 정수를 입력하세요.");
            int positiveNumber1 = input.nextInt();
            calculator.checkValidNumber(positiveNumber1);

            System.out.println("두 번째 양의 정수를 입력하세요.");
            int positiveNumber2 = input.nextInt();
            calculator.checkValidNumber(positiveNumber2);

            System.out.println("사칙연산 기호를 입력하세요 + , - , * , / ");
            char operator = input.next().charAt(0);
            OperatorType operatorType = OperatorType.setSymbol(operator);
            int result = calculator.CalculateNumber(positiveNumber1, positiveNumber2, operatorType);

            calculator.addCalculateResult(result);

            System.out.println("지금까지 계산 결과 : " + calculator.getCalculateResult());
            System.out.println("가장 첫번째 계산 결과를 삭제 하시겠습니까? D입력시 삭제");
            char doDelete = input.next().charAt(0);
            if (doDelete == 'd') {
                calculator.removeFristCalculateResult();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            isExitString = input.next();
        }
    }
}
