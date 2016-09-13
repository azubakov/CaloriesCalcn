package azubakov.edu.caloriescalc.models;

/**
 * Created by azubakov on 8/16/16.
 */
public class AgeSpin {
    private String age;

    public AgeSpin(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AgeSpin{" +
                "age='" + age + '\'' +
                '}';
    }
}
