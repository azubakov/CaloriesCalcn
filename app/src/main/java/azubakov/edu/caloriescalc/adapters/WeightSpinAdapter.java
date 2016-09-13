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
import azubakov.edu.caloriescalc.models.Gender;
import azubakov.edu.caloriescalc.models.WeightSpin;

/**
 * Created by stud27 on 16/08/16.
 */
public class WeightSpinAdapter extends BaseAdapter implements AdapterView.OnItemSelectedListener {
     ArrayList<WeightSpin> weights = new ArrayList<>();
     Context context;
    public static String weight;

    public WeightSpinAdapter(Context context) {
        this.context = context;
        for (int i = 1; i < 250; i++) {
            weights.add(new WeightSpin(i + ""));
        }
    }

    @Override
    public int getCount() {
        return weights.size();
        //return 0;
    }

    @Override
    public Object getItem(int i) {
        return weights.get(i);
        //return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
        //return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        WeightSpin weight = weights.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.weight_item, parent, false);

        TextView tvWeightName = (TextView) v.findViewById(R.id.tvWeightName);

        tvWeightName.setText(weight.getWeightName());

        return v;

        //return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        WeightSpin c = weights.get(position);
        weight = c.getWeightName().toString();
        /*Intent intent = new Intent(context, ResultInfoBodyActivity.class);
        intent.putExtra("weight",weight);
        context.startActivity(intent);*/
        Toast.makeText(context, c.getWeightName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
