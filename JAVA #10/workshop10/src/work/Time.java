/**********************************************
Workshop 10
Course:JAC444 - Semester 4
Last Name: Patel
First Name: Ved
ID: 149409203
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: VedPatel
Date: 08/05/2022
**********************************************/
package work;

public class Time implements Cloneable, Comparable < Time > {

  //1
  private long TimeElapsed;

  //2
  public Time() {
    TimeElapsed = System.currentTimeMillis() / 1000;
  }

  //3
  public Time(int Hour, int Minute, int Second) {
    TimeElapsed = (((Hour * 60) + Minute) * 60) + Second;
  }

  //4
  public Time(long tempTime) {
    this.TimeElapsed = tempTime;
  }

  //5
  public int getHour() {
    return (int)(TimeElapsed / 3600);
  }

  //6
  public int getMinute() {
    return (int)(TimeElapsed - (getHour() * 3600)) / 60;
  }

  //7
  public int getSecond() {
    return (int) TimeElapsed - (getHour() * 3600) - (getMinute() * 60);
  }

  //8
  public long getSeconds() {
    return TimeElapsed;
  }

  //9
  public String toString() {
    return String.format("%d hours %d minutes %d seconds", getHour(), getMinute(), getSecond());
  }

  //10
  public boolean equals(Time Temp) {
    return Temp.TimeElapsed == TimeElapsed;
  }

  public int compareTo(Time Temp) {
	  return (int)(TimeElapsed - ((Time) Temp).TimeElapsed);
  }
  
  //11
  public Time clone() {
	  Time T1 = new Time();
	  T1.TimeElapsed = TimeElapsed;
	  return T1;
  }
}