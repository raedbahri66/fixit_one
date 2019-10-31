/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author lenovo
 */
public class CAM {
    public static void Capture()
    {
    try{
        Webcam webcam = Webcam.getDefault();
       webcam.open();
       ImageIO.write(webcam.getDevice().getImage(),"png",new File("image1.png"));
       webcam.close();
}
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    
}
