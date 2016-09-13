package azubakov.edu.caloriescalc.models;

/**
 * Created by user1 on 22.08.2016.
 */
public class DaySumCalories {

    String date;
    Double sumbreakfast;
    Double sumlunch;
    Double sumdinner;
    Double sumsnakes;
    Double sumacts;
    Double sumdayproteins;
    Double sumdayfats;
    Double sumdaycarbohydrates;
    Double daysumcal;


    public DaySumCalories(){
    }


    public DaySumCalories(String date, Double sumbreakfast, Double sumlunch, Double sumdinner, Double sumsnakes, Double sumacts, Double daysumcal) {
        this.date = date;
        this.sumbreakfast = sumbreakfast;
        this.sumlunch = sumlunch;
        this.sumdinner = sumdinner;
        this.sumsnakes = sumsnakes;
        this.sumacts = sumacts;
        this.daysumcal = daysumcal;
    }

    public DaySumCalories(String date, Double sumbreakfast, Double sumlunch, Double sumdinner, Double sumsnakes, Double sumacts, Double sumdayproteins, Double sumdayfats, Double sumdaycarbohydrates, Double daysumcal) {
        this.date = date;
        this.sumbreakfast = sumbreakfast;
        this.sumlunch = sumlunch;
        this.sumdinner = sumdinner;
        this.sumsnakes = sumsnakes;
        this.sumacts = sumacts;
        this.sumdayproteins = sumdayproteins;
        this.sumdayfats = sumdayfats;
        this.sumdaycarbohydrates = sumdaycarbohydrates;
        this.daysumcal = daysumcal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getSumbreakfast() {
        return sumbreakfast;
    }

    public void setSumbreakfast(Double sumbreakfast) {
        this.sumbreakfast = sumbreakfast;
    }

    public Double getSumlunch() {
        return sumlunch;
    }

    public void setSumlunch(Double sumlunch) {
        this.sumlunch = sumlunch;
    }

    public Double getSumdinner() {
        return sumdinner;
    }

    public void setSumdinner(Double sumdinner) {
        this.sumdinner = sumdinner;
    }

    public Double getSumsnakes() {
        return sumsnakes;
    }

    public void setSumsnakes(Double sumsnakes) {
        this.sumsnakes = sumsnakes;
    }

    public Double getSumacts() {
        return sumacts;
    }

    public void setSumacts(Double sumacts) {
        this.sumacts = sumacts;
    }

    public Double getSumdayproteins() {
        return sumdayproteins;
    }

    public void setSumdayproteins(Double sumdayproteins) {
        this.sumdayproteins = sumdayproteins;
    }

    public Double getSumdayfats() {
        return sumdayfats;
    }

    public void setSumdayfats(Double sumdayfats) {
        this.sumdayfats = sumdayfats;
    }

    public Double getSumdaycarbohydrates() {
        return sumdaycarbohydrates;
    }

    public void setSumdaycarbohydrates(Double sumdaycarbohydrates) {
        this.sumdaycarbohydrates = sumdaycarbohydrates;
    }

    public Double getDaysumcal() {
        return daysumcal;
    }

    public void setDaysumcal(Double daysumcal) {
        this.daysumcal = daysumcal;
    }

    @Override
    public String toString() {
        return "DaySumCalories{" +
                "date='" + date + '\'' +
                ", sumbreakfast=" + sumbreakfast +
                ", sumlunch=" + sumlunch +
                ", sumdinner=" + sumdinner +
                ", sumsnakes=" + sumsnakes +
                ", sumacts=" + sumacts +
                ", sumdayproteins=" + sumdayproteins +
                ", sumdayfats=" + sumdayfats +
                ", sumdaycarbohydrates=" + sumdaycarbohydrates +
                ", daysumcal=" + daysumcal +
                '}';
    }
}
