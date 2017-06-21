package com.cqupt.text.exp;

import java.time.LocalDate;

/**
 * @author weigs
 * @date 2017/5/15 0015
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate myBirthday = LocalDate.of(1996, 10, 23);
        int birthdayYear = myBirthday.getYear();
        LocalDate dateNow = LocalDate.now();
        int nowYear = dateNow.getYear();
        System.out.println("我的年龄为："+(nowYear - birthdayYear - 1));
        LocalDate dataToIncrement = LocalDate.of(myBirthday.getYear(), myBirthday.getMonth(),myBirthday.getDayOfMonth());
        int dayCounter = 0;
        while (dayCounter < 2001) {
            dataToIncrement = dataToIncrement.plusDays(1);
            dayCounter++;
            if ((dayCounter % 1000) == 0){
                //年
                int years = dataToIncrement.getYear() - myBirthday.getYear() - 1;
                //月
                int months;
                if (dataToIncrement.getMonth().getValue() > myBirthday.getMonth().getValue()) {
                    months = dataToIncrement.getMonth().getValue() - myBirthday.getMonth().getValue();
                } else {
                    months = dataToIncrement.getMonth().getValue() + (12 - myBirthday.getMonth().getValue());
                }
                //天
                int days;
                if (dataToIncrement.getMonth().getValue() > myBirthday.getMonth().getValue()) {
                    days = dataToIncrement.getDayOfYear() - myBirthday.getDayOfYear();
                } else {
                    if (myBirthday.plusYears(years).isLeapYear())
                        days = dataToIncrement.getDayOfYear() + (366 - myBirthday.getDayOfYear());
                    else
                        days = dataToIncrement.getDayOfYear() + (365 - myBirthday.getDayOfYear());
                }
                System.out.println(dayCounter+" days old on "+dataToIncrement+"  "
                    +years+" years, "+months+"months, "+days+" days");

            }
        }
    }
}
