import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        try {
            Person obj = new Person(30105240649L, "Jonas", "Petrauskas");

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("Name: " + obj.getFirstName());
            System.out.println("Last name: " + obj.getLastName());
            System.out.println("Birthday: " + df.format(obj.getBirthdaydate()));
            System.out.println("Gender: " + obj.getGender());
            System.out.println("Age: "+ obj.getAge());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
  }
}
