
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailProcessor {
    private static final Logger log = Logger.getLogger(EmailProcessor.class.getName());

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
        } catch (FileNotFoundException e) {
            log.log(Level.SEVERE, String.format("Input file %s not found", inputFile.toString()));
            throw e;
        }

        Collections.sort(emails);

        try {
            FileWriter writer = new FileWriter("output.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            for (Email email : emails){
                buffer.write(email.toString());
                buffer.write("\n");
            }
            buffer.close();
        } catch (IOException e) {
            log.log(Level.SEVERE, "Failed to write to output file");
        }
    }
}
