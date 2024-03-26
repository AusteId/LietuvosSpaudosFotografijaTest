package APITesting.files;

public class Payload {

    public static String addUser(String email) {
        return String.format("""
                {
                  "name": "Name",
                  "surname": "Surname",
                  "email": "%s",
                  "password": "Password123@",
                  "birth_year": 2000,
                  "phone_number": "+37066666666",
                  "media_name": "freelancer"
                }
                """, email);
    }

    public static String loginUser(String email, String password) {
        return String.format("""
                {
                  "email": "%s",
                  "password": "%s"
                }
                """, email, password);
    }

    public static String changePassword(String email) {
        return String.format("""
                {
                  "email": "%s"
                }""", email);
    }




}
