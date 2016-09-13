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
import azubakov.edu.caloriescalc.models.MealItem;

/*import tomerbu.edu.fabaddmeal.R;
import tomerbu.edu.fabaddmeal.models.MealItem;*/




/**
 * A simple {@link Fragment} subclass.
 */
public class AddItem extends DialogFragment implements View.OnClickListener {

    private static String ARG_CATEGORY = "Category";
    EditText etKCal;
    EditText etWeight;
    EditText etProductName;
    EditText etProteinsBelki, etFats, etCarboydratesUglevodi;
    ImageButton ibAdd;
    private String category;


    public static AddItem newInstance(String categoryName) {
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, categoryName);
        AddItem fragment = new AddItem();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_add_item_vertical, container, false);

        this.category = getArguments().getString(ARG_CATEGORY);

        etKCal = (EditText) v.findViewById(R.id.etKCal);
        etWeight = (EditText) v.findViewById(R.id.etWeight);
        etProductName = (EditText) v.findViewById(R.id.etProductName);
        etProteinsBelki = (EditText) v.findViewById(R.id.etProteinsBelki);
        etFats = (EditText) v.findViewById(R.id.etFats);
        etCarboydratesUglevodi = (EditText) v.findViewById(R.id.etCarboydratesUglevodi);
        ibAdd = (ImageButton) v.findViewById(R.id.ibAdd);
        ibAdd.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        try {

           double cal, weight, proteins, fats, cabohydrates;
           String productName;


            String calString = etKCal.getText().toString();
            if (calString == null || calString.length() <= 0) {
                cal = 0D;
            } else {
                cal = Double.parseDouble(calString);
            }

            productName = etProductName.getText().toString();
            if (productName == null || productName.length() <= 0)
                productName = "";

            String weightString = etWeight.getText().toString();
            if (weightString == null || weightString.length() <= 0) {
                weight = 100D;
            } else {
                weight = Double.parseDouble(weightString);
            }

            String proteinsString = etProteinsBelki.getText().toString();
            if (proteinsString == null || proteinsString.length() <= 0) {
                proteins = 0D;
            } else {
                proteins = Double.parseDouble(proteinsString);
            }

            String fatsString = etFats.getText().toString();
            if (fatsString == null || fatsString.length() <= 0) {
                fats = 0D;
            } else {
                fats = Double.parseDouble(fatsString);
            }

            String cabohydratesString = etFats.getText().toString();
            if (cabohydratesString == null || cabohydratesString.length() <= 0) {
                cabohydrates  = 0D;
            } else {
                cabohydrates = Double.parseDouble(proteinsString);
            }

            //String uid1 = FirebaseAuth.getInstance().getCurrentUser().getUid();
            //DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(uid1).child(category);
            //MealItem item = new MealItem(productName, cal, weight, ref.getKey());
            //String uid...
            //
            // FireBaseDatabase.
            String uid1 = FirebaseAuth.getInstance().getCurrentUser().getUid();
            //DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(uid).child(category).push();
            //ActsItem item = new ActsItem(typeactivity, time, cal, ref.getKey());
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(uid1).child(category).push();
            //ActsItem item = new ActsItem(typeactivity, time, cal, ref.getKey());

            MealItem item = new MealItem(productName, cal, weight, proteins, fats, cabohydrates,ref.getKey());

            //FirebaseDatabase.getInstance().getReference().child(uid1).child(category).push().setValue(item);
            ref.setValue(item);
            dismiss();




        }
        catch (NumberFormatException e){
            Toast.makeText(getContext(), "Numbers Only", Toast.LENGTH_SHORT).show();
        }

    }
}
