package main.java;

public class Email implements Comparable<Email> {
    private String address;
    private String domain;

    public Email(String address) {
        this.address = address;
        this.domain = address.substring(address.indexOf("@"));
    }

    public static boolean isValid(String address) {
        if (address.indexOf("@") != -1) {
            return true;
        }
        return false;
    }

    public int compareTo(Email email) {
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
