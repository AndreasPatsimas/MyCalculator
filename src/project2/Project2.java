/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Project2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double num1=0;
        double num2=0;
        Scanner sc=new Scanner(System.in);
        boolean z=true;
        double [] result=new double [2];
        for(int i=0;i<result.length;i++){
            boolean b=true;
            while(b==true){
                System.out.println("Type a number, and then press Enter...");
                try{
                    num1=sc.nextInt();
                    b=false;
                }
                catch(Exception e){
                    System.out.println("This number doesn't exist.");
                    b=true;
                    sc.next();
                }
            }
            b=true;
            while(b==true){
                try{
                    System.out.println("Type another number, and then press Enter...");
                    num2=sc.nextInt();
                    b=false;
                }
                catch(Exception e){
                    System.out.println("This number doesn't exist.");
                    b=true;
                    sc.next();
                }
            }
            if(num1>=0){
                System.out.println("Do you want square root for the first number ?");
                System.out.println("Press yes or no...");
                while(z==true){
                    String s=sc.nextLine();
                    if("yes".equals(s)){
                        num1=Math.sqrt(num1);
                        System.out.println("Square root for the first number is "+num1);
                        z=false;
                    }
                    else if("no".equals(s)){
                        z=false;
                    }
                }
            }
            z=true;
            if(num2>=0){
                System.out.println("Do you want square root for the second number ?");
                System.out.println("Press yes or no...");
                while(z==true){
                    String s=sc.nextLine();
                    if("yes".equals(s)){
                        num2=Math.sqrt(num2);
                        System.out.println("Square root for the second number is "+num2);
                        z=false;
                    }
                    else if("no".equals(s)){
                        z=false;
                    }
                }
            }
            System.out.println("Choose an option from the following list:");
            System.out.println("\t+ - Add");
            System.out.println("\t- - Subtract");
            System.out.println("\t* - Multiply");
            System.out.println("\t/ - Divide");
            System.out.println("\t% - Remainder of the division");
            System.out.print("Your option? ");
            z=true;
            while(z==true){
            switch (sc.next())
                {
                    case "+":
                        System.out.println("Your result: "+ num1 +"+"+ num2+ "= " + (num1 + num2));
                        result[i]=num1 + num2;
                        z=false;
                        break;
                    case "-":
                        System.out.println("Your result: "+ num1+ "-" +num2+"=" + (num1 - num2));
                        result[i]=num1 - num2;
                        z=false;
                        break;
                    case "*":
                        System.out.println("Your result: "+num1+"*"+num2+"=" + (num1 * num2)); 
                        result[i]=num1 * num2;
                        z=false;
                        break;
                    case "/":
                        while (num2 == 0)
                        {
                            System.out.println("Enter a non-zero divisor: ");
                            num2 = sc.nextInt();
                        }
                        System.out.println("Your result:"+num1+"/"+num2+"=" + (num1 / num2)); 
                        result[i]=num1 / num2;
                        z=false;
                        break;
                    case"%":
                        while (num2 == 0)
                        {
                            System.out.println("Enter a non-zero divisor: ");
                            num2 = sc.nextInt();
                        }
                        System.out.println("Your result:"+num1+"%"+num2+"=" + (num1 % num2));
                        result[i]=num1 % num2;
                        z=false;
                        break;
                    default:
                        System.out.println("That is an incorrect option entry, please try again.");
                        break;
                }
            }
            z=true;
        }
        if((result[1]>0)&&(result[1]==(int)(result[1]))){
            int n=(int)(result[1]);
            boolean prime=isPrime(n);
            if(prime==true){
                System.out.println("The second result is a prime number");
            }
            else{System.out.println("The second result is not a prime number");}
        }
        else{System.out.println("The second result is not a prime number");}
        int m=(int)(result[0]);
        int n=(int)(result[1]);
        if((m!=0)&&(n!=0)){
            System.out.println("The  Greatest  Common  Divisor from number "+m+" and "
                    + "from number "+n+" is "+gcdThing(m,n));
        }
        else{System.out.println("There is no Greatest  Common  Divisor for numbers 0 and 0. ");}
        if(n>=0){
            System.out.println("The term "+n+" of the Fibonacci sequence is "+Fibonacci(n));
        }
        else{System.out.println("The number "+n+" cannot be a term of the Fibonacci sequence.");}
        checkFibonacci(n);
    }
    
    
    
    
    
    
    
    
    public static void checkFibonacci(int a){
        ArrayList<Integer> fiblist=new ArrayList<>();
        int n1=0,n2=1,n3,count=a;
        fiblist.add(n1);
        fiblist.add(n2);
        for(int i=2;i<count;i++){    
            n3=n1+n2;
            fiblist.add(n3);
            n1=n2;    
            n2=n3;    
        }
        boolean c=fiblist.contains(a);
        if(c==true){
            System.out.println("The number "+a+" is a Fibonacci number.");
        }
        else{System.out.println("The number "+a+" is not a Fibonacci number.");}
    }
    
    public static int Fibonacci(int a){
        int n1=0,n2=1,n3=0,count=a;      
        for(int i=2;i<count;i++){    
            n3=n1+n2;        
            n1=n2;    
            n2=n3;    
        }
        return n3;
    }
    
    
    public static boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    private static int gcdThing(int a, int b) {
    BigInteger b1 = new BigInteger(""+a); 
    BigInteger b2 = new BigInteger(""+b);
    BigInteger gcd = b1.gcd(b2);
    return gcd.intValue();
}
}
