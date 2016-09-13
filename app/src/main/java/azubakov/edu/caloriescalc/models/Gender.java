package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 16/08/16.
 */
public class Gender {
    private String genderName;

    public Gender(String genderName) {
        this.genderName = genderName;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderName='" + genderName + '\'' +
                '}';
    }
}
