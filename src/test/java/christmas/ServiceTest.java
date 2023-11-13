package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ServiceTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 주문_20개_넘게하기() {
        assertSimpleTest(() -> {
            runException("26", "타파스-21");
            assertThat(output()).contains("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다");
        });
    }

    @Test
    void 음료만_주문_하기() {
        assertSimpleTest(() -> {
            runException("26", "제로콜라-1,레드와인-2");
            assertThat(output()).contains("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

