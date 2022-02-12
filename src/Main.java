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

    public static void main(String[] args) {
        System.out.println(getDurationString(62, 3603));
        System.out.println(getDurationString( 7205));
    }

    public static String getDurationString(long minutes, long seconds){

        if (minutes < 0 || seconds < 0 && seconds > 59){
            return "Invalid value";
        }
        long ttlSeconds = (minutes * 60) + seconds;

        //calculate how many hours, minutes, seconds from ttlSeconds
        long hours = ttlSeconds / 3600;
        long remainderMinutes = (ttlSeconds % 3600)/60;
        long remainderSeconds =  ttlSeconds % 60;

        String strZero = "";
        if (hours > 9 || remainderMinutes > 9 || remainderSeconds > 9 ){
            // include a leading zero in the return if less than double digits
            strZero = "0";
        }
        return strZero + hours + "h " + strZero + remainderMinutes + "m " + strZero + remainderSeconds + "s";
    }

    public static String getDurationString(long seconds){
        if (seconds < 0){
            return "Invalid value";
        }
        // calculate how many minutes are in the seconds value and call overloaded method
        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;
        return getDurationString(minutes, remainingSeconds);
    }
}
