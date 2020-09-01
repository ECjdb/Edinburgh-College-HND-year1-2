package supportassessment;


public class Factorial 
{
  public Factorial()
   {
    System.out.println("Creating Factorial object");   
   }
    
  public long getFactorial(int number)
  {
    long answer = 1; // stores a 64 bit number
    
    for(int k = 1; k<=number; k++)
     {
       answer = answer * k; 
     }
    return answer;  
  }
  
  public String displayFactorial(int number)
  {
    String str="";
    
    for (int f = number; f>=1; f--)
    {
     if(f!=1)
      { 
        str= str + f + "*";
      }
     else
     {
        str= str + f + " = "; 
     }   
    }
    str = str + this.getFactorial(number);
    return str;  
  }
  
  public int CheckNumber (String numberStr)
    {
    
     int number = -1;  // indicates a false value
     boolean isNumber = true;
     
     for(int k=0; k<numberStr.length(); k++)
      {
       char c = numberStr.charAt(k);
       if(Character.isDigit(c))
        {
         System.out.println("digit "+c); 
        }
       else
        {
         System.out.println("letter "+c);
        isNumber = false;
        }
       }
    
     if(isNumber) 
      {
        number = Integer.parseInt(numberStr);
      }
    return number;
    }  // end CheckNumber
  
}
