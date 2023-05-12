The main test file is the "Test/Tests.java" file.

The file path for the credentials is currently set to "C\\temp\\ltu.json", which is specified in "Config/Config.java".

to clarify what i wrote in the email:

in "I0015N-LTUWebsite/src/test/java/com/example/i0015nltuwebsite/PageTests/Tests.java".
i create a new Config.downloadsFolder using "Configuration.downloadsFolder = "newDownloadsFolder";
then i delete that folder using the @AfterAll method called TearDownAll(). In hindsight i dont think its necessary to create a new path but i didnt wanna screw things up in my project.

then in the last @Test i download the pdf to the correct path using the code i sent you, you can see that code also in the "Tests.java" class

we've implemented page classes which contain all the paths to the webelements. sometimes you have to run the program a few times before it works correclty every time.
