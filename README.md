All code relevant to the email is in "Tests.java". (@BeforeAll at line 38) , (@AfterAll at line 50) and (@Test at line 198)

To run this program you have to change the logindetails in "I0015N-LTUWebsite/src/LTUcredentials.json" to what ever works for you. The file you have to run is the following "I0015N-LTUWebsite/src/test/java/com/example/i0015nltuwebsite/PageTests/Tests.java"

to clarify what i wrote in the email:

in "I0015N-LTUWebsite/src/test/java/com/example/i0015nltuwebsite/PageTests/Tests.java".
i create a new Config.downloadsFolder using "Configuration.downloadsFolder = "newDownloadsFolder";
then i delete that folder using the @AfterAll method called TearDownAll(). In hindsight i dont think its necessary to create a new path but i didnt wanna screw things up in my project.

then in the last @Test i download the pdf to the correct path using the code i sent you, you can see that code also in the "Tests.java" class

we've implemented page classes which contain all the paths to the webelements. sometimes you have to run the program a few times before it works correclty every time.
