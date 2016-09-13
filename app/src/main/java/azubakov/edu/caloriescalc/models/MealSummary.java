package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 24/08/16.
 */
public class MealSummary {
    private double sumGrams;
    private double sumCalories;
    private double sumProteins;
    private double sumFats;
    private double sumCarbohydrates;
    private int count;
    private String categoryName;

    public MealSummary() {

    }

 /*   public MealSummary(double sumGrams, double sumCalories, int count, String categoryName) {
        this.sumGrams = sumGrams;
        this.sumCalories = sumCalories;
        this.count = count;
        this.categoryName = categoryName;
    }*/

    public MealSummary(double sumGrams, double sumCalories, double sumProteins, double sumFats, double sumCarbohydrates, int count, String categoryName) {
        this.sumGrams = sumGrams;
        this.sumCalories = sumCalories;
        this.sumProteins = sumProteins;
        this.sumFats = sumFats;
        this.sumCarbohydrates = sumCarbohydrates;
        this.count = count;
        this.categoryName = categoryName;
    }

    public double getSumGrams() {
        return sumGrams;
    }

    public void setSumGrams(double sumGrams) {
        this.sumGrams = sumGrams;
    }

    public double getSumCalories() {
        return sumCalories;
    }

    public void setSumCalories(double sumCalories) {
        this.sumCalories = sumCalories;
    }

    public double getSumProteins() {
        return sumProteins;
    }

    public void setSumProteins(double sumProteins) {
        this.sumProteins = sumProteins;
    }

    public double getSumFats() {
        return sumFats;
    }

    public void setSumFats(double sumFats) {
        this.sumFats = sumFats;
    }

    public double getSumCarbohydrates() {
        return sumCarbohydrates;
    }

    public void setSumCarbohydrates(double sumCarbohydrates) {
        this.sumCarbohydrates = sumCarbohydrates;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "MealSummary{" +
                "sumGrams=" + sumGrams +
                ", sumCalories=" + sumCalories +
                ", sumProteins=" + sumProteins +
                ", sumFats=" + sumFats +
                ", sumCarbohydrates=" + sumCarbohydrates +
                ", count=" + count +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
