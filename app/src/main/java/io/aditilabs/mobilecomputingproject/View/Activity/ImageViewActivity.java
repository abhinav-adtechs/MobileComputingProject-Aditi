package io.aditilabs.mobilecomputingproject.View.Activity;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.aditilabs.mobilecomputingproject.Model.PhotoDownloadingListener;
import io.aditilabs.mobilecomputingproject.R;
import it.sephiroth.android.library.tooltip.Tooltip;


public class ImageViewActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.activity_image_view_iv_)
    ImageView ivView ;

    @BindView(R.id.activity_image_view_share)
    ImageButton ibShare;

    @BindView(R.id.activity_image_view_info)
    ImageButton ibInfo;

    @BindView(R.id.activity_image_view_download)
    ImageButton ibDownload ;


    private static final int EXTERNAL_STORAGE_PERMISSION_CONSTANT = 10101;
    int position ;

    private NotificationManager notificationManager ;
    private NotificationCompat.Builder notificationBuilder ;

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
        ibDownload.setOnClickListener(this);



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
                if (position < 9)
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, I wish to share this image with you. Download this file from here: http://abhinavdas.tech/filehosting-wallpapers/low-resolution/00" + position+1 + ".jpg");
                else
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, I wish to share this image with you. Download this file from here: http://abhinavdas.tech/filehosting-wallpapers/low-resolution/0" + position+1 +  ".jpg");
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


            case R.id.activity_image_view_download :

                Log.i("TAG", "onClick: ");
                if (position < 9){
                    Log.d("TAG", "onClick: ");
                    if (ActivityCompat.checkSelfPermission(
                            this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_CONSTANT);
                    }else if (new File(Environment.getExternalStorageDirectory().toString() + "/Galleria/00" + (position+1) + ".jpg").exists()){
                        Toast.makeText(this, "File has already been downloaded!", Toast.LENGTH_SHORT).show();
                    }else {
                        beginDownload();
                    }
                }else {
                    Log.i("TAG", "onClick: ");
                    if (ActivityCompat.checkSelfPermission(
                            this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_CONSTANT);
                    }else if (new File(Environment.getExternalStorageDirectory().toString() + "/Galleria/0" + (position+1) + ".jpg").exists()){
                        Toast.makeText(this, "File has already been downloaded!", Toast.LENGTH_SHORT).show();
                    }else {
                        beginDownload();
                    }
                }

                break;
        }
    }

    private void beginDownload() {
        FileDownloader.setup(this);
        notificationManager =
                (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("Downloading file " + (position+1))
                .setContentText("Download in progress")
                .setSmallIcon(R.mipmap.ic_launcher_photos);

        Intent intent = new Intent(this, MainActivity.class) ;
        intent.putExtra("file", (position+1)) ;

        notificationBuilder.setContentIntent(PendingIntent.getActivity(this, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)) ;


        String downloadUrl = "http://abhinavdas.tech/filehosting-wallpapers/high-resolution/0" ;
        if (position < 9)
            downloadUrl += "0" + (position+1) + ".jpg" ;
        else
            downloadUrl += (position+1) + ".jpg" ;

        Log.i("TAG", "beginDownload: " + downloadUrl);

        FileDownloader.getImpl().create(downloadUrl)
                .setPath(Environment.getExternalStorageDirectory().toString() + "/Galleria/0" + (position+1) + ".jpg")
                .setListener(new PhotoDownloadingListener(position+1, notificationManager, notificationBuilder))
                .start();
    }
}
