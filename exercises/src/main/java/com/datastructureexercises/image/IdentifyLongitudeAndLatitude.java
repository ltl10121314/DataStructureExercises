package com.datastructureexercises.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
/**
 * @author liutianlong
 * @date 2022-10-23 02:11
 * @description
 */
public class IdentifyLongitudeAndLatitude {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/liutianlong/Downloads/11.jpeg");
        readPicture(file);
    }

    /**
     * 读取照片里面的信息
     */
    private static void readPicture(File file) throws Exception {
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                String tagName = tag.getTagName();
                String desc = tag.getDescription();
                if (tagName.equals("Image Height")) {
                    System.out.println("图片高度: " + desc);
                } else if (tagName.equals("Image Width")) {
                    System.out.println("图片宽度: " + desc);
                } else if (tagName.equals("Date/Time Original")) {
                    System.out.println("拍摄时间: " + desc);
                } else if (tagName.equals("GPS Latitude")) {
                    System.err.println("纬度 : " + desc);
                    System.err.println("纬度(度分秒格式) : " + pointToLatlong(desc));
                } else if (tagName.equals("GPS Longitude")) {
                    System.err.println("经度: " + desc);
                    System.err.println("经度(度分秒格式): " + pointToLatlong(desc));
                }
            }
        }
    }

    /**
     * 经纬度格式 转换为 度分秒格式 ,如果需要的话可以调用该方法进行转换
     *
     * @param point 坐标点
     * @return
     */
    public static String pointToLatlong(String point) {
        Double du = Double.parseDouble(point.substring(0, point.indexOf("°")).trim());
        Double fen = Double.parseDouble(point.substring(point.indexOf("°") + 1, point.indexOf("'")).trim());
        Double miao = Double.parseDouble(point.substring(point.indexOf("'") + 1, point.indexOf("\"")).trim());
        Double duStr = du + fen / 60 + miao / 60 / 60;
        return duStr.toString();
    }

}
