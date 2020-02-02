package common;

import java.util.Properties;

public class BaseConfiguration {
    private Properties configFile;

    public BaseConfiguration() {
        configFile = new Properties();
        try {
            configFile.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return this.configFile.getProperty(key);
    }
}
