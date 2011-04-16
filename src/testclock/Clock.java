/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testclock;


import java.util.*;
  public class Clock {
  // Declare variables here
      private int hr;
      private int min;
      private int sec;
      String s = "";

  public Clock(int hours, int minutes, int seconds) {
      this.hr = hours;
      this.min = minutes;
      this.sec = seconds;
  }

  public Clock(int hours, int minutes) {
      this.hr = hours;
      this.min = minutes;
      sec = 0;
  }

  public Clock(int hours) {
     this.hr = hours;
     this.min = 0;
     sec = 0;
  }

  public Clock() {
      hr = 0;
      min = 0;
      sec = 0;
  }

  public void advanceSeconds() {
    // Increases time by one second
   sec++;
   if (sec > 59){
       sec = 0;
      advanceMinute();
   }
  }
  private void advanceMinute(){
      //Increases time by one minute
   min++;
   if (min > 59){
       min = 0;
       advanceHours();
   }
  }
  private void advanceHours(){
      //Increments hours
      hr++;
      if (hr > 23){
          hr = 0;
      }
  }
  public static int currentsec(){
      Calendar now = Calendar.getInstance();
      return now.get(Calendar.SECOND);
  }
  public static int currentmin(){
      Calendar now = Calendar.getInstance();
      return now.get(Calendar.MINUTE);
  }
  public static int currenthr(){
      Calendar now = Calendar.getInstance();
      return now.get(Calendar.HOUR);
  }

  public void calibrate() {
    // Sets clock to current time
  Calendar cal=new GregorianCalendar();
      hr = currenthr();
      min = currentmin();
      sec = currentsec();
      if(cal.get(Calendar.AM_PM) == 0)
          s = "a.m";
      else
          s = "p.m";
  }

  public void reset() {
    // Resets time to 00:00:00
    hr = 0;
    min = 0;
    sec = 0;
    s="";
    
  }

  public void set(int hours, int minutes, int seconds) {
    // Sets time according to values of parameters
   this.hr = hours;
   this.min = minutes;
   this.sec = seconds;
  }
  public int gethours(){
      return hr;
  }
  public int getminutes(){
      return min;
  }
  public int getseconds(){
      return sec;
  }
  public void sethours(int hours){
      hours = hr;
  }
  public void setminutes(int minutes){
      minutes = min;
  }
  public void setseconds(int seconds){
      seconds = sec;
  }

  public void toggleClockMode() {
    // Switches from 24-hour clock to 12-hour clock or vice-versa
    if( !s.equals("")){
        if( s.equals("p.m"))
            hr=hr+12;
            s="";
     }
    else{
         if(hr > 12){
             hr=hr-12;
             s = "p.m";
 }
     else
        s="a.m";
 }

 }

    @Override
  public String toString() {
    // Returns time as a string
      String hrs,mins,secs;
    if((hr >= 0) && (hr <= 9)){
         hrs = "0" + hr;
      }
    else
        hrs = "" + hr;
    if((min >= 0) && (min <= 9)){
         mins = "0" + min;
      }
    else
        mins ="" + min;

    if(sec >=0 && sec <= 9){
        secs= "0" + sec;
      }
    else
        secs = "" + sec;
// If the 24-hour clock is in effect, the string has the form
// "hh:mm:ss"
    if( !s.equals("")){
        return(hrs + ":"+mins + ":" + secs + "" + s );
}
// If the 12-hour clock is in effect, the string has the form
// "hh:mm:ss a.m." or "hh:mm:ss p.m."
    else
        return(hrs + ":" + mins + ":" + secs);
       
  }
}


