package golfplayersapp;
import java.util.Objects;

//EC1524329
//Joel Degner-Budd
//15/11/2018

public class GolfPlayer 
{
    private String name;
    private String surName;
    private String country;
    private double totalPts;
    private int events;
    
    public GolfPlayer()
    {
        System.out.println("Creating golf player data");
    }
    public GolfPlayer(String name,String surName,int events,double totalPts,String country)
    {
        this.name = name;
        this.surName = surName;
        this.events = events;
        this.totalPts = totalPts;
        this.country = country;   
    }

    public String getSurName() 
    {
        return surName;
    }

    public void setSurName(String surName) 
    {
        this.surName = surName;
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getCountry() 
    {
        return country;
    }

    public void setCountry(String country) 
    {
        this.country = country;
    }
    public double getTotalPts() 
    {
        return totalPts;
    }

    public void setTotalPts(double totalPts) 
    {
        this.totalPts = totalPts;
    }
    
    public int getEvents() 
    {
        return events;
    }

    public void setEvents(int events) 
    {
        this.events = events;
    }

    @Override
    public int hashCode() 
    {
        int hash = 3;
        hash = 30 * hash + Objects.hashCode(this.name);
        hash = 40 * hash + Objects.hashCode(this.surName);
        hash = 29 * hash + Objects.hashCode(this.country);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.totalPts) 
                ^ (Double.doubleToLongBits(this.totalPts) >>> 32));
        hash = 43 * hash + this.events;
        return hash;
    }

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
        final GolfPlayer other = (GolfPlayer) obj;
        if (Double.doubleToLongBits(this.totalPts) 
                != Double.doubleToLongBits(other.totalPts)) 
        {
            return false;
        }
        if (this.events != other.events) 
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) 
        {
            return false;
        }
        if (!Objects.equals(this.surName, other.surName)) 
        {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "GolfPlayer{" + "name=" + name 
                + ", surName=" + surName 
                + ", country=" + country 
                + ", totalPts=" + totalPts 
                + ", events=" + events + '}'+" \n";
    }
    
    //============================================================
    //=================== Creates unique key =====================
    //============================================================
    public String setKey() {
        return this.getName().substring(0,2).
                concat(this.getSurName()).toUpperCase();
    }
    
    
}
