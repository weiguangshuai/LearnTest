package com.cqupt.text.exp;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/5/22 0022
 */
class  EnglishCalendar
{
    protected  int  this_year ;
    protected  int  this_month ;

    protected  String[]  names_of_months ;
    protected  String    week_description ;

    public EnglishCalendar()
    {
    }

    public EnglishCalendar( int given_year, int given_month )
    {
        String[]  english_names_of_months  =

                { "January", "February", "March", "April",
                        "May", "June", "July", "August",
                        "September", "October", "November", "December" } ;

        String  english_week_description  =

                " Week   Mon  Tue  Wed  Thu  Fri  Sat  Sun" ;

        names_of_months   =  english_names_of_months ;

        week_description  =  english_week_description ;

        this_year   =  given_year  ;
        this_month  =  given_month ;
    }

    public int get_calendar_year()
    {
        return this_year ;
    }

    public int get_calendar_month()
    {
        return this_month ;
    }


    public void increment_calendar_month()
    {
        this_month ++ ;

        if ( this_month > 12 )
        {
            this_month = 1 ;
            this_year ++ ;
        }
    }

    public void increment_calendar_year(){
        this.this_year ++ ;
        this_month = 1;
    }

    public void print()
    {
        LocalDate a_day_in_this_month  =
                LocalDate.of( this_year, this_month, 1 ) ;

        // Days of week are numbered from 1 to 7.
        // The first day of week is Monday.

        int day_of_week_value = 1 ;

        int day_of_week_of_first_day  =
                a_day_in_this_month.getDayOfWeek().getValue() ;

        System.out.print(
                "\n\n   "  +  names_of_months[ this_month - 1 ]
                        +  "  "  +  this_year  +  "\n\n"  +  week_description   +  "\n\n" );

        System.out.printf( "%4d  ",  a_day_in_this_month.get(
                WeekFields.ISO.weekOfWeekBasedYear() ) ) ;

        // The first week of a month is often an incomplete week,
        // i.e., the first part of week belongs to the previous
        // month. In place of the days that belong to the previous
        // month we print just spaces.

        while ( day_of_week_value != day_of_week_of_first_day )
        {
            System.out.print( "     " )  ;
            day_of_week_value  ++ ;
        }

        while ( this_month  ==  a_day_in_this_month.getMonthValue() )
        {
            if ( day_of_week_value  >=  8 )
            {
                System.out.printf( "\n%4d  ",
                        a_day_in_this_month.get(
                                WeekFields.ISO.weekOfWeekBasedYear() ) ) ;

                day_of_week_value  =  1 ;
            }

            System.out.printf( "%5d", a_day_in_this_month.getDayOfMonth() ) ;

            a_day_in_this_month = a_day_in_this_month.plusDays( 1 ) ;

            day_of_week_value  ++  ;
        }

        System.out.print( "\n" ) ;
    }
}



class  SpanishCalendar  extends  EnglishCalendar
{
    public SpanishCalendar( int given_year, int given_month )
    {
        String[]  spanish_names_of_months  =

                { "Enero", "Febrero", "Marzo", "Abril",
                        "Mayo", "Junio", "Julio", "Agosto",
                        "Septiembre", "Octubre", "Noviembre", "Diciembre" } ;

        String   spanish_week_description  =

                "Semana  Lun  Mar  Mie  Jue  Vie  Sab  Dom" ;

        names_of_months   =  spanish_names_of_months ;
        week_description  =  spanish_week_description ;

        this_year   =  given_year  ;
        this_month  =  given_month ;
    }
}


