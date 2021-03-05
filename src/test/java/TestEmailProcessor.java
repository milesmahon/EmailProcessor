import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TestEmailProcessor {

    private EmailProcessor emailProcessor;
    private final Path OUTPUT_FILE_PATH = Paths.get("output.txt");
    private final String INPUT_STANDARD_FILE_PATH = "./src/test/testFiles/inputStandard.txt";
    private final Path OUTPUT_STANDARD_FILE_PATH = Paths.get("./src/test/testFiles/outputStandard.txt");
    private final String INPUT_VALID_FILE_PATH = "./src/test/testFiles/inputValid.txt";
    private final Path OUTPUT_VALID_FILE_PATH = Paths.get("./src/test/testFiles/outputValid.txt");
    private final String INPUT_INVALID_FILE_PATH = "./src/test/testFiles/inputInvalid.txt";
    private final Path OUTPUT_INVALID_FILE_PATH = Paths.get("./src/test/testFiles/outputInvalid.txt");

    public void setup() {
        emailProcessor = new EmailProcessor();
        File file = new File(OUTPUT_FILE_PATH.toString());
        try {
            Files.deleteIfExists(file.toPath());
        } catch(IOException e) {
            System.out.println("Failed to delete output file.");
        }
    }

    public void testProcessorStandardCase() throws IOException {
        emailProcessor.main(new String[] {INPUT_STANDARD_FILE_PATH});
        assert(Arrays.equals(Files.readAllBytes(OUTPUT_FILE_PATH), Files.readAllBytes(OUTPUT_STANDARD_FILE_PATH)));
    }

    public void testProcessorAllInvalidCase() throws IOException {
        emailProcessor.main(new String[] {INPUT_INVALID_FILE_PATH});
        assert(Arrays.equals(Files.readAllBytes(OUTPUT_FILE_PATH), Files.readAllBytes(OUTPUT_INVALID_FILE_PATH)));
    }

    public void testProcessorAllValidCase() throws IOException {
        emailProcessor.main(new String[] {INPUT_VALID_FILE_PATH});
        assert(Arrays.equals(Files.readAllBytes(OUTPUT_FILE_PATH), Files.readAllBytes(OUTPUT_VALID_FILE_PATH)));
    }
}
