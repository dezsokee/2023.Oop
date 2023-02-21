package oop.labor02;

public class myDate {
    private int year, month, day;

    public myDate(int year, int month, int day)
    {
        DateUtil d1 = new DateUtil();
        if (d1.isValidDate(this.year, this.month, this.day))
        {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        else
        {

        }
    }

    public int getDay() {
        return this.day;
    }
    public int getYear()
    {
        return this.year;
    }
    public int getMonth() {
        return this.month;
    }

    public String toString()
    {
        String string_date = String.valueOf(this.day) + "-" + String.valueOf(this.month) + "-" + String.valueOf(this.year);
        return string_date;
    }
}
