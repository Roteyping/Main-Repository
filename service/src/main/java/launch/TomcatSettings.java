package launch;

import com.beust.jcommander.Parameter;

import java.io.File;

public class TomcatSettings {
    @Parameter(names = "-TomcatDir", description = "Set the Tomcat Directory", required = false)
    private String tomcatDir = "tomcat";

    @Parameter(names = "-TomcatPort", description = "Set the Tomcat Port", required = false)
    private Integer tomcatPort = 8080;

    @Parameter(names = "-propertyDir", description = "Location of external properties", required = false)
    private String propertyDir = "properties";

    @Parameter(names = "-loggingDir", description = "Fully qualified Location to place log files", required = false)
    private String loggingDir = System.getProperty("user.dir")+ File.separator + "logs";

    public String getTomcatDir() {
        return tomcatDir;
    }

    public Integer getTomcatPort() {
        return tomcatPort;
    }

    public String getPropertyDir() {
        return propertyDir;
    }

    public String getLoggingDir() {
        return loggingDir;
    }
}
