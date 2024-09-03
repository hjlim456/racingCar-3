package racingcar.domain;

public class CarPosition {

    private final static int DEFAULT_POSITION = 0;
    private  int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public int incrementPosition() {
        return position++;
    }

    public int getPosition() {
        return position;
    }
}
