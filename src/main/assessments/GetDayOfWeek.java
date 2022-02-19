package main.assessments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GetDayOfWeek {


    public static void main(String[] args) {
        String[] dayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        GregorianCalendar cal = new GregorianCalendar();
//        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.DATE, 31);
        cal.set(Calendar.YEAR, 2019);

        String test = "test";
        test.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(DayOfWeek.of(cal.get(Calendar.DAY_OF_WEEK) - 1));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, day);
        cal.set(Calendar.YEAR, year);
        String result = DayOfWeek.of(cal.get(Calendar.DAY_OF_WEEK) - 1).toString();
        return result;
    }
}
