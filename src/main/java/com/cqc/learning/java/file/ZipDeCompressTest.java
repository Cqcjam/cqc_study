package com.cqc.learning.java.file;

import org.apache.commons.compress.compressors.z.ZCompressorInputStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 *@description:
 *@author:
 *@date:
 *@version:
 */
public class ZipDeCompressTest {

    private static final String fileName = "F:\\1517997811All2019-09-22.csv.zip.Z";

    public static void main(String[] args) {
        //压缩
        compressFile(fileName);
        //解压缩
        deCompressFile(fileName);
    }

    /**
     * 压缩文件成csv.zip.Z
     */
    private static void compressFile(String filaName) {
        try (FileInputStream fileInputStream = new FileInputStream(filaName);
             ZCompressorInputStream zIn = new ZCompressorInputStream(fileInputStream);
             ZipInputStream zipInputStream = new ZipInputStream(zIn);
             InputStreamReader inputStreamReader = new InputStreamReader(zipInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    String fileName = entry.getName();
                    //检测文件是否存在
                    if (fileName != null && fileName.endsWith("DETAIL.csv")) {
                        //取文件记录操作
                        System.out.println(bufferedReader.readLine());
                        //已读取，则跳出循环
                        break;
                    }
                }
                zipInputStream.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解csv.zip.Z压缩文件
     * @param filaPath
     */
    private static void deCompressFile(String filaName) {
        try (FileInputStream fileInputStream = new FileInputStream(filaName);
             ZCompressorInputStream zIn = new ZCompressorInputStream(fileInputStream);
             ZipInputStream zipInputStream = new ZipInputStream(zIn);
             InputStreamReader inputStreamReader = new InputStreamReader(zipInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    String fileName = entry.getName();
                    //检测文件是否存在
                    if (fileName != null && fileName.endsWith("DETAIL.csv")) {
                        //取文件记录操作
                        System.out.println(bufferedReader.readLine());
                        //已读取，则跳出循环
                        break;
                    }
                }
                zipInputStream.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
