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

    public static String createCompetition(String nameLT, String nameEN, int photoLimit) {
        return String.format("""
                {
                  "status": "NONE",
                  "visibility": "PRIVATE",
                  "name_lt": "%s",
                  "name_en": "%s",
                  "description_lt": "Čia aprašau geriausią konkursą geriausioms nuotraukoms",
                  "description_en": "I write something about the best competition for best photos",
                  "photo_limit": %d,
                  "start_date": "2024-03-08T17:18:35.426Z",
                  "end_date": "2024-04-20T17:18:35.426Z"
                }
                """, nameLT, nameEN, photoLimit);
    }
}
