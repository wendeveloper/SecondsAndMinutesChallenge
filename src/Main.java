/*
create method that returns a string
getDurationString(long minutes, long seconds)
calculate how many hours, minutes, and seconds equal the minutes and seconds passed in.
return the value as String "XXh YYm ZZs" where
XX represents hours
YY represents minutes
ZZ represents seconds

next-
create same name method to overload but only one parameter of seconds.
calculate how many minutes are in the seconds value
call the other overloaded method passing in correct minutes and seconds

print both methods to console.
 */

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        System.out.println(getDurationString(65L, 45L));
        System.out.println(getDurationString( 3945L));
        System.out.println(getDurationString(-41));
        System.out.println(getDurationString(65, 9));
    }


    private static String getDurationString(long minutes, long seconds) {

        if ((minutes < 0) || (seconds < 0) || (seconds > 59)) {  //validation
            return INVALID_VALUE_MESSAGE;
        }
        long ttlSeconds = (minutes * 60) + seconds;

        //calculate how many hours, minutes, seconds from ttlSeconds
//        long hours = ttlSeconds / 3600;
//        long remainderMinutes = (ttlSeconds % 3600)/60;
//        long remainderSeconds =  ttlSeconds % 60;

        long hours = minutes / 60;
        long remainderMinutes = minutes % 60;

        // display a leading zero in the return if less than double digits
        String strHours = hours + "h";
        if (hours < 10.00) {
            strHours = "0" + strHours;
        }

        // display a leading zero in the return if less than double digits
        String strMinutes = remainderMinutes + "m";
        if (remainderMinutes < 10.00) {
            strMinutes = "0" + strMinutes;
        }

        // display a leading zero in the return if less than double digits
        String strSeconds = seconds + "s";
        if (seconds < 10.00) {
            strSeconds = "0" + strSeconds;
        }
            // return joined strings
        return strHours + " " + strMinutes + " " + strSeconds;
    }

    private static String getDurationString(long seconds){
        if (seconds < 0){  //validation
            return INVALID_VALUE_MESSAGE;
        }
        // calculate how many minutes are in the seconds value and call overloaded method
        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;
        return getDurationString(minutes, remainingSeconds);  //return value from method call
    }
}
