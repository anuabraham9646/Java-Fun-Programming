package com;
import java.util.Scanner;
public class TheatreSquareCodeForce {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double n= sc.nextLong();
        double m= sc.nextLong();
        double a = sc.nextLong();
        if(n * m<= 0){
            System.out.println("0");
        }
        else{
            System.out.println((long)Math.ceil(n/a)*(long)Math.ceil(m/a));
        }
    }
}
