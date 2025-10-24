package racingcar.Controller;

import racingcar.Model.CarManager;
import racingcar.Model.Race;
import racingcar.View.InputView;
import camp.nextstep.edu.missionutils.Console;
import racingcar.View.OutputView;

public class RacingController {
    private InputView inputView;
    private CarManager carManager;
    private Race race;
    private OutputView outputView;

    private String totalCarNames;
    private int turn;

    public RacingController(){
        this.inputView = new InputView();
        this.carManager = new CarManager();
        this.race = new Race();
        this.outputView = new OutputView();
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
        carManager.manageCars(this.totalCarNames);
    }

    public void startRace(){
        for (int play = 0 ; play < this.turn ; play++){
            if (play==0) {
                outputView.printResultText();
            }
            race.play(carManager.getCars(),carManager.getTotalCarNum());
            outputView.printRacing(carManager.getCars());
        }
    }

    public void raceResult(){
        String winnerName = race.findWinner(carManager.getCars());
        outputView.printWinner(winnerName);
    }
}
