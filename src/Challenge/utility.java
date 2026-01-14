package Challenge;

import java.util.Scanner;

public class utility {
    // static method 를 만들어 method area에 올라가도록 변경
    // 객체생성 없이 해당 코드로 어디서든 접근이 가능하도록 변경
    public static double readPositiveDouble(Scanner input , int count) {
        while (true) {
            try {
                System.out.println(count + "번째 양의 실수를 입력하세요.");
                double value = input.nextDouble();
                if (value < 0) {
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
}
