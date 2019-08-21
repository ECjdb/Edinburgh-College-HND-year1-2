package assessmentl01;
import java.util.Objects;

//Joel Degner-Budd
//EC1524329
//10/10/2018
//Data Structures Assessment: Prep

public class container 
{
    private String contID;
    private String produce;
    private int qty;
    private String date;
    
    public container()
    {
         
    }
    
    public container(String produce, String contID, int qty, String date) 
    {
        this.contID = contID;
        this.produce = produce;
        this.qty = qty;
        this.date = date;
    }
    
    /*
        Getters and Setters
    */



    public String getContID() {
        return contID;
    }

    public void setContID(String contID) {
        this.contID = contID;
    }
    
    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /*
        To String Method
    */

    @Override
    public String toString() 
    {
        return "\n"+"{" + "container ID=" + contID 
                + ", produce=" + produce 
                + ", quantity=" + qty 
                + ", use by date=" + date + '}';   
    }


    /*
        HashCode
     */

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.produce);
        hash = 31 * hash + Objects.hashCode(this.contID);
        hash = 31 * hash + this.qty;
        hash = 31 * hash + Objects.hashCode(this.date);
        return hash;
    }
    
    /*
    Equals method
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final container other = (container) obj;
        if (this.qty != other.qty) {
            return false;
        }
        if (!Objects.equals(this.produce, other.produce)) {
            return false;
        }
        if (!Objects.equals(this.contID, other.contID)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
   
}
