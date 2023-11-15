package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OneTwoMenuServiceTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @DisplayName("디저트 2개")
    @Test
    void 일부_메뉴_주문_테스트_1() {
        assertSimpleTest(() -> {
            run("26", "초코케이크-1,아이스크림-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "초코케이크 1개",
                    "아이스크림 1개",
                    "<할인 전 총주문 금액>",
                    "20,000원",
                    "<증정 메뉴>",
                    "없음",
                    "<혜택 내역>",
                    "평일 할인: -4,046원",
                    "<총혜택 금액>",
                    "-4,046원",
                    "<할인 후 예상 결제 금액>",
                    "15,954원",
                    "<12월 이벤트 배지>",
                    "없음"
            );
        });
    }

    @DisplayName("애피타이저 1개 + 메인 1개")
    @Test
    void 일부_메뉴_주문_테스트_2() {
        assertSimpleTest(() -> {
            run("26", "시저샐러드-1,티본스테이크-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "시저샐러드 1개",
                    "티본스테이크 1개",
                    "<할인 전 총주문 금액>",
                    "63,000원",
                    "<증정 메뉴>",
                    "없음",
                    "<혜택 내역>",
                    "없음",
                    "<총혜택 금액>",
                    "없음",
                    "<할인 후 예상 결제 금액>",
                    "63,000원",
                    "<12월 이벤트 배지>",
                    "없음"
            );
        });
    }

    @DisplayName("아이스크림 2개")
    @Test
    void 일부_메뉴_주문_테스트_3() {
        assertSimpleTest(() -> {
            run("25", "아이스크림-2");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "아이스크림 2개",
                    "<할인 전 총주문 금액>",
                    "10,000원",
                    "<증정 메뉴>",
                    "없음",
                    "<혜택 내역>",
                    "크리스마스 디데이 할인: -3,400원",
                    "평일 할인: -4,046원",
                    "특별 할인: -1,000원",
                    "<총혜택 금액>",
                    "-8,446원",
                    "<할인 후 예상 결제 금액>",
                    "1,554원",
                    "<12월 이벤트 배지>",
                    "없음"
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
