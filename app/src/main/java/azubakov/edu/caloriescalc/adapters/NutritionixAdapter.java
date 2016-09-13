package azubakov.edu.caloriescalc.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import azubakov.edu.caloriescalc.R;
import azubakov.edu.caloriescalc.models.Nutritionix;
//import tomerbu.edu.recyclerweb.models.Reddit;

/**
 * Created by stud27 on 17/07/16.
 */
public class NutritionixAdapter extends RecyclerView.Adapter<NutritionixAdapter.NutritionixViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    //private ArrayList<Reddit> data;
    private ArrayList<Nutritionix> data;

    public NutritionixAdapter(Context context, ArrayList<Nutritionix> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public NutritionixViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.nutritionix_item, parent, false);
        return new NutritionixViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NutritionixViewHolder holder, int position) {
        //final Nutritionix reddit = data.get(position);
        final Nutritionix nutritionix = data.get(position);
  /*      holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(reddit.getUrl());
                Intent detailsIntent = new Intent(Intent.ACTION_VIEW, uri);
                v.getContext().startActivity(detailsIntent);
            }
        });*/

        holder.tvTitle.setText(nutritionix.getProductname());
        holder.tvCal.setText(nutritionix.getCalories() + "" + "Kcal.");
        holder.tvFats.setText(nutritionix.getFats() + "" + "% ");
        /*    Context context = holder.ivReddit.getContext();

        String url = reddit.getThumbnail();
        if (url.length() > 6)
            Picasso.
                    with(context).
                    load(url).
                    placeholder(R.drawable.reddit_icon).
                    error(R.mipmap.ic_launcher).
                    into(holder.ivReddit);*/
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class NutritionixViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        RelativeLayout layout;
        ImageView ivReddit;
        TextView tvTitle;
        TextView tvCal;
        TextView tvFats;

        public NutritionixViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            layout = (RelativeLayout) itemView.findViewById(R.id.layout);
            ivReddit = (ImageView) itemView.findViewById(R.id.ivReddit);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvCal = (TextView) itemView.findViewById(R.id.tvCal);
            tvFats = (TextView) itemView.findViewById(R.id.tvFats);
        }
    }
}
