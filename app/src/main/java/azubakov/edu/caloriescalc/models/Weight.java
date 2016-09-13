package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class Weight {
    private Double weight;


    public Weight() {
    }

    public Weight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "weight=" + weight +
                '}';
    }
}

