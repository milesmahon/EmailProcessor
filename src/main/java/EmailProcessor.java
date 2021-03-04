package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmailProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Email> emails = new ArrayList<>();
        File inputFile = new File(args[0]);
        try {
            Scanner sc = new Scanner(inputFile);
            sc.useDelimiter("\\n");
            while (sc.hasNext()) {
                String address = sc.next();
                if (Email.isValid(address)) {
                    emails.add(new Email(address));
                }
            }
        } catch(FileNotFoundException e) {
            throw e;
        }

        Collections.sort(emails);

        for (Email email : emails){
            System.out.println(email.getDomain());
        }
    }
}