class  MonthCalendars
{
    /*
    public static void main( String[] not_in_use )
    {
        Scanner keyboard  =  new  Scanner( System.in ) ;

        SpanishCalendar a_spanish_calendar  = new SpanishCalendar( 2017, 5 ) ;

        a_spanish_calendar.print() ;


        EnglishCalendar calendar_to_print = new EnglishCalendar( 2017, 7) ;

        calendar_to_print.print() ;

        String  user_selection  =  "????"  ;

        System.out.print("\n This program prints calendars. Please, select from"
                +  "\n the following menu by typing in a letter. ") ;

        while ( user_selection.charAt( 0 )  !=  'e' )
        {
            System.out.print("\n\n   p   Print current calendar."
                    +  "\n   n   Print next calendar."
                    +  "\n   s   Switch to Spanish calendars."
                    +  "\n   e   Exit the program.\n\n   " ) ;

            user_selection  =  keyboard.nextLine() ;

            if ( user_selection.charAt( 0 )  ==  'p' )
            {
                calendar_to_print.print() ;
            }
            else if ( user_selection.charAt( 0 )  ==  'n' )
            {
                calendar_to_print.increment_calendar_month() ;

                calendar_to_print.print() ;
            }
            else if ( user_selection.charAt( 0 )  ==  's' )
            {
                // We'll take the calendar year and month from the old calendar
                // object and use them to create a SpanishCalendar object.

                calendar_to_print =
                        new SpanishCalendar( calendar_to_print.get_calendar_year(),
                                calendar_to_print.get_calendar_month() ) ;

                calendar_to_print.print() ;
            }
        }

    }
    */
    public static void main( String[] not_in_use ) {
        Scanner keyboard  =  new  Scanner( System.in ) ;

//        SpanishCalendar a_spanish_calendar  = new SpanishCalendar( 2017, 5 ) ;

//        a_spanish_calendar.print() ;
        //获得系统当前的时间
        LocalDate localDate = LocalDate.now();
        int given_year = localDate.getYear();
        int given_month = localDate.getMonthValue();

        EnglishCalendar calendar_to_print = new EnglishCalendar( given_year, given_month) ;

        calendar_to_print.print() ;

        String  user_selection  =  "????"  ;

        System.out.print("\n This program prints calendars. Please, select from"
                +  "\n the following menu by typing in a letter. ") ;

        while ( user_selection.charAt( 0 )  !=  'e' )
        {
            System.out.print("\n\n   p   Print current calendar."
                    +  "\n   n   Print next calendar."
                    +  "\n   s   Switch to Spanish calendars."
                    +  "\n   g   Switch to German calendars."
                    +  "\n   c   Switch to Chinese calendars."
                    +  "\n   y   Print next year calendar."
                    +  "\n   e   Exit the program.\n\n   " ) ;

            user_selection  =  keyboard.nextLine() ;

            if ( user_selection.charAt( 0 )  ==  'p' )
            {
                calendar_to_print.print() ;
            }
            else if ( user_selection.charAt( 0 )  ==  'n' )
            {
                calendar_to_print.increment_calendar_month() ;

                calendar_to_print.print() ;
            }
            else if ( user_selection.charAt( 0 )  ==  's' )
            {
                // We'll take the calendar year and month from the old calendar
                // object and use them to create a SpanishCalendar object.

                calendar_to_print =
                        new SpanishCalendar( calendar_to_print.get_calendar_year(),
                                calendar_to_print.get_calendar_month() ) ;

                calendar_to_print.print() ;

            } else if (user_selection.charAt(0) == 'g') {

                calendar_to_print = new GermanCalendar(calendar_to_print.get_calendar_year(),
                        calendar_to_print.get_calendar_month());

                calendar_to_print.print();

            } else if (user_selection.charAt(0) == 'c') {

                calendar_to_print = new ChineseCalendar( calendar_to_print.get_calendar_year(),
                        calendar_to_print.get_calendar_month() );

                calendar_to_print.print();

            } else if (user_selection.charAt(0) == 'y') {

               calendar_to_print.increment_calendar_year();

               calendar_to_print.print();

            }
        }

    }
}


class GermanCalendar extends EnglishCalendar{
    public GermanCalendar(int given_year, int given_month  ) {
        String[]  german_names_of_months  =

                { "January", "February", "March", "April",
                        "May", "June", "July", "August",
                        "September", "October", "November", "December" } ;

        String  german_week_description  =

                " Week   Mon  Tue  Wed  Thu  Fri  Sat  Sun" ;

        names_of_months   =  german_names_of_months ;

        week_description  =  german_week_description ;

        this_year   =  given_year  ;
        this_month  =  given_month ;
    }




}

class ChineseCalendar extends EnglishCalendar{
    public ChineseCalendar(int given_year, int given_month ) {
        String[]  chinese_names_of_months  =

                { "一月", "二月", "三月", "四月",
                        "五月", "六月", "七月", "八月",
                        "九月", "十月", "十一月", "十二月" } ;

        String  chinese_week_description  =

                " 周数   星期一  星期二  星期三  星期四  星期五  星期六  星期日" ;

        names_of_months   =  chinese_names_of_months;

        week_description  =  chinese_week_description;

        this_year   =  given_year  ;
        this_month  =  given_month ;
    }
}


