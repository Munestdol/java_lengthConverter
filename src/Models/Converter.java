package Models;

/**
 *  <code> Converter </code> is a class
 *  , which contains the fields intended for converting values and methods for their access.
 *
 * @author Kirillov P.S.
 */

public class Converter {
    private float millimeter;
    private float cantimeter;
    private float meter;
    private float kilometer;
    private float foot;
    private float mile;

    /**
     * Adjusts coefficients for centimeters
     */
    public void ForCantimeter(){
         millimeter = 10;
         cantimeter = 1;
         meter = 0.01f;
         kilometer = 0.00001f;
         foot = (1f/30.48f);
         mile = (1f/160934f);
    }
    /**
     * Adjusts coefficients for meters
     */
    public void ForMeter(){
         millimeter = 1000;
         cantimeter = 100;
         meter = 1;
         kilometer = 0.001f;
         foot = 3.281f;
         mile = (1f/1609f);
    }
    /**
     * Adjusts coefficients for millimeters
     */
    public void ForMillimeter(){
        millimeter = 1;
        cantimeter = 0.1f;
        meter = 0.001f;
        kilometer = 0.000001f;
        foot = (1f/305f);
        mile = (1f/1609340f);
    }
    /**
     * Adjusts coefficients for kilometers
     */
    public void ForKilometer(){
        millimeter = 1000000;
        cantimeter = 100000;
        meter = 1000;
        kilometer = 1;
        foot = 3280.84f;
        mile = (1f/1.609f);
    }

    /**
     * Adjusts coefficients for foot
     */
    public void ForFoot() {
        millimeter = 304.8f;
        cantimeter = 30.48f;
        meter = 0.3048f;
        kilometer = 0.003048f;
        foot = 1;
        mile = (1f/ 5280f);
    }

    /**
     * Adjusts coefficients for mile
     */
    public void ForMile() {
        millimeter = 1609340;
        cantimeter = 160934;
        meter = 1609.34f;
        kilometer = 1.60934f;
        foot = 5280;
        mile = 1;
    }


    public float getCantimeter() {
        return cantimeter;
    }

    public float getFoot() {
        return foot;
    }

    public float getKilometer() {
        return kilometer;
    }

    public float getMeter() {
        return meter;
    }

    public float getMile() {
        return mile;
    }

    public float getMillimeter() {
        return millimeter;
    }
}
