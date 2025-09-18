ECHO "Run test on chrome"
start mvn test -Dbrowser=Chrome -Dtest=RunCucumberChromeTest
ECHO "Finish test on chrome"
ECHO "---------------------"
ECHO "Starting test on Firefox"
start mvn test -Dbrowser=Firefox -Dtest=RunCucumberFireFoxTest