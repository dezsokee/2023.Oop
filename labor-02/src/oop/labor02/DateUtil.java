package oop.labor02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
    public DateUtil ()
    {

    }

    public static boolean loopYear (int year)
    {
        if (year % 4 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isValidDate(int year, int month, int day)
    {
        String DATE_FORMAT = "dd-MM-yyyy";
        String string_date = String.valueOf(day) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(string_date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
