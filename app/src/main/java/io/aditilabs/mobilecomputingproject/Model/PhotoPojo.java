package io.aditilabs.mobilecomputingproject.Model;


public class PhotoPojo {

    private int photoId ;
    private String photoUrl ;
    private boolean isFavorite ;

    public PhotoPojo(int photoId, String photoUrl) {
        this.photoId = photoId;
        this.photoUrl = photoUrl;
    }

    public PhotoPojo(int photoId, String photoUrl, boolean isFavorite) {
        this.photoId = photoId;
        this.photoUrl = photoUrl;
        this.isFavorite = isFavorite;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
