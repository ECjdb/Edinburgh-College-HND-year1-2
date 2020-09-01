package uk.ac.edinburghcollege.coffeeshop.adapter;

public class Category
{
    private String cTitle;
    private int cID;
    private int cThumbnail;

    public Category(String cTitle, int cID, int cThumbnail) {
        this.cTitle = cTitle;
        this.cID = cID;
        this.cThumbnail = cThumbnail;
    }

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int getcThumbnail() {
        return cThumbnail;
    }

    public void setcThumbnail(int cThumbnail) {
        this.cThumbnail = cThumbnail;
    }
}
