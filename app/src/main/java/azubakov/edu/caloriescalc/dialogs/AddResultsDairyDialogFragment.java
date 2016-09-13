package azubakov.edu.caloriescalc.dialogs;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.DaySumCalories;

/*import tomer.edu.firedemo1.R;
import tomer.edu.firedemo1.models.Todo;*/


/**
 * A simple {@link Fragment} subclass.
 */
public class AddResultsDairyDialogFragment extends DialogFragment {
    EditText etDate;
    EditText etSumBreakfast;
    EditText etSumLunch;
    EditText etSumDinner;
    EditText etSumSnakes;
    EditText etSumActs;
 //   EditText etDairySum;
    Button btnSave;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_results_dairy_dialog, container, false);

        //FIND Views By ID:
        etDate = (EditText) v.findViewById(R.id.etDate);
        etSumBreakfast = (EditText)v.findViewById(R.id.etSumBreakfast);
       /* etSumLunch = (EditText)v.findViewById(R.id.etSumLunch);*/
        etSumLunch = (EditText) v.findViewById(R.id.etSumLunch);
        etSumDinner = (EditText)v.findViewById(R.id.etSumDinner);
        etSumSnakes = (EditText)v.findViewById(R.id.etSumSnakes);
        etSumActs = (EditText)v.findViewById(R.id.etSumActs);
       // etDairySum = (EditText)v.findViewById(R.id.etDairySum);
        btnSave = (Button) v.findViewById(R.id.btnSave);

        //Set On Click Listener for btnSave
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTodoToFirebase();
            }
        });
        return v;
    }

    private void saveTodoToFirebase() {
        String date;
        Double sumbreakfast, sumlunch, sumdinner, sumsnakes, sumacts, dairysum;


        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();


        String uid = currentUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Dairy").child(uid);

        if (etDate == null || etDate.length() <= 0)
          date = "";
        else
        {
          date = etDate.getText().toString();
        }
        String SumBreakfastString = etSumBreakfast.getText().toString();
        if (SumBreakfastString == null || SumBreakfastString.length() <= 0) {
            sumbreakfast = 0D;
        } else {
            sumbreakfast = Double.parseDouble(SumBreakfastString.toString());
        }
        String SumLunchString = etSumLunch.getText().toString();
        if (SumLunchString == null || SumLunchString.length() <= 0) {
            sumlunch = 0D;
        } else {
            sumlunch = Double.parseDouble(SumLunchString.toString());
        }
        String SumDinnerString = etSumDinner.getText().toString();
        if (SumDinnerString == null || SumDinnerString.length() <= 0) {
            sumdinner = 0D;
        } else {
            sumdinner = Double.parseDouble(SumDinnerString.toString());
        }
        String SumSnakesString = etSumSnakes.getText().toString();
        if (SumSnakesString == null || SumSnakesString.length() <= 0) {
            sumsnakes = 0D;
        } else {
            sumsnakes = Double.parseDouble(SumSnakesString.toString());
        }
        String SumActsString = etSumActs.getText().toString();
        if (SumActsString == null || SumActsString.length() <= 0) {
            sumacts = 0D;
        } else {
            sumacts = Double.parseDouble(SumSnakesString.toString());
        }

        dairysum = sumbreakfast + sumlunch + sumdinner + sumsnakes - sumacts;

        //Double sumbreakfast = Double.parseDouble(etSumBreakfast.getText().toString());
        //Double sumlunch = Double.parseDouble(etSumLunch.getText().toString());
        /*Double sumdinner = Double.parseDouble(etSumDinner.getText().toString());
        Double sumsnakes = Double.parseDouble(etSumSnakes.getText().toString());
        Double sumacts = Double.parseDouble(etSumActs.getText().toString());
        Double dairysum = Double.parseDouble(etDairySum.getText().toString());*/
        DaySumCalories daysumcalories = new DaySumCalories(date, sumbreakfast, sumlunch, sumdinner, sumsnakes, sumacts, dairysum);


        ref.push().setValue(daysumcalories);
        dismiss();
    }
}
