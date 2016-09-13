package azubakov.edu.caloriescalc.dialogs;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by stud27 on 21/08/16.
 */
public class AddItemDialogFragment implements View.OnClickListener {

    private static String ARG_CATEGORY = "Category";
    EditText etKCal;
    EditText etWeight;
    EditText etProductName;
    ImageButton ibAdd;
    private String category;

  /*  public static AddItem newInstance(String categoryName)
    {
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, categoryName);
        AddItem fragment = new AddItem();
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onClick(View view) {

    }
}
