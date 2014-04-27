package launch;

import com.beust.jcommander.JCommander;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;


import java.io.File;
import java.net.URL;


public class Launcher {

    public static void main(String[] args) throws Exception {
        TomcatSettings settings = new TomcatSettings();
        new JCommander(settings, args);
        URL war = Launcher.class.getProtectionDomain().getCodeSource().getLocation();
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(settings.getTomcatDir());
        Context context = tomcat.addWebapp("/", war.getPath());
        System.setProperty("SL_LOG_HOME", settings.getLoggingDir());
        //create the log directory if it does not exist
        try{
            new File(System.getProperty("SL_LOG_HOME")).mkdirs();
        }catch(Exception e){
            //continue even if this fails.
            e.printStackTrace();
        }
        tomcat.setPort(settings.getTomcatPort());

        Connector connector = tomcat.getConnector();

        connector.setProperty("compression", "on");
        connector.setProperty("compressableMimeType", "text/html,text/xml,text/plain, text/css, application/javascript, application/json, application/json;charset=UTF-8 ");

        tomcat.setConnector(connector);
        tomcat.start();
        System.err.println("<<<Completed Tomcat Startup>>>");
        tomcat.getServer().await();
    }
}
