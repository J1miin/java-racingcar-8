package racingcar.View;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import racingcar.ErrorMessage.ErrorMessage;

public class InputView {
    public String askCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        if (carName.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT);
        }
        return carName;
    }

    public int askPlayTurn() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int playTurn;

        try{
            playTurn = parseInt(input);
            if (playTurn <= 0){
                throw new IllegalArgumentException(ErrorMessage.TRY_NUMBER_NEGATIVE);
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.TRY_NUMBER_IS_STRING);
        }
        return playTurn;
    }
}