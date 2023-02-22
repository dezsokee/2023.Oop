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
        if (year % 4 == 0 && year % 100 != 0)
        {
            return true;
        }
        else if (year % 100 == 0 && year % 400 == 0)
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
        //megadom hogy milyen formatumu kell legyen a datum Stringem
        String DATE_FORMAT = "dd-MM-yyyy";
        //osszerakom a Stringet az integer inputokbol
        String string_date = String.valueOf(day) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
        try {
            //letrehozok egy DateFormat objektumot
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            //ne legyen engedékeny az objektum
            df.setLenient(false);
            //átadom a saját dátum Stringemet az objektumnak, hogy eldöntse valid-e vagy sem?
            df.parse(string_date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
