package com.cqc.learning.java.file;

import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.compressors.z.ZCompressorInputStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

public class TarDeCompressTest {
    public static void main(String[] args) {
        tarDecompress();
    }

    private static void tarDecompress() {
        try (FileInputStream fileInputStream = new FileInputStream("D:\\P_04761430_20190924.tar.gz.Z");
             ZCompressorInputStream zIn = new ZCompressorInputStream(fileInputStream);
             GZIPInputStream zipInputStream = new GZIPInputStream(zIn);
             ArchiveInputStream in = new ArchiveStreamFactory().createArchiveInputStream("tar", zipInputStream);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
            TarArchiveEntry entry;
            while ((entry = (TarArchiveEntry) in.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    String fileName = entry.getName();
                    System.out.println("fileName=" + fileName);
                    //检测文件是否存在
                    if (fileName != null && fileName.endsWith("ACOM")
                            || fileName.equals("AERR")) {
                        //取文件记录操作
                        String line = null;
                        while (null != (line =reader.readLine())) {
                            System.out.println(line);
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
