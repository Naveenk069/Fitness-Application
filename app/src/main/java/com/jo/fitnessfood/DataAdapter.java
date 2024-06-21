package com.jo.fitnessfood;

public class DataAdapter {
    public String ImageURL;
    public String ImageTitle;
public String Imagename;
    public String ImageType;
    public String ImageSize;
    public String ImagePack;
    public String ImagePrice;
    public String IID;

    public String getIMGID() {
        return IID;
    }
    public void setIMGID(String imgid) {
        this.IID = imgid;
    }

    public String getImageUrl() {
        return ImageURL;
    }
    public void setImageUrl(String imageServerUrl) {
        this.ImageURL = imageServerUrl;
    }

    public String getImageTitle() {
        return ImageTitle;
    }
    public void setImageTitle(String Imagetitlename) {
        this.ImageTitle = Imagetitlename;
    }

    public String getImageType() {
        return ImageType;
    }
    public void setImageType(String imagetype) {
        this.ImageType = imagetype;
    }

    public String getImageSize() {
        return ImageSize;
    }
    public void setImageSize(String imagesize) {
        this.ImageSize = imagesize;
    }

    public String getImagePack() {
        return ImagePack;
    }
    public void setImagePack(String imagepack) {
        this.ImagePack = imagepack;
    }

    public String getImagePrice() {
        return ImagePrice;
    }
    public void setImagePrice(String imageprice) {
        this.ImagePrice = imageprice;
    }

    public String getImagename() {
        return Imagename;
    }
    public void setImagename(String Imagename) {
        this.Imagename = Imagename;
    }

}
