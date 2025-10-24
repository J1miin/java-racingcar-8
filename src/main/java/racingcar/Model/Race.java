package racingcar.Model;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Race {
    private static final int FORWARD = 1;
    private static final int STOP = 0;

    public void play(List<Car> carList, int totalCarNum) {
        for (int player=0; player < totalCarNum; ++player){
            Car car = carList.get(player);
            car.setRandomNumber(Randoms.pickNumberInRange(0, 9));
            move(car);
        }
    }

    public void move(Car car) {
        if (car.getRandomNumber() >= 4){
            car.updateMovingDistance(FORWARD);
        }
        if (car.getRandomNumber() < 4){
            car.updateMovingDistance(STOP);
        }
    }

    public String findWinner(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int maxDistance = 0;
        String winner = "";

        sort(carList);
        maxDistance = carList.getFirst().getTotalMovingDistance();

        for (Car car : carList) {
            if (car.getTotalMovingDistance() == maxDistance) {
                winnerList.add(car.getName());
            }
            if (car.getTotalMovingDistance() != maxDistance) break;
        }

        winner = String.join(", ", winnerList);
        return winner;
    }
}
