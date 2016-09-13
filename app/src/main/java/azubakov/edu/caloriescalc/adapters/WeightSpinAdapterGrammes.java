package azubakov.edu.caloriescalc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.WeightSpin;
import azubakov.edu.caloriescalc.models.WeightSpinGramm;

/**
 * Created by stud27 on 16/08/16.
 */
public class WeightSpinAdapterGrammes extends BaseAdapter implements AdapterView.OnItemSelectedListener {
     ArrayList<WeightSpinGramm> weightgramms = new ArrayList<>();
     Context context;

    public WeightSpinAdapterGrammes(Context context) {
        this.context = context;
        for (int i = 1; i < 10; i++) {
            weightgramms.add(new WeightSpinGramm(i + ""));
        }
    }

    @Override
    public int getCount() {
        return weightgramms.size();
        //return 0;
    }

    @Override
    public Object getItem(int i) {
        return weightgramms.get(i);
        //return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
        //return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        WeightSpinGramm weightspingramm = weightgramms.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.weight_item_grammes, parent, false);

        TextView tvWeightNameGrammes = (TextView) v.findViewById(R.id.tvWeightNameGrammes);

        tvWeightNameGrammes.setText(weightspingramm.getWeightNameGramm());

        return v;

        //return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        //WeightSpin c = weights.get(position);
        WeightSpinGramm c = weightgramms.get(position);
        Toast.makeText(context, c.getWeightNameGramm(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
