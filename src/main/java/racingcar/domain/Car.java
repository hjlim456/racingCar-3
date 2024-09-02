package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final CarName name;
    private final CarPosition position;

    public Car(CarName name ) {
        this.name = name;
        this.position = new CarPosition(0);
    }


    public void moveRandomly() {
        if (Randoms.pickNumberInRange(0,9)>=4){
            position.incrementPosition();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String printPosition() {
        return name + " : " + "-".repeat(position);
    }
}
