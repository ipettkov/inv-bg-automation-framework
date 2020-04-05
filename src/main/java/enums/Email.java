package enums;

public enum Email {
    VALID_EMAIL("ipettkov@abv.bg"),
    INVALID_EMAIL("gosho");

    private String email;

    Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
