package racingcar.domain;

import racingcar.common.ErrorMessage;

public class CarName {

    private final String carName;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public CarName(String carName) {
        validLength(carName);
        this.carName = carName;
    }

    private void validLength(String carName) {
        if (MIN_LENGTH <= carName.length() && carName.length() <= MAX_LENGTH) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH);
    }
    // TODO: 차량 이름 유효성 처리
}
