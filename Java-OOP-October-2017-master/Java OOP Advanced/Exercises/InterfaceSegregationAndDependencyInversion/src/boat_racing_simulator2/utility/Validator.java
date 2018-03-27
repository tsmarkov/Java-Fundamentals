package boat_racing_simulator2.utility;

import boat_racing_simulator2.exceptions.IncorrectModelLengthException;
import boat_racing_simulator2.exceptions.IncorrectPropertyValueException;

public class Validator {

    public static void validatePropertyPositiveValue(int value, String propertyName) {
        if (value <= 0) {
            throw new IncorrectPropertyValueException(String.format(Constants.IncorrectPropertyValueMessage, propertyName));
        }
    }

    public static void validateModelLength(String value, int minModelLength) {
        if (value.length() < minModelLength) {
            throw new IncorrectModelLengthException(String.format(Constants.IncorrectModelLengthMessage, minModelLength));
        }
    }

}
