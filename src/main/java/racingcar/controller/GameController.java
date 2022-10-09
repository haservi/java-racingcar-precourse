package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.CarName;

import java.util.ArrayList;
import java.util.List;

import static racingcar.common.ConstMessage.INPUT_CAR_NAME;
import static racingcar.common.ConstMessage.INPUT_MOVEMENT_COUNT;

public class GameController {

    private CarList carList;
    public void playing() {
        // TODO: 로직 추가
        initCars();

        System.out.println(INPUT_MOVEMENT_COUNT);
        int movementCount = isValidCount(Console.readLine());
    }


    private void initCars() {
        while (this.carList == null) {
            inputCars();
        }
    }

    private void inputCars() {
        try {
            System.out.println(INPUT_CAR_NAME);
            this.carList = new CarList(setCars(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Car> setCars(String readLine) {
        List<Car> carList = new ArrayList<>();
        for (String carName : readLine.trim().split(",")) {
            carList.add(new Car(new CarName(carName)));
        }
        return carList;
    }

    private int isValidCount(String readLine) {
        // TODO: 숫자만 입력되도록 유효성 처리
        return 0;
    }
}
