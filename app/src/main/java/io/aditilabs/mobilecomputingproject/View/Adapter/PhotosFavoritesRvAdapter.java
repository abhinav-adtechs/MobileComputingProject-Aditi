package io.aditilabs.mobilecomputingproject.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;

import io.aditilabs.mobilecomputingproject.Model.PhotoPojo;
import io.aditilabs.mobilecomputingproject.R;


public class PhotosFavoritesRvAdapter extends RecyclerView.Adapter<PhotosFavoritesRvAdapter.FavoritesViewHolder> {

    private List<PhotoPojo> photoPojos ;
    private Context context ;
    private ItemOnClickListener itemOnClickListener ;

    public PhotosFavoritesRvAdapter(List<PhotoPojo> photoPojos, Context context, ItemOnClickListener itemOnClickListener) {
        this.photoPojos = photoPojos;
        this.context = context;
        this.itemOnClickListener = itemOnClickListener;
    }

    public interface ItemOnClickListener{
        void onClick(int position, View itemView) ;
    }

    @Override
    public FavoritesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_photo, parent, false) ;
        return new FavoritesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FavoritesViewHolder holder, final int position) {

        if (photoPojos.get(position).isFavorite()) {
            holder.bindListener(position);
            holder.ibLike.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_heart_closed));
            holder.ibLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("TAG", "onClick: Added to fav " + position);
                    /*holder.ibLike.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_heart_closed));*/
                }
            });

            holder.ivImage.setImageDrawable(context.getResources().getDrawable(drawables[position]));
        }else {

        }
    }

    @Override
    public int getItemCount() {
        return photoPojos.size();
    }

    public class FavoritesViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivImage ;
        private ImageButton ibLike ;

        FavoritesViewHolder(View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.item_rv_photo_iv_image) ;
            ibLike = itemView.findViewById(R.id.item_rv_photo_ib_like) ;

        }

        public void bindListener(final int position){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemOnClickListener.onClick(position, itemView);
                }
            });
        }
    }


    private int[] drawables = new int[]{
            R.drawable.low_001,
            R.drawable.low_002,
            R.drawable.low_003,
            R.drawable.low_004,
            R.drawable.low_005,
            R.drawable.low_006,
            R.drawable.low_007,
            R.drawable.low_008,
            R.drawable.low_009,
            R.drawable.low_010,
            R.drawable.low_011,
            R.drawable.low_012,
            R.drawable.low_013,
    };


}
