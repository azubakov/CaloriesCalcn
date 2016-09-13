package azubakov.edu.caloriescalc.models;

/**
 * Created by azubakov on 8/16/16.
 */
public class HeightSpin {
    private String height;

    public HeightSpin(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "HeightSpin{" +
                "height='" + height + '\'' +
                '}';
    }
}
