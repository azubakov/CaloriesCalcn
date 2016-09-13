package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 21/08/16.
 */
public class ActsItem /*TODO: Implement Parceble*/ {
    private String typeactivity;
    private Double minuts;
    private double kcal;
    private String key;

    public ActsItem() {
    }



    public ActsItem(String typeactivity, Double minuts, double kcal, String key) {
        this.typeactivity = typeactivity;
        this.minuts = minuts;
        this.kcal = kcal;
        this.key = key;

    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getTypeactivity() {
        return typeactivity;
    }

    public void setTypeactivity(String typeactivity) {
        this.typeactivity = typeactivity;
    }

    public Double getMinuts() {
        return minuts;
    }

    public void setMinuts(Double minuts) {
        this.minuts = minuts;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "ActsItem{" +
                "typeactivity='" + typeactivity + '\'' +
                ", minuts=" + minuts +
                ", kcal=" + kcal +
                '}';
    }
}
