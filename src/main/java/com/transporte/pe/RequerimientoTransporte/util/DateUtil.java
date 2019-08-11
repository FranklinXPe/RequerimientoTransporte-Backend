package com.transporte.pe.RequerimientoTransporte.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String fmtDt(Date date) {
        if (date == null)
            return "";
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String dateFormatFactElct(Date date) {
        if (date == null)
            return "";
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    public static Date parse(SimpleDateFormat sdf,String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date truncDay(Date date) {
        if (date == null)
            return null;
        Calendar cal = buildCal(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private static Calendar buildCal(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static String getPeriod(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String format = sdf.format(date);
        String month = format.substring(0, 2);
        String day = format.substring(3, 5);
        String year = format.substring(6, 10);
        return year + month + day;
    }

    public static Date toDate(String period) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String year = period.substring(0, 4);
        String month = period.substring(4, 6);
        String day = period.substring(6, 8);
        Date format = sdf.parse(month + "/" + day + "/" + year);
        System.out.println(month + "/" + day + "/" + year);
        return format;
    }


    public static Date getCalculateDaysDate(Date dateCal, int days){

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(dateCal);

        calendar.add(Calendar.DAY_OF_YEAR, days);

        return calendar.getTime();

    }


    public static Date getCleanTimeDate(Date dateCal){

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(dateCal);

        calendar.set(Calendar.HOUR_OF_DAY, 0);

        return calendar.getTime();

    }

    public static Date getFirstDayOfMonth() throws ParseException{
        LocalDate date = LocalDate.now();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse("01/"+date.getMonthValue() + "/" + date.getYear());
    }
    /*
     * Obtener el primer dia del año
     * @param int Anio
     * */
    public static Date getFirstDayOfYear(int Anio) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse("01/01/" + Anio);
    }

    /*
     * Obtener el ultimo dia del año
     * @param int Anio
     * */
    public static Date getLastDayOfYear(int Anio) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse("31/12/" + Anio);
    }

    /*
     * Obtener la fecha del primer dia de un mes del año en curso
     * @param int Mes
     * */
    public static Date getFirstDayOfMonth(int Mes,int Anio) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse("01/"+Mes+ "/" + Anio);
    }
    /*
     * Obtener la fecha del ultimo dia de un mes en el año en curso
     * @param int Mes
     * */
    public static Date getLastDayOfMonth(int Mes,int Anio) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(getLastDay(Mes,Anio)+"/"+Mes+ "/" + Anio);
    }
    /*
     * Obtener el ultimo dia de un mes
     * @param int Mes
     * */
    public static int getLastDay(int Mes,int Anio){
        if(Mes==2){
            if(Anio%4==0){
                return 29;
            }else{
                return 28;
            }
        }else{
            if(Mes==4 || Mes==6 || Mes==9 || Mes==11){
                return 30;
            }else{
                return 31;
            }
        }
    }
}

