package appiumSelenide.utils.props;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import static appiumSelenide.utils.props.Properties.*;
import static java.lang.System.getProperty;

public class GeneralProperties {
    private Properties props = new Properties();
    private boolean reset;
    private boolean update;

    private String deviceId;
    private String mobilePlatform;
    private String osVersion;
    private String apkName;

    private boolean rerun;
    private int counter;
    private String appiumServerIp;
    private String appiumServerFullAddress;
    private String appiumPort;

    private String userName;
    private String userPass;

    private static GeneralProperties instance;

    private final static String CONFIG_FILE = "config.properties";
    private final static Logger LOG = LoggerFactory.getLogger(GeneralProperties.class);


    private GeneralProperties() {
        InputStream inputStream;
        try {
            String resource = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(CONFIG_FILE)).getPath();
            inputStream = new FileInputStream(resource);
            props.load(inputStream);

//             app properties
            update = Boolean.valueOf(getPropValue(UPDATE_PROPERTY));
            reset = Boolean.valueOf(getPropValue(RESET_PROPERTY));
            apkName = getPropValue(APK_NAME);

//             device properties
            deviceId = getPropValue(DEVICE_ID_PROPERTY);
            mobilePlatform = getPropValue(MOBILE_PLATFORM);
            osVersion = getPropValue(OS_VERSION);

//             tests properties
            rerun = Boolean.valueOf(getPropValue(RERUN_PROPERTY));
            counter = Integer.valueOf(getPropValue(COUNTER_PROPERTY));
            appiumPort = getPropValue(APPIUM_SERVER_PORT);
            appiumServerIp = getPropValue(APPIUM_SERVER_IP);
            appiumServerFullAddress = setAppiumFullAddress(appiumServerIp);

        } catch (java.io.IOException e) {
            e.printStackTrace();
            LOG.error("Configuration file is not found!");
        }
    }

    private String getPropValue(String propName) {
        return getProperty(propName, "").isEmpty() ? props.getProperty(propName) : getProperty(propName);
    }

    public static GeneralProperties getInstance() {
        if (instance == null) instance = new GeneralProperties();
        return instance;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return getDeviceName();
    }


    public String getMobilePlatform() {
        return mobilePlatform;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public boolean isRerun() {
        return rerun;
    }

    public int getCounter() {
        return counter;
    }

    public String getApkName() {
        return apkName;
    }

    public boolean isReset() {
        return reset;
    }

    public boolean isUpdate() {
        return update;
    }

    public String getAppiumServerIp() {
        return appiumServerIp;
    }

    public String getAppiumServerFullAddress() {
        return appiumServerFullAddress;
    }

    public String getAppiumPort() {
        return appiumPort;
    }

    private String setAppiumFullAddress(String appiumServerIp) {
        return "http://" + appiumServerIp + ":" + appiumPort + "/wd/hub";
    }
}
