package uk.ac.edinburghcollege.coffeeshop.adapter;

public class Product
{
    private String pTitle;
    private double pPrice;
    private int pID;
    private int cID;
    private int pThumbnail;

    public Product(String pTitle, double pPrice, int pID, int cID, int pThumbnail) {
        this.pTitle = pTitle;
        this.pPrice = pPrice;
        this.pID = pID;
        this.cID = cID;
        this.pThumbnail = pThumbnail;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int getpThumbnail() {
        return pThumbnail;
    }

    public void setpThumbnail(int pThumbnail) {
        this.pThumbnail = pThumbnail;
    }
}
