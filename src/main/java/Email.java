//import org.apache.commons.validator.EmailValidator;

import org.apache.commons.validator.EmailValidator;

public class Email implements Comparable<Email> {
    private final String address;
    private final String domain;

    public Email(String address) {
        this.address = address;
        this.domain = address.substring(address.indexOf("@"));
    }

    public static boolean isValid(final String address) {
        return EmailValidator.getInstance().isValid(address);
    }

    public int compareTo(final Email email) {
        return this.domain.compareTo(email.getDomain());
    }

    public String getDomain() {
        return domain;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return this.address;
    }
}
