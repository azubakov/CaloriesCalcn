package azubakov.edu.caloriescalc.models;

/**
 * Created by azubakov on 8/16/16.
 */
public class ActivitySpin {
    private String activityName;

    public ActivitySpin(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public String toString() {
        return "ActivitySpin{" +
                "activityName='" + activityName + '\'' +
                '}';
    }
}
