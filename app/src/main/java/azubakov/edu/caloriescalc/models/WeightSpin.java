package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 16/08/16.
 */
public class WeightSpin {
    private String weightName;

    public WeightSpin(String weightName) {
        this.weightName = weightName;
    }

    public String getWeightName() {
        return weightName;
    }

    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }

    @Override
    public String toString() {
        return "WeightSpin{" +
                "weightName='" + weightName + '\'' +
                '}';
    }
}
