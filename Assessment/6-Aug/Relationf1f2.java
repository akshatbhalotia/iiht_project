/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Relationf1f2
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int i=0,j=0;
		int stn=0;
		int st2n=0;
		String s1=null;
		String s2=null;
		String[] str=new String[10];
		String[] str2=new String[10];
System.out.println("Original elements in the array is ..");
		str[0]="f1,f2";
		str[9]="f5,f1";
		str[5]="f3,f1";
    	str[3]="f2,f3";
		str[1]="f2,f1";
		str[6]="f1,f5";
		str[2]="f3,f2";
		str[7]="f4,f2";
		str[4]="f1,f3";
		str[8]="f2,f4";
		stn=str.length;
		for(i=0;i<stn;i++)
		{
		   System.out.print(str[i]+"  ");
		}
		System.out.println("");
		str2=str;
		
		System.out.println("After Relational Arrangment the array is ...");
		for(i=0;i<stn;i++)
		{
		    if(str2[i].equals("o"))
		    {
		        continue;
		        
		    }
		    else
		    {
		        s1=str2[i];
		    String[] words=str2[i].split(",");
		    s2=words[1]+","+words[0];
		     if((i+1)==stn)
		     {
		         break;
		     }
		     else{
		         for(j=i+1;j<stn;j++)
		         {
		             if(str2[j].equals(s1))
		             {
		                 str2[j]="o";
		             }
		             else if(str2[j].equals(s2))
		             {
		                 str2[j]="o";
		             }
		             else
		             {
		                 continue;
		             }
		         }
		     }
		    }
		}
		for(i=0;i<stn;i++)
		{
		    if(str2[i].equals("o"))
		    {
		        continue;
		    }
		    else{
		   System.out.print(str2[i]+"  ");
		}
		}
		
	}
}

