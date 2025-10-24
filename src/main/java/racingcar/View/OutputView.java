package racingcar.View;

import java.util.List;
import racingcar.Model.Car;

public class OutputView {
    private static final char DASH = '-';

    public void printResultText() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacing(List<Car> carList) {
        for(Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0 ; i < car.getTotalMovingDistance(); ++i){
                System.out.print(DASH);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner(String winnerName) {
        System.out.println("최종 우승자 : "+ winnerName);
    }
}