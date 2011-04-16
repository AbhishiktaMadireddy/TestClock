/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testclock;

/**
 *
 * @author Abhi
 */
import java.io.*;
public class TestClock {

    public static BufferedReader dis;
    public static Clock c;
    public static void main(String args[])throws Exception {
        // TODO code application logic here
        dis = new BufferedReader(new InputStreamReader(System.in));
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
            switch(ch) {
                case 'a':
                case 'A':
                    c.advanceSeconds();
                    break;
                case 'c':
                case 'C':
                    c.calibrate();
                 break;
                case 'q':
                case 'Q':
                    System.exit(0);
                    break;
                case 'r':
                case 'R':
                    c.reset();
                    break;
                case 's':
                case 'S':setTime();
                    break;
                case 't':
                case 'T':
                    c.toggleClockMode();
                    break;
                
                default:System.out.println("invalid choice");
            }
            System.out.println("\nThe time is now "+c.toString());
        } 
        while(true);
        
}
        private static void setTime(){
            int h,m,s;
            try {
                System.out.print("Enter hours: ");
                h=Integer.parseInt(dis.readLine());
                while(h<0 || h>23){
                    System.out.println("Input must be between 0 and 23; please try again.");
                    System.out.print("Enter hours: ");
                    h=Integer.parseInt(dis.readLine());
                }
                System.out.print("Enter minutes: ");
                m=Integer.parseInt(dis.readLine());
                while(m<0 || m>59) {
                    System.out.println("Input must be between 0 and 59; please try again.");
                    System.out.print("Enter hours: ");
                    m=Integer.parseInt(dis.readLine());
                }
                System.out.print("Enter seconds: ");
                s=Integer.parseInt(dis.readLine());
                while(s<0 || s>59) {
                System.out.println("Input must be between 0 and 59; please try again.");
                System.out.print("Enter hours: ");
                s=Integer.parseInt(dis.readLine());
                }
                c.set(h,m,s);
                c.s="";
                }
                catch(Exception e) {
                System.out.print("Input was not an integer, try again");
                return;
        
                }
                       
                
                    
            }
        }



