package com.cqc.learning.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * ZipKit
 */
public class ZipKit {
    static Logger logger = LoggerFactory.getLogger(ZipKit.class);

    /**
     * 解压给定的zip
     *
     * @param zip zip字节流
     * @return Key=NAME（1/1.jpg） Value=字节
     */
    public static Map<String, byte[]> unzip(byte[] zip) {
        Map<String, byte[]> dictMap = new HashMap<String, byte[]>();
        ZipInputStream zis = null;
        try {
            zis = new ZipInputStream(new ByteArrayInputStream(zip));
            ZipEntry zipEntry = null;
            while ((zipEntry = zis.getNextEntry()) != null) {
                // 文件夹跳过
                if (zipEntry.isDirectory()) {
                    continue;
                }
                // 非文件夹
                OutputStream os = null;
                try {
                    os = new ByteArrayOutputStream(1024 * 64);
                    IoKit.copy(zis, os);
                    dictMap.put(zipEntry.getName(), ((ByteArrayOutputStream) os).toByteArray());
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                } finally {
                    IoKit.close(os);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            IoKit.close(zis);
        }
        return dictMap;
    }
}
