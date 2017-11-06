package io.aditilabs.mobilecomputingproject.Model;

import android.app.NotificationManager;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;

/**
 * Created by Abhinav on 06/11/17.
 */

public class PhotoDownloadingListener extends FileDownloadListener {


    private int id ;
    private NotificationManager notificationManager ;
    private android.support.v7.app.NotificationCompat.Builder notificationBuilder ;

    public PhotoDownloadingListener(int id, NotificationManager notificationManager, NotificationCompat.Builder notificationBuilder) {
        this.id = id;
        this.notificationManager = notificationManager;
        this.notificationBuilder = notificationBuilder;
    }

    public PhotoDownloadingListener(int priority, int id, NotificationManager notificationManager, NotificationCompat.Builder notificationBuilder) {
        super(priority);
        this.id = id;
        this.notificationManager = notificationManager;
        this.notificationBuilder = notificationBuilder;
    }

    @Override
    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
        notificationBuilder.setProgress(totalBytes, soFarBytes, false) ;
        notificationManager.notify(id, notificationBuilder.build());
    }

    @Override
    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
        notificationBuilder.setProgress(totalBytes, soFarBytes, false) ;
        notificationManager.notify(id, notificationBuilder.build());
    }

    @Override
    protected void completed(BaseDownloadTask task) {
        notificationBuilder.setProgress(100, 100, false) ;
        notificationBuilder.setContentText("Downloaded") ;
        notificationManager.notify(id, notificationBuilder.build());
    }

    @Override
    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

    }

    @Override
    protected void error(BaseDownloadTask task, Throwable e) {
        notificationBuilder.setProgress(100, 0, false) ;
        notificationBuilder.setContentText("Error downloading") ;
        notificationManager.notify(id, notificationBuilder.build());
    }

    @Override
    protected void warn(BaseDownloadTask task) {
        Log.i("TAG", "warn: ");
    }
}
