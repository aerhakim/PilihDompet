package io.github.aerhakim.pilihdompet.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import io.github.aerhakim.pilihdompet.R;
import io.github.aerhakim.pilihdompet.rest.Config;
import io.github.aerhakim.pilihdompet.activity.DetailEwalletActivity;
import io.github.aerhakim.pilihdompet.model.Promo;


public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> {

    List<Promo> promoList;
    Context context;

    public PromoAdapter(Context context, List<Promo> promoList) {
        this.context = context;
        this.promoList = promoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.promo_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.promoDeskripsi.setText(promoList.get(position).getDeskripsi());
        holder.promoJudul.setText(promoList.get(position).getJudul());
        holder.promoUser.setText(promoList.get(position).getUser());
        holder.promoSNK.setText(promoList.get(position).getSnk());
        holder.promoEwallet.setText(promoList.get(position).getEwallet());
        holder.promoTglend.setText(promoList.get(position).getTglendpromo());
        Glide.with(holder.itemView.getContext())
                .load(Config.IMAGES_URL + promoList.get(position).getGambar())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.promoGambar);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailEwalletActivity.class);
                mIntent.putExtra("judul", promoList.get(position).getJudul());
                mIntent.putExtra("snk", promoList.get(position).getSnk());
                mIntent.putExtra("user", promoList.get(position).getUser());
                mIntent.putExtra("ewallet", promoList.get(position).getEwallet());
                mIntent.putExtra("tglend", promoList.get(position).getTglendpromo());
                mIntent.putExtra("deskripsi", promoList.get(position).getDeskripsi());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return promoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView promoJudul,promoDeskripsi, promoUser, promoSNK, promoEwallet, promoTglend;
        ImageView promoGambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            promoGambar=itemView.findViewById(R.id.ivGambar);
            promoJudul=itemView.findViewById(R.id.tvJudul);
            promoSNK=itemView.findViewById(R.id.promoSNK);
            promoUser=itemView.findViewById(R.id.promoUser);
            promoEwallet=itemView.findViewById(R.id.promoEwallet);
            promoTglend=itemView.findViewById(R.id.promoTglend);
            promoDeskripsi=itemView.findViewById(R.id.tvDeskripsi);

        }
    }
}
