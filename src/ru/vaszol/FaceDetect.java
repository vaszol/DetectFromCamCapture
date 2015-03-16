package ru.vaszol;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.core.*;
/**
 * Created by vas on 13.03.2015.
 */
public class FaceDetect {
    public void run() {
        CascadeClassifier faceDetector = new CascadeClassifier(getClass()
                .getResource("/lbpcascade_frontalface.xml").getPath());
        Mat image = Highgui.imread(getClass().getResource(
                "/AverageMaleFace.jpg").getPath());

        // Detect faces in the image.
        // MatOfRect is a special container class for Rect.
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("Detected %s faces",
                faceDetections.toArray().length));

        // Draw a bounding box around each face.
        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }

        // Save the visualized detection.
        String filename = "faceDetection.png";



        System.out.println(String.format("Writing %s", filename));
        Highgui.imwrite(filename, image);
    }
}
