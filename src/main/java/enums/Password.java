package enums;

public enum Password {
    VALILD_PASSWORD("ivan123"),
    INVALID_PASSWORD("neshtosi");

    private String password;

    Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
