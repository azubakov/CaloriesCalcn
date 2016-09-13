package azubakov.edu.caloriescalc.models;

/**
 * Created by azubakov on 8/14/16.
 */
public class Body {

    String date;
    Integer gender;
    Double weight;
    Double age;
    Double height;
    Integer activity;
    Double bmi;
    String descriptionbmi;
    Double harbencalold;
    Double harbencalnew;
    Double miffilincal;
    Double avgcal;
    Double mincal;
    Double maxcal;
    Double slim;
    Double extraslim;
    Double fat;
    Double extrafat;

    public Body() {

    }

    public Body(String date, Integer gender, Double weight, Double age, Double height, Integer activity) {
        this.date = date;
        this.gender = gender;
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.activity = activity;
    }

    public Body(String date, Integer gender, Double weight,
                Double age, Double height, Integer activity,
                Double slim, Double extraslim, Double fat, Double extrafat) {
        this.date = date;
        this.gender = gender;
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.activity = activity;
        this.slim = slim;
        this.extraslim = extraslim;
        this.fat = fat;
        this.extrafat = extrafat;
    }

    public Body(String date, Integer gender, Double weight,
                Double age, Double height, Integer activity,
                Double bmi, String descriptionbmi, Double harbencalold,
                Double harbencalnew, Double miffilincal, Double avgcal,
                Double mincal, Double maxcal, Double slim, Double extraslim,
                Double fat, Double extrafat) {
        this.date = date;
        this.gender = gender;
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.activity = activity;
        this.bmi = bmi;
        this.descriptionbmi = descriptionbmi;
        this.harbencalold = harbencalold;
        this.harbencalnew = harbencalnew;
        this.miffilincal = miffilincal;
        this.avgcal = avgcal;
        this.mincal = mincal;
        this.maxcal = maxcal;
        this.slim = slim;
        this.extraslim = extraslim;
        this.fat = fat;
        this.extrafat = extrafat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public String getDescriptionbmi() {
        return descriptionbmi;
    }

    public void setDescriptionbmi(String descriptionbmi) {
        this.descriptionbmi = descriptionbmi;
    }

    public Double getHarbencalold() {
        return harbencalold;
    }

    public void setHarbencalold(Double harbencalold) {
        this.harbencalold = harbencalold;
    }

    public Double getHarbencalnew() {
        return harbencalnew;
    }

    public void setHarbencalnew(Double harbencalnew) {
        this.harbencalnew = harbencalnew;
    }

    public Double getMiffilincal() {
        return miffilincal;
    }

    public void setMiffilincal(Double miffilincal) {
        this.miffilincal = miffilincal;
    }

    public Double getAvgcal() {
        return avgcal;
    }

    public void setAvgcal(Double avgcal) {
        this.avgcal = avgcal;
    }

    public Double getMincal() {
        return mincal;
    }

    public void setMincal(Double mincal) {
        this.mincal = mincal;
    }

    public Double getMaxcal() {
        return maxcal;
    }

    public void setMaxcal(Double maxcal) {
        this.maxcal = maxcal;
    }

    public Double getSlim() {
        return slim;
    }

    public void setSlim(Double slim) {
        this.slim = slim;
    }

    public Double getExtraslim() {
        return extraslim;
    }

    public void setExtraslim(Double extraslim) {
        this.extraslim = extraslim;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getExtrafat() {
        return extrafat;
    }

    public void setExtrafat(Double extrafat) {
        this.extrafat = extrafat;
    }

    @Override
    public String toString() {
        return "Body{" +
                "date='" + date + '\'' +
                ", gender=" + gender +
                ", weight=" + weight +
                ", age=" + age +
                ", height=" + height +
                ", activity=" + activity +
                ", bmi=" + bmi +
                ", descriptionbmi='" + descriptionbmi + '\'' +
                ", harbencalold=" + harbencalold +
                ", harbencalnew=" + harbencalnew +
                ", miffilincal=" + miffilincal +
                ", avgcal=" + avgcal +
                ", mincal=" + mincal +
                ", maxcal=" + maxcal +
                ", slim=" + slim +
                ", extraslim=" + extraslim +
                ", fat=" + fat +
                ", extrafat=" + extrafat +
                '}';
    }
}