package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final CarName name;
    private final CarPosition position;

    public Car(CarName name ) {
        this.name = name;
        this.position = new CarPosition(0);
    }


    public void moveForwardIfTrue(boolean randomWith60percent) {
        if (randomWith60percent){
            position.incrementPosition();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String printPosition() {
        return name.getName() + " : " + "-".repeat(position.getPosition());
    }
}
