/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//Author:        Abhishikta Madireddy
//Date Written:  04.21.2011.
//Course:        CSc 2310 Principles of Computer Programming.
//Project:       Program TestClock to test the behavior of Clock class
package testclock;


import java.util.Calendar;
  public class Clock {
  // The variables are declared here
      private int hr;//Hours of Clock
      private int min;//Minutes of Clock
      private int sec;//Seconds of Clock
      String s = "";
  //Constructors
      //////////////////////////////////////////////////
      //NAME:       Clock
      //BEHAVIOUR:  Constructs a clock with the specified
      //            hr,min and sec.
      //PARAMETERS: hr = hours , min = minutes
      //            sec = seconds
      ///////////////////////////////////////////////////
  public Clock(int hours, int minutes, int seconds) {
      this.hr = hours;
      this.min = minutes;
      this.sec = seconds;
  }
      //////////////////////////////////////////////////
      //NAME:       Clock
      //BEHAVIOUR:  Constructs a clock with the specified
      //            hr and min
      //PARAMETERS: hr = hours , min = minutes
      ///////////////////////////////////////////////////
  public Clock(int hours, int minutes) {
      this.hr = hours;
      this.min = minutes;
      sec = 0;
  }
      //////////////////////////////////////////////////
      //NAME:       Clock
      //BEHAVIOUR:  Constructs a clock with the specified
      //            hours
      //PARAMETERS: hr = hours
      ///////////////////////////////////////////////////
  public Clock(int hours) {
     this.hr = hours;
     this.min = 0;
     sec = 0;
  }
     //Default Constructor
     //////////////////////////////////////////////////
     //NAME:       Clock
     //BEHAVIOUR:  Constructs a clock
     //PARAMETERS: None
     ///////////////////////////////////////////////////
  public Clock() {
      hr = 0;
      min = 0;
      sec = 0;
  }
   //////////////////////////////////////////////////
   //NAME:       advanceSeconds
   //BEHAVIOUR:  Increases time by one second
   //PARAMETERS: None
   //RETURNS:    Nothing
   ///////////////////////////////////////////////////
  public void advanceSeconds() {
    sec++;
   if (sec > 59){
       sec = 0;
      advanceMinute();
   }
  }
  //////////////////////////////////////////////////
  //NAME:       advanceMinutes
  //BEHAVIOUR:  Increases time by one minute
  //PARAMETERS: None
  //RETURNS:    Nothing
  ///////////////////////////////////////////////////
  private void advanceMinute(){
      //Increases time by one minute
   min++;
   if (min > 59){
       min = 0;
       advanceHours();
   }
  }
  //////////////////////////////////////////////////
  //NAME:       advanceHours
  //BEHAVIOUR:  Increases time by one hour
  //PARAMETERS: None
  //RETURNS:    Nothing
  ///////////////////////////////////////////////////
  private void advanceHours(){
      //Increments hours
      hr++;
      if (hr > 23){
          hr = 0;
      }
  }
  public static int currentsec(){
      //Gets current sec from current calendar
      Calendar now = Calendar.getInstance();
      return now.get(Calendar.SECOND);
  }
  public static int currentmin(){
      //Gets current min from current calendar
      Calendar now = Calendar.getInstance();
      return now.get(Calendar.MINUTE);
  }
  public static int currenthr(){
      //Gets current hr from current calendar
      Calendar now = Calendar.getInstance();
      return now.get(Calendar.HOUR);
  }
  //////////////////////////////////////////////////
  //NAME:       calibrate
  //BEHAVIOUR:  sets the time to current time
  //PARAMETERS: None
  //RETURNS:    Nothing
  ///////////////////////////////////////////////////
  public void calibrate() {
   Calendar cal= Calendar.getInstance();
      hr = currenthr();
      min = currentmin();
      sec = currentsec();
      if(cal.get(Calendar.AM_PM) == 0)
          s = "a.m";
      else
          s = "p.m";
  }
  //////////////////////////////////////////////////
  //NAME:       reset
  //BEHAVIOUR:  Resets time to 00:00:00
  //PARAMETERS: None
  //RETURNS:    Nothing
  ///////////////////////////////////////////////////
  public void reset() { 
    hr = 0;
    min = 0;
    sec = 0;
        
  }
  //////////////////////////////////////////////////
  //NAME:       set
  //BEHAVIOUR:  sets time according to user parameters
  //PARAMETERS: hours,minutes,seconds
  //RETURNS:    Nothing
  ///////////////////////////////////////////////////
  public void set(int hours, int minutes, int seconds) {
    
      sethours(hours);
      setminutes(minutes);
      setseconds(seconds);
  }
  //////////////////////////////////////////////////
  //NAME:       getHours
  //BEHAVIOUR:  Returns the hours
  //PARAMETERS: None
  //RETURNS:    The hours of Clock
  ///////////////////////////////////////////////////
  public int gethours(){
      return hr;
  }
  //////////////////////////////////////////////////
  //NAME:       getMinutes
  //BEHAVIOUR:  Returns the minutes
  //PARAMETERS: None
  //RETURNS:    The minutes of Clock
  ///////////////////////////////////////////////////
  public int getminutes(){
      return min;
  }
  //////////////////////////////////////////////////
  //NAME:       getSeconds
  //BEHAVIOUR:  Returns the second
  //PARAMETERS: None
  //RETURNS:    The seconds of Clock
  ///////////////////////////////////////////////////
  public int getseconds(){
      return sec;
  }
  //Returns boolean value of hours
  public boolean sethours(int hours){
    if (hours >= 0 && hours < 24) {
        hr = hours;
        return true;
      }
        return false;
  }
  //Returns boolean value of minutes
  public boolean setminutes(int minutes){
    if(minutes >= 0 && minutes < 60){
        min = minutes;
        return true;
      }
        return false;
  }
  //Returns boolean value of seconds
  public boolean setseconds(int seconds){
    if (seconds >= 0 && seconds < 60){
        sec = seconds;
        return true;
      }
        return false;
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


