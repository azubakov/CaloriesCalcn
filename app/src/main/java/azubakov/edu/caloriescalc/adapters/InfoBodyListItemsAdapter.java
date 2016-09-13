package azubakov.edu.caloriescalc.adapters;



import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.ActsItem;
import azubakov.edu.caloriescalc.models.Body;
import azubakov.edu.caloriescalc.utils.FirebaseRecyclerAdapter;

/**
 * Created by azubakov on 8/15/16.
 */
public class InfoBodyListItemsAdapter extends FirebaseRecyclerAdapter<Body, InfoBodyListItemsAdapter.InfoBodyViewHolder> {

    private final DatabaseReference ref;
    //private final Context context;


    public InfoBodyListItemsAdapter(DatabaseReference ref) {
        //super(Todo.class, R.layout.todo_item, TodosViewHolder.class, ref);
        super(Body.class, R.layout.body_list_item, InfoBodyViewHolder.class, ref);
      //  this.context = context;
        this.ref = ref;
    }

    @Override
    protected void populateViewHolder(final InfoBodyViewHolder viewHolder, final Body model, int position) {
        //viewHolder.tvTitle.setText(model.getTitle());
          viewHolder.tvDate1.setText(model.getDate());
          viewHolder.tvGender.setText("Gender: " + model.getGender().toString());
          viewHolder.tvWeight.setText("Weight: " + model.getWeight().toString() + " kg");
          viewHolder.tvAge.setText("Age: " + model.getAge().toString() + " years");
          viewHolder.tvHeight.setText("Height: " + model.getHeight().toString() + " sm.");
          viewHolder.tvActivity.setText("Act: " + model.getActivity().toString());
          viewHolder.tvbmi.setText("Bmi: " + model.getBmi().toString());
          viewHolder.tvDescbmi.setText("Desc: " + model.getDescriptionbmi().toString());
    //      viewHolder.tvHarbencalold.setText(model.getHarbencalold().toString());
    //      viewHolder.tvHarbencalnew.setText(model.getHarbencalnew().toString());
    //      viewHolder.tvMiffilinCal.setText(model.getMiffilincal().toString());
    //      viewHolder.tvAvgCal.setText(model.getAvgcal().toString());
    //      viewHolder.tvMinCal.setText(model.getMincal().toString());
    //      viewHolder.tvMaxCal.setText(model.getMaxcal().toString());
          viewHolder.tvSlim.setText("Slim: " + model.getSlim().toString() + " Kcal");
          viewHolder.tvExtraSlim.setText("Extra: " + model.getExtraslim().toString() + " Kcal");
          viewHolder.tvFat.setText("Fat: " + model.getFat().toString() + " Kcal" );
          viewHolder.tvExtraFat.setText("Extra: " + model.getExtrafat().toString() + " Kcal");



        viewHolder.fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getRef(position).removeValue();
                ref.child(viewHolder.key).removeValue();
            }
        });


    }

    public static class InfoBodyViewHolder extends RecyclerView.ViewHolder {
        String key;
        RelativeLayout layout;
        LinearLayout linearlayout1;
        TextView tvDate1, tvGender, tvWeight, tvAge, tvHeight, tvActivity, tvbmi, tvMinCal, tvMaxCal;
        TextView tvDescbmi, tvHarbencalold, tvHarbencalnew, tvMiffilinCal, tvAvgCal, tvSlim, tvExtraSlim, tvFat, tvExtraFat;
       // ImageView ivDelete;
        FloatingActionButton fabDelete;

        public InfoBodyViewHolder(View itemView) {
            super(itemView);

            layout = (RelativeLayout) itemView.findViewById(R.id.layout);
            linearlayout1 = (LinearLayout) itemView.findViewById(R.id.linearlayout1);
            tvDate1 = (TextView) itemView.findViewById(R.id.tvDate1);
            tvGender = (TextView) itemView.findViewById(R.id.tvGender);
            tvWeight = (TextView) itemView.findViewById(R.id.tvWeight);
            tvAge = (TextView) itemView.findViewById(R.id.tvAge);
            tvHeight = (TextView) itemView.findViewById(R.id.tvHeight);
            tvActivity = (TextView) itemView.findViewById(R.id.tvActivity);
            tvbmi = (TextView) itemView.findViewById(R.id.tvbmi);
            tvDescbmi = (TextView) itemView.findViewById(R.id.tvDescbmi);
        //    tvHarbencalold = (TextView) itemView.findViewById(R.id.tvHarbencalold);
        //    tvHarbencalnew = (TextView) itemView.findViewById(R.id.tvHarbencalnew);
        //    tvMiffilinCal = (TextView) itemView.findViewById(R.id.tvMiffilinCal);
        //    tvAvgCal = (TextView) itemView.findViewById(R.id.tvAvgCal);
        //    tvMinCal = (TextView) itemView.findViewById(R.id.tvMinCal);
        //    tvMaxCal = (TextView) itemView.findViewById(R.id.tvMaxCal);
            tvSlim = (TextView) itemView.findViewById(R.id.tvSlim);
            tvExtraSlim = (TextView) itemView.findViewById(R.id.tvExtraSlim);
            tvFat = (TextView) itemView.findViewById(R.id.tvFat);
            tvExtraFat = (TextView) itemView.findViewById(R.id.tvExtraFat);
         //   ivDelete = (ImageView) itemView.findViewById(R.id.ivDelete);
            fabDelete = (FloatingActionButton) itemView.findViewById(R.id.fabDelete);


        }
    }
}
