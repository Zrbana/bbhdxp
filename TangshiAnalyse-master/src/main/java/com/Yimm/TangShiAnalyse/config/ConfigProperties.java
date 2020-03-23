package com.Yimm.TangShiAnalyse.config;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName Poetry
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/20 14:23
 */


@Data
public class ConfigProperties {

    private String crawierBase;
    private String crawierPath;
    private boolean crawierDetail;

    private String dbUsername;
    private String dbPassword;
    private String dbUrl;
    private String dbDriverClass;

    private boolean enableConsole;


    public ConfigProperties(){
        //从外部文件加载
        InputStream inputStream = ConfigProperties.class.getClassLoader().
                getResourceAsStream("config.properties");

        Properties p=new Properties();

        try {
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.crawierBase= String.valueOf(p.get("crawier.base"));
        this.crawierPath= String.valueOf(p.get("crawier.path"));
        this.crawierDetail=Boolean.parseBoolean(String.valueOf(p.get("crawier.detail")));

        this.dbUsername=String.valueOf(p.get("db.username"));
        this.dbPassword=String.valueOf(p.get("db.password"));
        this.dbUrl=String.valueOf(p.get("db.url"));
        this.dbDriverClass=String.valueOf(p.get("db.driver_class"));

        this.enableConsole=Boolean.valueOf(
                String.valueOf(p.getProperty("config.enable_console","false")));
    }

}
