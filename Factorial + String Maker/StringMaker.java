package supportassessment;


public class StringMaker 
{
  public  StringMaker() 
   {
    System.out.println("Creating String Object");  
   }
  
  public String getUserName(String clientName)
  {
    int space = -1;
    String userName;
    
    for(int k =0; k<clientName.length(); k++) 
    {
     System.out.println(k+" "+clientName.charAt(k)); 
     
     if(clientName.subSequence(k,k+1).equals(" "))
     {
        space = k; 
     }
    }
   
    if(space>0)
     {
       userName = clientName.substring(0,1).
              concat(clientName.substring(space+1));
     }
    else
     {
        userName="Error";
     }

    return userName;
  }
  
  public boolean validName(String nameStr)
  {
   int limit1 = 65;  // ascii code for 'A'
   int limit2 = 90;  // ascii code for 'Z' 
   int limit3 = 45;  // ascii code for '-'
   int limit4 = 32;  // ascii code for ' ' 
   
   String str2 = nameStr.toUpperCase();
   
   boolean valid = true;
   
   for(int k=0; k<str2.length(); k++)
    {
      char letter = str2.charAt(k);
      int number = (int)letter;
      System.out.println(letter+" "+number);
      if(  !((number >=limit1 && number <=limit2) || 
           (number ==limit3 || number ==limit4)))
       {
        valid =false;  
       }   
    }
   return valid;
  }

 public boolean onespace(String nameStr) 
  {
   int limit1 = 32;  // ascii code for space
   
   boolean valid;
   int countSpace = 0;
   
   for(int k=0; k<nameStr.length(); k++)
    {
      char letter = nameStr.charAt(k);
      int number = (int)letter;
      System.out.println(letter+" "+number);
      
      if( number==limit1 )
       {
        countSpace++;
       }
    }
   return valid = (countSpace==1); //true if only one space in nameStr
      
  }

}
