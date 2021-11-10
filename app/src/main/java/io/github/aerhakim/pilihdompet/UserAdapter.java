package io.github.aerhakim.pilihdompet;

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

import io.github.aerhakim.pilihdompet.activity.DetailActivity;
import io.github.aerhakim.pilihdompet.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> userList;
   Context context;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList=userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ewallet_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.appName.setText(userList.get(position).getNama());
        holder.appFee.setText(userList.get(position).getFeetrx());
        holder.appDetail.setText(userList.get(position).getDetail());
        holder.appRating.setText(userList.get(position).getRating());
        holder.appSize.setText(userList.get(position).getSize());
        Glide.with(holder.itemView.getContext())
                .load(RetrofitClient.IMAGES_URL + userList.get(position).getGambar())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.appGambar);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailActivity.class);
                mIntent.putExtra("Id", userList.get(position).getId());
                mIntent.putExtra("nama", userList.get(position).getNama());
                mIntent.putExtra("feetrx", userList.get(position).getFeetrx());
                mIntent.putExtra("size", userList.get(position).getSize());
                mIntent.putExtra("rating", userList.get(position).getRating());
                mIntent.putExtra("detail", userList.get(position).getDetail());
                mIntent.putExtra("gambar", userList.get(position).getGambar());

                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView appName,appFee, appSize, appRating, appDetail;
        ImageView appGambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appSize=itemView.findViewById(R.id.etSize);
            appGambar=itemView.findViewById(R.id.img_item_photo);
            appName=itemView.findViewById(R.id.etNama);
            appDetail=itemView.findViewById(R.id.etDetail);
            appFee=itemView.findViewById(R.id.etFeetrx);
            appRating=itemView.findViewById(R.id.etRating);
        }
    }
}
