import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

class Person {
    private long code;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthdaydate;
    private int age;

    Person(long code, String firstName, String lastName) throws Exception {
        setCode(code);
        setFirstName(firstName);
        setLastName(lastName);
    }

    private void setCode(long code) throws Exception {
        if (!this.isCodeValid(code)) {
            throw new Exception("Invalid personal code");
        }

        this.code = code;
        this.setBirthdaydate();
        this.setGender();
        this.setAge();
    }

    private boolean isCodeValid(long code) {
        ValidPersonalCode obj = new ValidPersonalCode(code);

        return obj.getValidCode();
    }

    private void setGender() {
        String codeNumberStr = Long.toString(this.code);
        String firstNumberStr = codeNumberStr.substring(0, 1);
        int firstNumber = Integer.parseInt(firstNumberStr);
        if (firstNumber != 3 && firstNumber != 5) {
            this.gender = HumanGender.WOMAN;
        } else {
            this.gender = HumanGender.MAN;
        }
    }

    private void setBirthdaydate() {
        this.birthdaydate = BirthdayExtractor.BirthdayDate(this.code);
    }

    private void setAge() {
        Date birthdayDate = (BirthdayExtractor.BirthdayDate(this.code));
        LocalDate date = birthdayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();
        Period p = Period.between(date, now);
        this.age = p.getYears();
    }

    long getAge() {
        return this.age;
    }

    String getGender() {
        return this.gender;
    }

    Date getBirthdaydate() {
        return this.birthdaydate;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getFirstName() {
        return firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getLastName() {
        return lastName;
    }
}