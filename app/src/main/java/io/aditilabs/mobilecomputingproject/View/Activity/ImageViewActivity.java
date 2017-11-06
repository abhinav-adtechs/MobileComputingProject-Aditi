package io.aditilabs.mobilecomputingproject.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.aditilabs.mobilecomputingproject.R;
import it.sephiroth.android.library.tooltip.Tooltip;


public class ImageViewActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.activity_image_view_iv_)
    ImageView ivView ;

    @BindView(R.id.activity_image_view_share)
    ImageButton ibShare;

    @BindView(R.id.activity_image_view_info)
    ImageButton ibInfo;



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

        ibShare.setOnClickListener(this);
        ibInfo.setOnClickListener(this);



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

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.activity_image_view_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                if (position < 10)
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, I wish to share this image with you. Download this file from here: http://abhinavdas.tech/filehosting-wallpapers/low-resolution/00" + position + ".jpg");
                else
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, I wish to share this image with you. Download this file from here: http://abhinavdas.tech/filehosting-wallpapers/low-resolution/0" + position + ".jpg");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;

            case R.id.activity_image_view_info :
                Tooltip.make(this,
                        new Tooltip.Builder(101)
                                .anchor(ibInfo, Tooltip.Gravity.BOTTOM)
                                .closePolicy(new Tooltip.ClosePolicy()
                                        .insidePolicy(true, false)
                                        .outsidePolicy(true, false), 4000)
                                .activateDelay(100)
                                .showDelay(300)
                                .text("Peer reviewed!")
                                .maxWidth(800)
                                .withArrow(true)
                                .withOverlay(true)
                                .build()
                ).show();
                break ;
        }
    }
}
