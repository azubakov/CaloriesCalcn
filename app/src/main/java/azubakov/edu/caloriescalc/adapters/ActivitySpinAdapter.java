package azubakov.edu.caloriescalc.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.activity.ResultInfoBodyActivity;
import azubakov.edu.caloriescalc.models.ActivitySpin;
import azubakov.edu.caloriescalc.models.AgeSpin;
import azubakov.edu.caloriescalc.models.Gender;

/**
 * Created by stud27 on 16/08/16.
 */
public class ActivitySpinAdapter extends BaseAdapter implements AdapterView.OnItemSelectedListener {
     ArrayList<ActivitySpin> activitynames = new ArrayList<>();
     Context context;
     public static String activityname = "";

    public ActivitySpinAdapter(Context context) {
        this.context = context;

        for (int i = 1; i < 6; i++) {
            activitynames.add(new ActivitySpin(i + ""));
        }
    }

    @Override
    public int getCount() {
        return activitynames.size();
        //return 0;
    }

    @Override
    public Object getItem(int i) {
        return activitynames.get(i);
        //return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
        //return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ActivitySpin activityname = activitynames.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.activity_item, parent, false);

        TextView tvActivityName = (TextView) v.findViewById(R.id.tvActivityName);

        tvActivityName.setText(activityname.getActivityName());

        return v;

        //return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        ActivitySpin c = activitynames.get(position);
        activityname = c.getActivityName().toString();
     /*   Intent intent = new Intent(context, ResultInfoBodyActivity.class);
        intent.putExtra("activity",activityname);
        context.startActivity(intent);*/
        Toast.makeText(context, c.getActivityName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
