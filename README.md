# Email processor
Java program to process a list of emails, remove invalid addresses, and sort by domain name.

## Usage

### Setup
With [Maven installed](https://maven.apache.org/install.html):

`mvn compile` in the project directory before running.

`mvn test` to run unit tests.

### Running
Run 
`mvn exec:java` to run EmailProcessor on input.txt

Or, `mvn exec:java -Dexec.mainClass=EmailProcessor -Dexec.args="yourDesiredTextFile.txt"`

## Assumptions
input.txt contains (maybe invalid-format) email addresses separated by newlines.

## Further improvements
Allow user to specify output file

Verify the number of command line arguments given