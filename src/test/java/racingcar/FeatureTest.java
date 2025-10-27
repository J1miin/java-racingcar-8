package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.ErrorMessage.ErrorMessage;
import racingcar.Model.Car;
import racingcar.Model.CarManager;
import racingcar.View.InputView;

public class FeatureTest {
    private final InputView inputView = new InputView();
    private final CarManager carManager = new CarManager();

    @Test
    @DisplayName("자동차 이름 입력값이 없는 경우 IllegalArgumentException")
    void car_name_empty() {
        String input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console.close();

        assertThatThrownBy(() -> inputView.askCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "!", "1a", " ", "-1.1", "4.5"})
    @DisplayName("시도 횟수에 숫자가 아닌 입력이 온 경우")
    void try_input_is_not_number(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console.close();

        assertThatThrownBy(() -> inputView.askPlayTurn())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.TRY_NUMBER_IS_STRING);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1","0"})
    @DisplayName("시도 횟수에 자연수가 아닌 숫자 값이 들어온 경우")
    void try_input_is_not_natural_number(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console.close();

        assertThatThrownBy(() -> inputView.askPlayTurn())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.TRY_NUMBER_NEGATIVE);
    }

    @ParameterizedTest
    @ValueSource(strings ={"pobi,kate,  ,jay", "pobi,,kate"})
    @DisplayName("자동차 이름 입력값에 공백이 있는 경우")
    void car_name_not_exist(String input) {
        //String input = "pobi,,kate, ,jay";

        assertThatThrownBy(() -> carManager.parseCarNameByComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME);
    }

    @Test
    @DisplayName("자동차 이름의 길이가 5를 초과하는 경우")
    void car_name_length_over_5(){
        String input = "katelin";

        assertThatThrownBy(() -> carManager.parseCarNameByComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NAME_LENGTH_OVER);
    }

    @Test
    @DisplayName("자동차 이름 앞 뒤에 공란이 있는 경우")
    void car_name_has_space() {
        String input = " pobi , kate, jay ";

        carManager.parseCarNameByComma(input);

        assertThat(carManager.getCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "kate", "jay");
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있는 경우")
    void duplicated_car_name(){
        String input = "pobi,woni,pobi";

        assertThatThrownBy(() -> carManager.manageCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_CAR_NAME);
    }
}