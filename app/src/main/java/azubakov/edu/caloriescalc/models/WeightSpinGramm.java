package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 16/08/16.
 */
public class WeightSpinGramm {
    private String weightNameGramm;

    public WeightSpinGramm(String weightNameGramm) {
        this.weightNameGramm = weightNameGramm;
    }

    public String getWeightNameGramm() {
        return weightNameGramm;
    }

    public void setWeightNameGramm(String weightNameGramm) {
        this.weightNameGramm = weightNameGramm;
    }

    @Override
    public String toString() {
        return "WeightSpinGramm{" +
                "weightNameGramm='" + weightNameGramm + '\'' +
                '}';
    }
}
