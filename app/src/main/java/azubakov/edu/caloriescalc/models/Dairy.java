package azubakov.edu.caloriescalc.models;

/**
 * Created by user1 on 18.08.2016.
 */
public class Dairy {

   /* String nameproductbreakfast;
    Double grammbreakfast;
    Double etkcalbreakfast;*/
    String date;
    Double sumcalbreakfast;


    /*String nameproductlunch;
    Double grammlunch;
    Double kcallunch;*/
    Double sumcallunch;


    /*String nameproductdinner;
    Double grammdinner;
    Double kcaldinner;*/
    Double sumcaldinner;


    /*String nameproductsnakes;
    Double grammsnakes;
    Double kcalsnakes;*/
    Double sumcalsnakes;


    /*String nameproductacts;
    Double grammacts;
    Double kcalacts;*/
    Double sumcalacts;

    Double sumcal;

    public Dairy(Double sumcalbreakfast, Double sumcallunch, Double sumcaldinner, Double sumcalsnakes, Double sumcalacts, Double sumcal) {
        this.sumcalbreakfast = sumcalbreakfast;
        this.sumcallunch = sumcallunch;
        this.sumcaldinner = sumcaldinner;
        this.sumcalsnakes = sumcalsnakes;
        this.sumcalacts = sumcalacts;
        this.sumcal = sumcal;
    }

    public Dairy(String date, Double sumcalbreakfast, Double sumcallunch, Double sumcaldinner, Double sumcalsnakes, Double sumcalacts, Double sumcal) {
        this.date = date;
        this.sumcalbreakfast = sumcalbreakfast;
        this.sumcallunch = sumcallunch;
        this.sumcaldinner = sumcaldinner;
        this.sumcalsnakes = sumcalsnakes;
        this.sumcalacts = sumcalacts;
        this.sumcal = sumcal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getSumcalbreakfast() {
        return sumcalbreakfast;
    }

    public void setSumcalbreakfast(Double sumcalbreakfast) {
        this.sumcalbreakfast = sumcalbreakfast;
    }

    public Double getSumcallunch() {
        return sumcallunch;
    }

    public void setSumcallunch(Double sumcallunch) {
        this.sumcallunch = sumcallunch;
    }

    public Double getSumcaldinner() {
        return sumcaldinner;
    }

    public void setSumcaldinner(Double sumcaldinner) {
        this.sumcaldinner = sumcaldinner;
    }

    public Double getSumcalsnakes() {
        return sumcalsnakes;
    }

    public void setSumcalsnakes(Double sumcalsnakes) {
        this.sumcalsnakes = sumcalsnakes;
    }

    public Double getSumcalacts() {
        return sumcalacts;
    }

    public void setSumcalacts(Double sumcalacts) {
        this.sumcalacts = sumcalacts;
    }

    public Double getSumcal() {
        return sumcal;
    }

    public void setSumcal(Double sumcal) {
        this.sumcal = sumcal;
    }

    @Override
    public String toString() {
        return "Dairy{" +
                "date='" + date + '\'' +
                ", sumcalbreakfast=" + sumcalbreakfast +
                ", sumcallunch=" + sumcallunch +
                ", sumcaldinner=" + sumcaldinner +
                ", sumcalsnakes=" + sumcalsnakes +
                ", sumcalacts=" + sumcalacts +
                ", sumcal=" + sumcal +
                '}';
    }
}





