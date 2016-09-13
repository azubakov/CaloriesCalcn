package azubakov.edu.caloriescalc.adapters;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.BreadProducts;
import azubakov.edu.caloriescalc.models.PopularProducts;
import azubakov.edu.caloriescalc.utils.FirebaseRecyclerAdapter;

//import com.firebase.ui.database.FirebaseRecyclerAdapter;

/*import tomer.edu.firedemo1.R;
import tomer.edu.firedemo1.models.Todo;
import tomer.edu.firedemo1.utils.FirebaseRecyclerAdapter;*/

/**
 * 1) create an inner class of the viewHolder
 */
public class PopularProductsRecyclerAdapter extends FirebaseRecyclerAdapter<PopularProducts, PopularProductsRecyclerAdapter.PopularProductsViewHolder> {

    private final DatabaseReference ref;
    boolean isEnabled = true;

    public PopularProductsRecyclerAdapter(DatabaseReference ref) {
        //super(MilkProducts.class, R.layout.milk_item, MilkProductsViewHolder.class, ref);
        super(PopularProducts.class, R.layout.popular_item, PopularProductsViewHolder.class, ref );
        this.ref = ref;
    }

    @Override
    //protected void populateViewHolder(final TodosViewHolder viewHolder, final Todo model, final int position
    protected void populateViewHolder(final PopularProductsViewHolder viewHolder,final PopularProducts model,final int position) {
        /*viewHolder.tvTitle.setText(model.getTitle());
        viewHolder.tvDescription.setText(model.getContent());*/
        viewHolder.tvNamePopulProduct.setText(model.getPopularProduct());
        viewHolder.tvCaloriesHundredGramm.setText(model.getCaloriesHundredGramms().toString() + "" + " Kcal.");

        viewHolder.fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getRef(position).removeValue();
                ref.child(viewHolder.key).removeValue();
            }
        });
    }


    public static class PopularProductsViewHolder extends RecyclerView.ViewHolder {
        String key;
        TextView tvNamePopulProduct;
        TextView tvCaloriesHundredGramm;
        FloatingActionButton fabDelete;

        public PopularProductsViewHolder(View itemView) {
            super(itemView);

            tvNamePopulProduct = (TextView) itemView.findViewById(R.id.tvNamePopulProduct);
            tvCaloriesHundredGramm = (TextView) itemView.findViewById(R.id.tvCaloriesHundredGramm);
            fabDelete = (FloatingActionButton) itemView.findViewById(R.id.fabDelete);
        }
    }
}
