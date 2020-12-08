package com.learning;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 比对出差集数据
 */
public class FileTest {

    public static void main(String[] args) {
        //获取我方数据库中的手机号再去重
        List<String> insideList2 = getMySelfData("E:\\filter_final.csv");
        //获取电信方的手机号再去重
        List<String> outSideList2 = getOutChinaNetData();
        //取两者差集
        List<String> subList = insideList2.stream()
                .filter(item -> !outSideList2.contains(item))
                .collect(Collectors.toList());
        //相差个数
        System.out.println("相差个数=" + subList.size());
        //取出相差的手机号
        subList.forEach(System.out::println);
    }
    /**
     * 获取外部的手机号再去重
     * @return List<String>
     */
    private static List<String> getOutChinaNetData() {
        LineIterator it2 = null;
        //存储电信方手机号的数据
        List<String> outSideList = new LinkedList<>();
        try {
            //读取电信方文件
            it2 = FileUtils.lineIterator(new File("E:\\var\\inside\\chinaNetData.txt"));
            while (it2.hasNext()) {
                String line = it2.nextLine();
                //新增每行记录
                outSideList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            LineIterator.closeQuietly(it2);
        }
        //去重后的手机号
        List<String> outSideList2 = outSideList.stream().distinct().collect(Collectors.toList());
        System.out.println("外部数据个数："  + outSideList2.size());
        return outSideList2;
    }

    /**
     * 先查询我方数据库中的手机号再去重
     * @return List<String>
     */
    private static List<String> getMySelfData(String path) {
        //存储数据库中自己手机号的数据
        List<String> myselfList = new LinkedList<>();
        LineIterator it = null;
        try {
            //读取内部系统文件
            it = FileUtils.lineIterator(new File(path));
            while (it.hasNext()) {
                String line = it.nextLine();
                //新增每行记录
                myselfList.add(line.substring(0, line.indexOf(",")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            LineIterator.closeQuietly(it);
        }
        //去重后的手机号

        List<String> insideList2 = myselfList.stream().distinct().collect(Collectors.toList());
        System.out.println("系统内部数据个数："  + insideList2.size());
        return insideList2;
    }
}
