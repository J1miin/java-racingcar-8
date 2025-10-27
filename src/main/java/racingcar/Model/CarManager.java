package racingcar.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import racingcar.ErrorMessage.ErrorMessage;

public class CarManager {
    private final List<Car> cars;
    private int totalCar;

    public CarManager() {
        this.cars = new ArrayList<>();
    }

    public void manageCars(String carName) {
        createEachCarInstance(carName);
        checkDuplicatedName();
        findTotalCar();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTotalCarNum() {
        return totalCar;
    }

    private void createEachCarInstance(String carName){
        if (isNameEmpty(carName)){
            throw new IllegalArgumentException();
        }
        parseCarNameByComma(carName);
    }

    private boolean isNameEmpty(String carName){
        return carName == null;
    }

    public void parseCarNameByComma(String carName) {

        StringTokenizer tokenizer = new StringTokenizer(carName, ",");
        while (tokenizer.hasMoreTokens()){
            String tmpName = tokenizer.nextToken().trim();

            if (tmpName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_OVER);
            }

            if (tmpName.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME);
            }

            Car car = new Car(tmpName);
            this.cars.add(car);
        }
    }

    private void checkDuplicatedName(){
        Iterator<Car> iterator = cars.iterator();
        Set<String> duplicatedNames = new HashSet<>();
        while (iterator.hasNext()) {
            duplicatedNames.add(iterator.next().getName());
        }
        if (duplicatedNames.size() != cars.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_CAR_NAME);
        }
    }

    private void findTotalCar(){
        this.totalCar = this.cars.size();
    }
}
