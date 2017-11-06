package io.aditilabs.mobilecomputingproject.View.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.aditilabs.mobilecomputingproject.R;


public class ImageViewActivity extends BaseActivity{

    @BindView(R.id.activity_image_view_iv_)
    ImageView ivView ;

    int position ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image_view);

        ButterKnife.bind(this) ;

        if (getIntent().hasExtra("image")){
            position = getIntent().getIntExtra("image", 1) ;
            ivView.setImageDrawable(getResources().getDrawable(drawables[position]));

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
