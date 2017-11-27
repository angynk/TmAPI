package Survey.Api.controller.processor;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EncuestaUtil {

    public static String obtenerDiaDeLaSemana(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        switch (day){
            case Calendar.MONDAY:
                return "Lunes";
            case Calendar.TUESDAY:
                return "Martes";
            case Calendar.WEDNESDAY:
                return "Miercoles";
            case Calendar.THURSDAY:
                return "Jueves";
            case Calendar.FRIDAY:
                return "Viernes";
            case Calendar.SATURDAY:
                return "Sabado";
            default:
                return "Domingo";
        }
    }

    public static Time getTimeFromString(String time){
        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        try {
            Date date = sdf.parse(time);
            return new Time(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Time(new Date().getTime());
    }
}
