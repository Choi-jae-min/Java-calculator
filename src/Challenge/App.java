package Challenge;

import java.util.ArrayList;
import java.util.Scanner;

import static Challenge.utility.readPositiveDouble;

public class App {
    public static void main(String[] args) {
        Calculator<Double> calculator = new Calculator<>();

        String menu = "";
        Scanner input = new Scanner(System.in);
        while (!menu.equals("exit")) {
            System.out.println("원하시는 메뉴를 선택 해 주세요.");
            System.out.println("1 : 계산기 | 2 : 가장 오래된 기록 삭제 | 3 : 더 큰 숫자 찾기 | 4 : 삭제 취소 | exit 입력시 종료");
            menu = input.next();

            switch (menu) {
                case "1":
                    int count = 1;
                    // 객체 접근 없이 인풋데이터 관리
                    double positiveNumber1 = readPositiveDouble(input ,count);
                    count++;
                    double positiveNumber2 = readPositiveDouble(input ,count);

                    System.out.println("사칙연산 기호를 입력하세요 + , - , * , / ");
                    char operator = input.next().charAt(0);
                    OperatorType operatorType = OperatorType.setSymbol(operator);
                    try {
                        Double result = calculator.CalculateNumber(positiveNumber1, positiveNumber2, operatorType);
                        calculator.addCalculateResult(result);

                        System.out.println("지금까지 계산 결과 : " + calculator.getCalculateResult());
                    }catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }catch (Exception e) {
                        System.out.println("예기치 못한 에러가 발생 하였습니다." + e.getMessage());
                    }

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
                case "4":
                    calculator.undoDelete();
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
