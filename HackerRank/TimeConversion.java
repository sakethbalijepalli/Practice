package HackerRank;

public class TimeConversion {
    static void main() {
        System.out.println(timeConversion("12:40:03AM"));
    }

    public static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        String restTime = s.substring(2, 8);
        String isAmOrPm = s.substring(8);

        if (isAmOrPm.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }
        return String.format("%02d%s", hour, restTime);
    }
}
