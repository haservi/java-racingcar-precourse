package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.CarName;
import racingcar.domain.Round;

import java.util.ArrayList;
import java.util.List;

import static racingcar.common.ConstMessage.INPUT_CAR_NAME;
import static racingcar.common.ConstMessage.INPUT_MOVEMENT_COUNT;

public class GameController {

    private CarList carList;
    private Round round;

    public void playing() {
        initCars();
        initRound();
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
            carList.add(new Car(new CarName(carName.trim())));
        }
        return carList;
    }

    private void initRound() {
        while (this.round == null) {
            inputRound();
        }
    }

    private void inputRound() {
        try {
            System.out.println(INPUT_MOVEMENT_COUNT);
            round = new Round(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}
