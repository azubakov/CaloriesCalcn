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
import azubakov.edu.caloriescalc.models.AgeSpin;
import azubakov.edu.caloriescalc.models.WeightSpin;

/**
 * Created by stud27 on 16/08/16.
 */
public class AgeSpinAdapter extends BaseAdapter implements AdapterView.OnItemSelectedListener {
     ArrayList<AgeSpin> ages = new ArrayList<>();
     Context context;
    public static  String age = "";

    public AgeSpinAdapter(Context context) {
        this.context = context;
        for (int i = 1; i < 250; i++) {
            ages.add(new AgeSpin(i + ""));
        }

    }

    @Override
    public int getCount() {
        return ages.size();
        //return 0;
    }

    @Override
    public Object getItem(int i) {
        return ages.get(i);
        //return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
        //return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        AgeSpin agespin = ages.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.age_item, parent, false);

        TextView tvAgeName = (TextView) v.findViewById(R.id.tvAgeName);

        tvAgeName.setText(agespin.getAge());

        return v;

        //return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        AgeSpin c = ages.get(position);
        age = c.getAge().toString();
        /*Intent intent = new Intent(this, ResultInfoBodyActivity.class);
        intent.putExtra("date", etDate.getText().toString());
        intent.putExtra("gender", etGender.getText().toString());
        intent.putExtra("weight", etWeight.getText().toString());
        intent.putExtra("age", etAge.getText().toString());
        intent.putExtra("height", etHeight.getText().toString());
        intent.putExtra("activity", etActivity.getText().toString());*/
       /* Intent intent = new Intent(context, ResultInfoBodyActivity.class);
        intent.putExtra("age",age);
        context.startActivity(intent);*/
        Toast.makeText(context, age, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
