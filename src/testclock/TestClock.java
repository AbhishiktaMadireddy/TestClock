/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//Author:        Abhishikta Madireddy
//Date Written:  04.21.2011.
//Course:        CSc 2310 Principles of Computer Programming.
//Project:       Program TestClock to test the behavior of Clock class
package testclock;

/**
 *
 * @author Abhi
 */
import java.io.*;
public class TestClock {


    public static Clock c;
    public static BufferedReader dis;
    public static void main(String args[])throws Exception {
        // TODO code application logic here
        dis=new BufferedReader(new InputStreamReader(System.in));
        c = new Clock();
        System.out.println("Welcome to the clock testing program:");
        System.out.println("Commands :");
        System.out.println("--------");
        System.out.println("a" +"=" +"advance" +"("+"increase time by one second"+")");
        System.out.println("c"+ "=" + "calibrate" + "(" + "set to current time" + ")");
        System.out.println("q" + "=" + "quit");
        System.out.println("r" + "=" + "reset" + "(" + "set hours" +"," + " minutes" + "," + "and second to zero" + ")");
        System.out.println("s" + "=" + "set" + "(" + "allow user to set time" + ")");
        System.out.println("t" + "=" + "toggle" + "(" + "switch from 24-hour clock to 12-hour clock" + "," + "or vice-versa" + ")");
        System.out.println("\nThe time is now " + c.toString());
        do {
            System.out.print("Enter command(a,c,q,r,s,or t):");
            char ch = (dis.readLine()).charAt(0);
            //swith case to select from the commands
            switch(ch) {
                case 'a':
                    c.advanceSeconds();
                        break;
                case 'c':
                    c.calibrate();
                        break;
                case 'q':
                    System.exit(0);
                        break;
                case 'r':
                    c.reset();
                        break;
                case 's':setTime();
                    break;
                case 't':
                    c.toggleClockMode();
                        break;

                default:System.out.println("invalid choice");
            }
                System.out.println("\nThe time is now "+c.toString());
        }
        while(true);

}
        private static void setTime(){
        int hr,min,sec;
           
             System.out.print("Enter hours: ");
             do{
                 try{
                    hr=Integer.parseInt(dis.readLine());
                    if (c.sethours(hr)) {
                         break;
                    }
                    else
                         System.out.println("Input must be between 0 and 23; please try again.");
                         System.out.print("Enter hours: ");
                         hr=Integer.parseInt(dis.readLine());
                     }
                     catch(Exception e){
                     System.out.println("Input must be integer; please try again.");
                     System.out.print("Enter hours: ");
                     }
                       
               } while(true);

                     System.out.print("Enter minutes: ");
                     do {
                         try{
                             min=Integer.parseInt(dis.readLine());
                             if (c.setminutes(min)) {
                                break;
                         }
                         else
                             System.out.println("Input must be between 0 and 59; please try again.");
                             System.out.print("Enter minutes: ");
                             hr=Integer.parseInt(dis.readLine());
                         }
                         catch(Exception e){
                         System.out.println("Input must be integer; please try again.");
                         System.out.print("Enter minutes: ");
                         }
                     } while (true);

                      System.out.print("Enter seconds: ");
                      do{
                         try{
                         sec=Integer.parseInt(dis.readLine());
                         if (c.setseconds(sec)) {
                             break;
                         }
                         else
                             System.out.println("Input must be between 0 and 59; please try again.");
                             System.out.print("Enter seconds: ");
                             sec=Integer.parseInt(dis.readLine());
                         }
                         catch(Exception e){
                         System.out.println("Input must be integer; please try again.");
                         System.out.print("Enter seconds: ");
                        }
                     } while(true);
                         return;

    }

}
    