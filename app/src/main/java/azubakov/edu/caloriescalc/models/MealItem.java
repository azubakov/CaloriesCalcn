package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 21/08/16.
 */
public class MealItem /*TODO: Implement Parceble*/ {
       private String productname;
       private double kcal;
       private double grams;
       private double proteins;
       private double fats;
       private double carbohydrates;
       private String key;

    public MealItem() {
    }

    public MealItem(String productname, double kcal, double grams, double proteins, double fats, double carbohydrates, String key) {
        this.productname = productname;
        this.kcal = kcal;
        this.grams = grams;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.key = key;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "MealItem{" +
                "productname='" + productname + '\'' +
                ", kcal=" + kcal +
                ", grams=" + grams +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", key='" + key + '\'' +
                '}';
    }
}
