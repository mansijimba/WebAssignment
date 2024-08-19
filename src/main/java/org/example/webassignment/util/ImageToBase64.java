package org.example.webassignment.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class ImageToBase64 {

    public String getImageToBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/files/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try{
            bytes = Files.readAllBytes(file.toPath());
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }
}
