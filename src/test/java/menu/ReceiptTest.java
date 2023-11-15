package menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ReceiptTest {
    @DisplayName("카테고리 별 음식의 숫자 세기")
    @Test
    void testCategoryCounts() {
        Map<String, Integer> order = new HashMap<>();
        order.put("시저샐러드", 2);
        order.put("아이스크림", 3);
        order.put("샴페인", 1);
        order.put("티본스테이크", 4);
        Receipt receipt = new Receipt(order);

        int appetizerCount = receipt.getAppetizerCount();
        int dessertCount = receipt.getDessertCount();
        int drinkCount = receipt.getDrinkCount();
        int mainCount = receipt.getMainCount();

        assertThat(appetizerCount).isEqualTo(2);
        assertThat(dessertCount).isEqualTo(3);
        assertThat(drinkCount).isEqualTo(1);
        assertThat(mainCount).isEqualTo(4);
    }
}

