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
import azubakov.edu.caloriescalc.models.FruitsProducts;
import azubakov.edu.caloriescalc.models.MilkProducts;

/*import tomer.edu.firedemo1.R;
import tomer.edu.firedemo1.models.Todo;*/


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFruitsProductsDialogFragment extends DialogFragment {
    EditText etProduct;
    EditText etCaloriesHundredGr;
    Button btnSave;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_fruits_product_dialog, container, false);

        //FIND Views By ID:
        etProduct = (EditText) v.findViewById(R.id.etProduct);
        etCaloriesHundredGr = (EditText)v.findViewById(R.id.etCaloriesHundredGr);
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
        String product;
        Double calorieshundredgramm;
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();


        String uid = currentUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("FruitsProducts").child(uid);

        //Todo todo = new Todo(etTitle.getText().toString(), etMessage.getText().toString());

        if (etProduct == null || etProduct.length() <= 0)
            product = "";
        else
        {
            product = etProduct.getText().toString();
        }
        String CaloriesHundredGrString = etCaloriesHundredGr.getText().toString();
        if (CaloriesHundredGrString == null || CaloriesHundredGrString.length() <= 0) {
            calorieshundredgramm = 0D;
        } else {
            calorieshundredgramm = Double.parseDouble(CaloriesHundredGrString.toString());
        }
        //MilkProducts milkproducts = new MilkProducts(etProduct.getText().toString(), Double.parseDouble(etCaloriesHundredGr.getText().toString()));
        FruitsProducts fruitsproducts = new FruitsProducts(product,calorieshundredgramm);

        ref.push().setValue(fruitsproducts);
        dismiss();
    }
}
