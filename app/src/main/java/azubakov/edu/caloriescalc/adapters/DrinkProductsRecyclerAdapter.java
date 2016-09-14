package azubakov.edu.caloriescalc.adapters;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.DrinkProducts;
import azubakov.edu.caloriescalc.models.MilkProducts;
import azubakov.edu.caloriescalc.utils.FirebaseRecyclerAdapter;

//import com.firebase.ui.database.FirebaseRecyclerAdapter;

/*import tomer.edu.firedemo1.R;
import tomer.edu.firedemo1.models.Todo;
import tomer.edu.firedemo1.utils.FirebaseRecyclerAdapter;*/

/**
 * 1) create an inner class of the viewHolder
 */
public class DrinkProductsRecyclerAdapter extends FirebaseRecyclerAdapter<DrinkProducts, DrinkProductsRecyclerAdapter.DrinkProductsViewHolder> {

    private final DatabaseReference ref;
    boolean isEnabled = true;

    public DrinkProductsRecyclerAdapter(DatabaseReference ref) {
                super(DrinkProducts.class, R.layout.drink_item, DrinkProductsViewHolder.class, ref);
        this.ref = ref;
    }

    @Override
    //protected void populateViewHolder(final TodosViewHolder viewHolder, final Todo model, final int position
    protected void populateViewHolder(final DrinkProductsViewHolder viewHolder,final DrinkProducts model,final int position) {
        /*viewHolder.tvTitle.setText(model.getTitle());
        viewHolder.tvDescription.setText(model.getContent());*/
        viewHolder.tvNameDrinkProduct.setText(model.getDrinkProduct() + "");
        viewHolder.tvCaloriesHundredGramm.setText(model.getCaloriesHundredGramms().toString() + "" + " Kcal.");

        viewHolder.fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getRef(position).removeValue();
                ref.child(viewHolder.key).removeValue();
            }
        });
    }


    public static class DrinkProductsViewHolder extends RecyclerView.ViewHolder {
        String key;
        TextView tvNameDrinkProduct;
        TextView tvCaloriesHundredGramm;
        FloatingActionButton fabDelete;

        public DrinkProductsViewHolder(View itemView) {
            super(itemView);

            tvNameDrinkProduct = (TextView) itemView.findViewById(R.id.tvNameDrinkProduct);
            tvCaloriesHundredGramm = (TextView) itemView.findViewById(R.id.tvCaloriesHundredGramm);
            fabDelete = (FloatingActionButton) itemView.findViewById(R.id.fabDelete);
        }
    }
}
