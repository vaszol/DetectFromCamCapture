package ru.vaszol;

import org.opencv.core.Core;
import org.opencv.highgui.VideoCapture;

import java.awt.image.BufferedImage;

/**
 * Created by vas on 16.03.2015.
 */
public class VideoCap {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    VideoCapture cap;
    Mat2Image mat2Img = new Mat2Image();

    VideoCap(){
        cap = new VideoCapture();
        cap.open(1);
    }

    BufferedImage getOneFrame() {
        cap.read(mat2Img.mat);
        return mat2Img.getImage(mat2Img.mat);
//        return mat2Img.detectFace(mat2Img.mat);

    }
}
