package racingcar.domain;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarNameTest {

    @Test
    @DisplayName("01_차량 이름 길이 테스트")
    public void car_name_length() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new CarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

}