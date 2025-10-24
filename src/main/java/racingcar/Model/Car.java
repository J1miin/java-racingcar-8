package racingcar.Model;

public class Car implements Comparable<Car> {
    private final String name;
    private int totalMovingDistance;
    private int randomNumber;

    protected Car (String name) {
        this.name = name;
        this.totalMovingDistance=0;
        this.randomNumber=0;
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

    public void setRandomNumber(int number){
        this.randomNumber=number;
    }

    public int getRandomNumber(){
        return randomNumber;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.getTotalMovingDistance(), this.totalMovingDistance);
    }
}