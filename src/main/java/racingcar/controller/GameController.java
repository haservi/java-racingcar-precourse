package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.CarName;
import racingcar.domain.Round;
import racingcar.view.GameView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.common.ConstMessage.INPUT_CAR_NAME;
import static racingcar.common.ConstMessage.INPUT_MOVEMENT_COUNT;

public class GameController {

    private CarList carList;
    private Round round;
    private final GameView gameView;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void playing() {
        initCars();
        initRound();
        start();
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
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void start() {

        System.out.println("실행 결과");
        for (int i = 0; i < round.getRound(); i++) {
            carList.progress();
            printCarsPosition(carList.getCarList());
        }
        System.out.print("최종 우승자 : ");
    }

    private void printCarsPosition(List<Car> cars) {
        cars.forEach(car -> gameView.printCarPosition(car.getCarName().getCarName(), car.getPosition()));
        System.out.println();
    }

}
