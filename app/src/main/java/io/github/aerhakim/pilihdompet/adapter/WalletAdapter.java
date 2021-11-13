package io.github.aerhakim.pilihdompet.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import io.github.aerhakim.pilihdompet.R;
import io.github.aerhakim.pilihdompet.Rest.Config;
import io.github.aerhakim.pilihdompet.activity.DetailActivity;
import io.github.aerhakim.pilihdompet.model.Ewallet;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.ViewHolder> {

    List<Ewallet> ewalletList;
   Context context;

    public WalletAdapter(Context context, List<Ewallet> ewalletList) {
        this.context = context;
        this.ewalletList = ewalletList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ewallet_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.appName.setText(ewalletList.get(position).getNama());
        holder.appFee.setText(ewalletList.get(position).getFeetrx());
        holder.appDetail.setText(ewalletList.get(position).getDetail());
        holder.appRating.setRating(ewalletList.get(position).getRating());
        holder.appSize.setText(ewalletList.get(position).getSize());
        Glide.with(holder.itemView.getContext())
                .load(Config.IMAGES_URL + ewalletList.get(position).getGambar())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.appGambar);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailActivity.class);
                mIntent.putExtra("Id", ewalletList.get(position).getId());
                mIntent.putExtra("nama", ewalletList.get(position).getNama());
                mIntent.putExtra("feetrx", ewalletList.get(position).getFeetrx());
                mIntent.putExtra("size", ewalletList.get(position).getSize());
                mIntent.putExtra("rating", ewalletList.get(position).getRating());
                mIntent.putExtra("detail", ewalletList.get(position).getDetail());
                mIntent.putExtra("gambar", ewalletList.get(position).getGambar());

                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ewalletList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView appName,appFee, appSize, appDetail;
        ImageView appGambar;
        AppCompatRatingBar appRating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appSize=itemView.findViewById(R.id.etSize);
            appGambar=itemView.findViewById(R.id.ivGambar);
            appName=itemView.findViewById(R.id.tvJudul);
            appDetail=itemView.findViewById(R.id.etDetail);
            appFee=itemView.findViewById(R.id.etFeetrx);
            appRating=itemView.findViewById(R.id.etRating);
        }
    }
}
