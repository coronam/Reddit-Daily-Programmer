/*
Description
No more hiding from your alarm clock! You've decided you want your computer to keep you updated on the time so you're never late again. A talking clock takes a 24-hour time and translates it into words.
Input Description
An hour (0-23) followed by a colon followed by the minute (0-59).
Output Description
The time in words, using 12-hour format followed by am or pm.
Sample Input data
00:00
01:30
12:05
14:01
20:29
21:00
Sample Output data
It's twelve am
It's one thirty am
It's twelve oh five pm
It's two oh one pm
It's eight twenty nine pm
It's nine pm
*/
class TalkingClock{

    public static void main(String[] args){
        System.out.println(Time("00:00"));
        System.out.println(Time("01:30"));
        System.out.println(Time("12:05"));
        System.out.println(Time("14:01"));
        System.out.println(Time("20:29"));
        System.out.println(Time("21:00"));
        System.out.println(Time("21:10"));
    }

    public static String Time(String t){
        String[] time = t.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        String[] hours = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
        if( hour >= 12){
            hour = hour - 12;
            return "It's " + hours[hour] + Minutes(minute) + " pm";
        }else{
            return "It's " + hours[hour] + Minutes(minute) + " am";
        }
    }

    public static String Minutes(int m){
        String[] digits = {"oh", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eightteen", "nineteen"};
        String[] tens = {"null", "null", "twenty", "thirty", "forty", "fifty"};
        if(m == 00){
            return "";
        }if(m < 10){
            return " oh " + digits[m];
        }if(m < 20){
            return " " + teens[m%10];
        }else{
            String minutes = tens[m /10];
            if( (m%10) != 0){
                minutes = minutes + " " + digits[m%10];
            }
            return " " + minutes;
        }
    }

}