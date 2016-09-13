package azubakov.edu.caloriescalc.dialogs;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.ActsItem;

/*import tomerbu.edu.fabaddmeal.R;
import tomerbu.edu.fabaddmeal.models.MealItem;*/


/**
 * A simple {@link Fragment} subclass.
 */
public class AddItemActs extends DialogFragment implements View.OnClickListener {

    private static String ARG_CATEGORY = "Category";
    EditText etTypeActivity;
    //MaterialTextField etTypeActivity;
    //TextInputLayout etTypeActivity;
    EditText etTimeActivity;
    //TextInputLayout etTimeActivity;
    EditText etKCal;
    //TextInputLayout etKCal;
    ImageButton ibAdd;
    private String category;


    public static AddItemActs newInstance(String categoryName) {
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, categoryName);
        AddItemActs fragment = new AddItemActs();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_add_item_acts, container, false);

        this.category = getArguments().getString(ARG_CATEGORY);

        etKCal = (EditText) v.findViewById(R.id.etKCal);
        //etKCal = (TextInputLayout) v.findViewById(R.id.etKCal);
        etTypeActivity = (EditText) v.findViewById(R.id.etTypeActivity);
        //etTypeActivity = (MaterialTextField) v.findViewById(R.id.etTypeActivity);
        //etTypeActivity = (TextInputLayout) v.findViewById(R.id.etTypeActivity);
        etTimeActivity = (EditText) v.findViewById(R.id.etTimeActivity);
        //etTimeActivity = (TextInputLayout) v.findViewById(R.id.etTimeActivity);
        ibAdd = (ImageButton) v.findViewById(R.id.ibAdd);
        ibAdd.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        try {
            double cal = Double.valueOf(etKCal.getText().toString());
            //double cal = Double.valueOf(etKCal.getEditText().toString());
            //double weight = Double.valueOf(etKCal.getText().toString());
            double time = Double.valueOf(etTimeActivity.getText().toString());
            ////double time = Double.valueOf(etTimeActivity.getText().toString());
            ////double time = Double.valueOf(etTimeActivity.getEditText().toString());
            //String productName = etKCal.getText().toString();
            String typeactivity = etTypeActivity.getText().toString();
            ////String typeactivity = etTypeActivity.getEditText().toString();
            // FireBaseDatabase.
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(uid).child(category).push();

            ActsItem item = new ActsItem(typeactivity, time, cal, ref.getKey());
            //String uid...
            //

            ref.setValue(item);
            dismiss();
        }
        catch (NumberFormatException e){
            Toast.makeText(getContext(), "Numbers Only", Toast.LENGTH_SHORT).show();
        }

    }
}
