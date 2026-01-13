package Challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator<Double> calculator = new Calculator<>();

        String menu = "";
        Scanner input = new Scanner(System.in);
        while (!menu.equals("exit")) {
            System.out.println("원하시는 메뉴를 선택 해 주세요.");
            System.out.println("1 : 계산기 | 2 : 가장 오래된 기록 삭제 | 3 : 더 큰 숫자 찾기 | exit 입력시 종료");
            menu = input.next();

            switch (menu) {
                case "1":
                    int count = 1;
                    double positiveNumber1 = calculator.readPositiveDouble(input ,count);
                    count++;
                    double positiveNumber2 = calculator.readPositiveDouble(input ,count);

                    System.out.println("사칙연산 기호를 입력하세요 + , - , * , / ");
                    char operator = input.next().charAt(0);
                    OperatorType operatorType = OperatorType.setSymbol(operator);
                    Double result = calculator.CalculateNumber(positiveNumber1, positiveNumber2, operatorType);

                    calculator.addCalculateResult(result);
                    System.out.println("지금까지 계산 결과 : " + calculator.getCalculateResult());
                    break;
                case "2":
                    // 한번 더 검증
                    System.out.println("가장 첫번째 계산 결과를 삭제 하시겠습니까? D입력시 삭제");
                    char doDelete = input.next().charAt(0);
                    if (doDelete == 'd') {
                        calculator.removeFristCalculateResult();
                    }
                    break;
                case "3":
                    System.out.println("비교할 정수 입력");
                    double comparisonNumber = input.nextDouble();
                    ArrayList<Double> List = calculator.findResultsGreaterThan(comparisonNumber);
                    if(!List.isEmpty()){
                        System.out.println(comparisonNumber +" 보다 큰 결과 리스트 :" + List);
                    }
                    break;
                case "exit":
                    System.out.println("프로그램을 종료합니다..");
                    break;
                default:
                    System.out.println("잘못된 메뉴를 입력 하셨습니다.");
                    break;
            }
        }
    }
}
