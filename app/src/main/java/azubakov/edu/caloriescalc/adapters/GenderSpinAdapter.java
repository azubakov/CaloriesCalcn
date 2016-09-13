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

/**
 * Created by stud27 on 16/08/16.
 */
public class GenderSpinAdapter extends BaseAdapter implements AdapterView.OnItemSelectedListener {
     ArrayList<Gender> genders = new ArrayList<>();
     Context context;
    public static String gender;

    public GenderSpinAdapter(Context context) {
        this.context = context;
        genders.add(new Gender("1"));
        genders.add(new Gender("2"));
    }

    @Override
    public int getCount() {
        return genders.size();
        //return 0;
    }

    @Override
    public Object getItem(int i) {
        return genders.get(i);
        //return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
        //return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Gender gender = genders.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.gender_item, parent, false);

        TextView tvGenderName = (TextView) v.findViewById(R.id.tvGenderName);

        tvGenderName.setText(gender.getGenderName());

        return v;

        //return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Gender c = genders.get(position);
        gender = c.getGenderName().toString();
      /*  Intent intent = new Intent(context, ResultInfoBodyActivity.class);
        intent.putExtra("gender",gender);
        context.startActivity(intent);*/
        Toast.makeText(context, c.getGenderName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
