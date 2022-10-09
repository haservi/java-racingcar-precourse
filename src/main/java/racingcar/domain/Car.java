package racingcar.domain;

public class Car {

    private CarName carName;

    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public CarName getCarName() {
        return carName;
    }

}
