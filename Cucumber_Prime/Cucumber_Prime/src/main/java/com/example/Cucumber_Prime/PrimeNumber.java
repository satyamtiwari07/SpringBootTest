package com.example.Cucumber_Prime;

import static java.lang.Math.sqrt;

public class PrimeNumber
{
   public String find_prime(int number)
   {
       if(number ==0 )throw new IllegalArgumentException("Number must not be Null");

       for(int i=2;i<sqrt(number);i++)
       {

           if((number % i)==0)
               return "Not Prime";
           else
               return "Prime";
       }
       return null;
   }
}
