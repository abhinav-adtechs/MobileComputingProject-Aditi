package io.aditilabs.mobilecomputingproject.Model;


public class PhotoPojo {

    private int photoId ;
    private String urlHighRes;
    private boolean isFavorite ;

    public PhotoPojo(int photoId, String urlHighRes) {
        this.photoId = photoId;
        this.urlHighRes = urlHighRes;
    }

    public PhotoPojo(int photoId, String urlHighRes, boolean isFavorite) {
        this.photoId = photoId;
        this.urlHighRes = urlHighRes;
        this.isFavorite = isFavorite;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getUrlHighRes() {
        return urlHighRes;
    }

    public void setUrlHighRes(String urlHighRes) {
        this.urlHighRes = urlHighRes;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
