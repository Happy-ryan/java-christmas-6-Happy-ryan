package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        while (true) {
            try {
                int date = inputDate();
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputDate() {
        String day = Console.readLine();
        validateNumber(day);
        return Integer.parseInt(day);
    }

    private void validateNumber(String day) {
        if (!day.matches("(3[01]|[12][0-9]|[1-9])")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
