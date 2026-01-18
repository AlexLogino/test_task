package system_io.utils;

public enum RunProfile {
    LOCAL,
    CI;

    public static RunProfile resolve() {
        String value =
                System.getProperty(
                        "run.profile",
                        System.getenv().getOrDefault("RUN_PROFILE", "LOCAL")
                );

        return RunProfile.valueOf(value.toUpperCase());
    }
}
