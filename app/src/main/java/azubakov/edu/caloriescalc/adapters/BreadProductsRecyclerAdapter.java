package azubakov.edu.caloriescalc.adapters;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.BreadProducts;
import azubakov.edu.caloriescalc.models.MilkProducts;
import azubakov.edu.caloriescalc.utils.FirebaseRecyclerAdapter;

//import com.firebase.ui.database.FirebaseRecyclerAdapter;

/*import tomer.edu.firedemo1.R;
import tomer.edu.firedemo1.models.Todo;
import tomer.edu.firedemo1.utils.FirebaseRecyclerAdapter;*/

/**
 * 1) create an inner class of the viewHolder
 */
public class BreadProductsRecyclerAdapter extends FirebaseRecyclerAdapter<BreadProducts, BreadProductsRecyclerAdapter.BreadProductsViewHolder> {

    private final DatabaseReference ref;
    boolean isEnabled = true;

    public BreadProductsRecyclerAdapter(DatabaseReference ref) {
        //super(MilkProducts.class, R.layout.milk_item, MilkProductsViewHolder.class, ref);
        super(BreadProducts.class, R.layout.bread_item, BreadProductsViewHolder.class, ref );
        this.ref = ref;
    }

    @Override
    //protected void populateViewHolder(final TodosViewHolder viewHolder, final Todo model, final int position
    protected void populateViewHolder(final BreadProductsViewHolder viewHolder,final BreadProducts model,final int position) {
        /*viewHolder.tvTitle.setText(model.getTitle());
        viewHolder.tvDescription.setText(model.getContent());*/
        viewHolder.tvNameBreadProduct.setText(model.getBreadProduct());
        viewHolder.tvCaloriesHundredGramm.setText(model.getCaloriesHundredGramms().toString() + "" + " Kcal.");

        viewHolder.fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getRef(position).removeValue();
                ref.child(viewHolder.key).removeValue();
            }
        });
    }


    public static class BreadProductsViewHolder extends RecyclerView.ViewHolder {
        String key;
        TextView tvNameBreadProduct;
        TextView tvCaloriesHundredGramm;
        FloatingActionButton fabDelete;

        public BreadProductsViewHolder(View itemView) {
            super(itemView);

            tvNameBreadProduct = (TextView) itemView.findViewById(R.id.tvNameBreadProduct);
            tvCaloriesHundredGramm = (TextView) itemView.findViewById(R.id.tvCaloriesHundredGramm);
            fabDelete = (FloatingActionButton) itemView.findViewById(R.id.fabDelete);
        }
    }
}
