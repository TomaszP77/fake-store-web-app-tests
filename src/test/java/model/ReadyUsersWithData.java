package model;

public class ReadyUsersWithData {

    private String email;
    private String password;

    public ReadyUsersWithData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static ReadyUsersWithData userWithAccount() {
        return new ReadyUsersWithData("abc@de322.fg", "Abcd123456789$");
    }

    public static ReadyUsersWithData userWithOutAccount() {
        return new ReadyUsersWithData("1234", "abc");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
