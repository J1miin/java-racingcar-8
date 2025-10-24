package racingcar.Model;

public class Car {
    private final String name;
    private int totalMovingDistance;

    protected Car (String name) {
        this.name = name;
        this.totalMovingDistance=0;
    }

    public String getName(){
        return name;
    }

    public void updateMovingDistance(int distance){
        this.totalMovingDistance+=distance;
    }

    public int getTotalMovingDistance(){
        return totalMovingDistance;
    }
}