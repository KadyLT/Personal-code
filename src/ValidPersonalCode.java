import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class ValidPersonalCode {
    private boolean isValidCode;

    ValidPersonalCode(long code) {
        this.isValidCode = this.validCodeLenght(code) && this.validFirstNumber(code) && this.validBirthday(code);
    }

    boolean getValidCode() {
        return this.isValidCode;
    }

    private boolean validCodeLenght(long code) {
        String codeNumberStr = Long.toString(code);
        int len = codeNumberStr.length();

        return len == 11;
    }

    private boolean validBirthday(long code) {
        Date birthdayDate = BirthdayExtractor.BirthdayDate(code);
        DateFormat df = new SimpleDateFormat("yyMMdd");
        String birthDayDate = df.format(birthdayDate);
        String birthdayCode = BirthdayExtractor.birthdayCodeNumber(code);

        return birthDayDate.equals(birthdayCode);
    }

    private boolean validFirstNumber(long code) {
        String codeNumberStr = Long.toString(code);
        String firstNumberStr = codeNumberStr.substring(0, 1);
        int firstNumber = Integer.parseInt(firstNumberStr);

        return firstNumber <= 6 && firstNumber >= 3;
    }
}

