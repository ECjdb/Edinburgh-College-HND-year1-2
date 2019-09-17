package sortingassessmentpart2;
import java.util.Comparator;
import java.util.Objects;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class AmericanCities implements Comparator<AmericanCities>
{
    //Private variables
    
    private String city;
    private double popGrowth;
    private double latitude;
    private double longitude;
    private int population;
    private int rank;
    private String state;
    
    //Blank Constructor
    public AmericanCities()
    {
    
    }
    //American Cities Object Constructor
    public AmericanCities(String city, double popGrowth, double latitude, 
                 double longitude, int population, int rank, String state) 
    {
        this.city = city;
        this.popGrowth = popGrowth;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.rank = rank;
        this.state = state;
    }
    
    //*****************************************************************
    //*                       Getters and Setters                     *
    //***************************************************************** 
    
    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public double getPopGrowth() 
    {
        return popGrowth;
    }

    public void setPopGrowth(double popGrowth) 
    {
        this.popGrowth = popGrowth;
    }

    public double getLatitude() 
    {
        return latitude;
    }

    public void setLatitude(double latitude) 
    {
        this.latitude = latitude;
    }

    public double getLongitude() 
    {
        return longitude;
    }

    public void setLongitude(double longitude) 
    {
        this.longitude = longitude;
    }

    public int getPopulation() 
    {
        return population;
    }

    public void setPopulation(int population) 
    {
        this.population = population;
    }

    public int getRank() 
    {
        return rank;
    }

    public void setRank(int rank) 
    {
        this.rank = rank;
    }

    public String getState() 
    {
        return state;
    }

    public void setState(String state) 
    {
        this.state = state;
    }
    //end Getters and Setters *
    
    @Override
    public int hashCode() 
    {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.city);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.popGrowth) ^ 
                              (Double.doubleToLongBits(this.popGrowth) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ 
                               (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ 
                              (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 97 * hash + this.population;
        hash = 97 * hash + this.rank;
        hash = 97 * hash + Objects.hashCode(this.state);
        return hash;
    }//end hashCode *

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        if (obj == null) 
        {
            return false;
        }
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        final AmericanCities other = (AmericanCities) obj;
        if (Double.doubleToLongBits(this.popGrowth) 
                                    != Double.doubleToLongBits(other.popGrowth)) 
        {
            return false;
        }
        if (Double.doubleToLongBits(this.latitude) 
                                    != Double.doubleToLongBits(other.latitude)) 
        {
            return false;
        }
        if (Double.doubleToLongBits(this.longitude) 
                                    != Double.doubleToLongBits(other.longitude)) 
        {
            return false;
        }
        if (this.population != other.population) 
        {
            return false;
        }
        if (this.rank != other.rank) 
        {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) 
        {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) 
        {
            return false;
        }
        return true;
    }//end equals *

    @Override
    public String toString() 
    {
        String tmp1;
        String tmp2;
        String tmp3;
        String tmp4;
        String tmp5;
        String tmp6;
        String tmp7;
        
        tmp1 = String.format("%-26s", this.getCity());
        tmp2 = String.format("%-10s", this.getPopGrowth());
        tmp3 = String.format("%-10s", this.getLatitude());
        tmp4 = String.format("%-10s", this.getLongitude());
        tmp5 = String.format("%-10s", this.getPopulation());
        tmp6 = String.format("%-10s", this.getRank());
        tmp7 = String.format("%-6s", this.getState());
        
        return "AmericanCities{" + "city=" + tmp1
                + ", popGrowth=" + tmp2 
                + ", latitude=" + tmp3 
                + ", longitude=" + tmp4 
                + ", population=" + tmp5 
                + ", rank=" + tmp6 
                + ", state=" + tmp7 + '}';
    }//end toString *
    
    //comparator
    public int compare(AmericanCities usa1, AmericanCities usa2) 
    {
        return (usa2.getCity().compareTo(usa2.getCity()));
    }//end method compare *
}//end American Cities **
