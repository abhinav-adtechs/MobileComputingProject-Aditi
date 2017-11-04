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


public class PhotosRvAdapter extends RecyclerView.Adapter<PhotosRvAdapter.PhotosViewHolder> {

    private List<PhotoPojo> photoPojos ;
    private Context context ;
    private ItemOnClickListener itemOnClickListener ;

    public PhotosRvAdapter(List<PhotoPojo> photoPojos, Context context, ItemOnClickListener itemOnClickListener) {
        this.photoPojos = photoPojos;
        this.context = context;
        this.itemOnClickListener = itemOnClickListener;
    }

    public interface ItemOnClickListener{
        void onClick(int position) ;
    }

    @Override
    public PhotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_photo, parent, false) ;
        return new PhotosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PhotosViewHolder holder, final int position) {

        holder.bindListener(position);
        holder.ibLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "onClick: Added to fav " + position);
                holder.ibLike.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_heart_closed));
            }
        });


    }

    @Override
    public int getItemCount() {
        return photoPojos.size();
    }

    class PhotosViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivImage ;
        private ImageButton ibLike ;

        PhotosViewHolder(View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.item_rv_photo_iv_image) ;
            ibLike = itemView.findViewById(R.id.item_rv_photo_ib_like) ;

        }

        public void bindListener(final int position){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemOnClickListener.onClick(position);
                }
            });
        }
    }
}
