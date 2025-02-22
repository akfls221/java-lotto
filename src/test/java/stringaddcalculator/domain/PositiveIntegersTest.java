package stringaddcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositiveIntegersTest {

    @Test
    @DisplayName("문자배열을 통해 생성한 PositiveIntegers의 모든 합을 구한다.")
    void positiveIntegers_sumAll() {
        String[] strings = new String[]{"1", "2", "3", "4", "5"};

        PositiveIntegers positiveIntegers = PositiveIntegers.ofStringArray(strings);

        assertThat(positiveIntegers.sumAll()).isEqualTo(15);
    }
}