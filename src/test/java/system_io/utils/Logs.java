package system_io.utils;

import io.qameta.allure.Allure;

import java.nio.file.Files;
import java.nio.file.Path;

public class Logs {

    public static void attachLogsOnFailure() {
        try {
            Path logFile = Path.of("target/test.log");
            if (Files.exists(logFile)) {
                Allure.addAttachment(
                        "test.log",
                        "text/plain",
                        Files.readString(logFile)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
