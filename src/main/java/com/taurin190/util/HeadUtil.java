package com.taurin190.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class HeadUtil {
    private static final String HEAD_PROPERTIES_PATH = "/meta/head.properties";
    private static Properties properties;

    private HeadUtil() throws Exception {

    }

    static {
        properties = new Properties();
        try {
            Resource author_file_path = new ClassPathResource(HEAD_PROPERTIES_PATH);
            InputStream in = author_file_path.getInputStream();
            properties.load(new InputStreamReader(in, "UTF-8"));
        } catch (IOException e) {
            // ファイル読み込みに失敗
            System.out.println(String.format("ファイルの読み込みに失敗しました。ファイル名:%s", HEAD_PROPERTIES_PATH));
        }
    }

    public static String getProperty(final String key) {
        return getProperty(key, "");
    }

    public static String getProperty(final String key, final String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}