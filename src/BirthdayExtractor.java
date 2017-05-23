import java.util.Date;
import java.util.GregorianCalendar;

class BirthdayExtractor {
    static Date BirthdayDate(long code) {
        int value = Integer.parseInt(birthdayCodeNumber(code));
        int year = value / 10000;
        int month = value % 10000 / 100 - 1;
        int day = value % 100;
        year += getMillennium(code);

        return (new GregorianCalendar(year, month, day)).getTime();
    }

    static String birthdayCodeNumber(long code) {
        String codeNumberStr = Long.toString(code);

        return codeNumberStr.substring(1, 7);
    }

    private static int getMillennium(long code) {
        String codeNumberStr = Long.toString(code);
        String firstNumberStr = codeNumberStr.substring(0, 1);
        int firstNumber = Integer.parseInt(firstNumberStr);

        return firstNumber != 3 && firstNumber != 4 ? 2000 : 1900;
    }
}
