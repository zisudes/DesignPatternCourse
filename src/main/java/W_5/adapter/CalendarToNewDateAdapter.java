package W_5.adapter;

import java.util.Calendar;

import static java.util.Calendar.*;

public class CalendarToNewDateAdapter implements NewDateInterface {
    Calendar calendar;

    public CalendarToNewDateAdapter(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void setDay(int day) {
        this.calendar.set(DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        this.calendar.set(MONTH, month);
    }

    @Override
    public void setYear(int year) {
        this.calendar.set(YEAR, year);
    }

    @Override
    public int getDay() {
        return this.calendar.get(DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return this.calendar.get(MONTH);
    }

    @Override
    public int getYear() {
        return this.calendar.get(YEAR);
    }

    @Override
    public void advanceDays(int days) {
        this.calendar.add(DAY_OF_MONTH, days);
    }

    @Override
    public String toString() {
        return "Calendar - Current Date: " + getDay() + "/" + getMonth() + "/" + getYear();
    }
}
