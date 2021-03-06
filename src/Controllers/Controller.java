package Controllers;

/**
 * <code> Controller </code> is a class
 *  , which contains a method to convert one length unit to another.
 *
 * @author Kirillov P.S.
 */

public class Controller {
    /**
     * Converts one unit of measurement to another by multiplying the original value by a coefficient
     */
    public float LengthConverter(float inputValue, float valueConvert){
        return inputValue*valueConvert;
    }
}
