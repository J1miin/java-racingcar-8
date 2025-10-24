package racingcar.Controller;

import racingcar.View.InputView;
import camp.nextstep.edu.missionutils.Console;

public class RacingController {
    private InputView inputView;

    private String totalCarNames;
    private int turn;

    public RacingController(){
        this.inputView = new InputView();
    }

    public void run(){
        inputProcess();
        createCars();
        startRace();
        raceResult();
    }

    public void inputProcess(){
        this.totalCarNames = inputView.askCarName();
        if (totalCarNames.isEmpty()){
            throw new IllegalArgumentException();
        }

        this.turn = inputView.askPlayTurn();
        Console.close();
    }

    public void createCars(){

    }

    public void startRace(){

    }

    public void raceResult(){

    }
}
