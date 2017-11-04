package io.aditilabs.mobilecomputingproject.View.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.aditilabs.mobilecomputingproject.Model.PhotoPojo;
import io.aditilabs.mobilecomputingproject.R;
import io.aditilabs.mobilecomputingproject.View.Activity.ImageViewActivity;
import io.aditilabs.mobilecomputingproject.View.Activity.MainActivity;
import io.aditilabs.mobilecomputingproject.View.Adapter.PhotosRvAdapter;


public class HomeFragment extends BaseFragment {

    @BindView(R.id.fragment_home_rv_photos)
    RecyclerView rvHomePhotos ;

    List<PhotoPojo> photoPojoList = new ArrayList<>();

    PhotosRvAdapter photosRvAdapter ;

    MainActivity mainActivity ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false) ;

        ButterKnife.bind(this, view) ;
        mainActivity = (MainActivity) this.getActivity()  ;

        rvInit() ;
        return view ;
    }

    private void rvInit() {

        photosRvAdapter = new PhotosRvAdapter(photoPojoList, mainActivity, new PhotosRvAdapter.ItemOnClickListener() {
            @Override
            public void onClick(int position, View itemView) {
                Intent intent = new Intent(mainActivity, ImageViewActivity.class) ;
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(mainActivity, (View)itemView.findViewById(R.id.item_rv_photo_iv_image) , "photoView");
                startActivity(intent, options.toBundle());

            }
        });

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getActivity().getApplicationContext(),
             2) ;
        rvHomePhotos.setLayoutManager(layoutManager);
        rvHomePhotos.setAdapter(photosRvAdapter);

        photoPojoList.add(new PhotoPojo(1, "bullshit")) ;
        photoPojoList.add(new PhotoPojo(2, "bullshit")) ;
        photoPojoList.add(new PhotoPojo(3, "bullshit")) ;
        photoPojoList.add(new PhotoPojo(4, "bullshit", true)) ;
        photoPojoList.add(new PhotoPojo(5, "bullshit")) ;
        photoPojoList.add(new PhotoPojo(6, "bullshit", true)) ;
        photoPojoList.add(new PhotoPojo(3, "bullshit")) ;
        photoPojoList.add(new PhotoPojo(4, "bullshit", true)) ;
        photoPojoList.add(new PhotoPojo(5, "bullshit")) ;
        photoPojoList.add(new PhotoPojo(6, "bullshit", false)) ;
        photoPojoList.add(new PhotoPojo(3, "bullshit")) ;
        photoPojoList.add(new PhotoPojo(4, "bullshit", true)) ;
        photoPojoList.add(new PhotoPojo(5, "bullshit")) ;
        photoPojoList.add(new PhotoPojo(6, "bullshit", true)) ;
        photoPojoList.add(new PhotoPojo(3, "bullshit")) ;
        photoPojoList.add(new PhotoPojo(4, "bullshit", true)) ;
        photoPojoList.add(new PhotoPojo(5, "bullshit")) ;
        photoPojoList.add(new PhotoPojo(6, "bullshit", true)) ;
    }
}
