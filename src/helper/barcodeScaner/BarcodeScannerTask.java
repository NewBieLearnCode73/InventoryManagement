package helper.barcodeScaner;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.LuminanceSource;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTextField;

public class BarcodeScannerTask implements Runnable {
    private JTextField inventoryBarcode;
    private Webcam webcam;

    public BarcodeScannerTask(JTextField inventoryBarcode) {
        this.inventoryBarcode = inventoryBarcode;
        this.webcam = Webcam.getDefault();
        if (this.webcam.isOpen()) {
            webcam.close();
        }
        this.webcam.setViewSize(WebcamResolution.VGA.getSize());
        this.webcam.open();
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {

                if ((image = webcam.getImage()) == null) {
                    continue;
                }

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    result = new MultiFormatReader().decode(bitmap);
                } catch (NotFoundException e) {
                    // fall thru, it means there is no QR code in image
                }
            }

            if (result != null) {
                inventoryBarcode.setText(result.getText());
                try {
                    // Lấy đường dẫn tuyệt đối của file âm thanh
                    String absoluteFilePath = new File("sound/Ping.wav").getAbsolutePath();

                    // Tạo AudioInputStream từ file âm thanh
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(absoluteFilePath).getAbsoluteFile());

                    // Tạo Clip để phát âm thanh
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } 
                catch (IOException | LineUnavailableException | UnsupportedAudioFileException a) {
                    System.err.println("Error playing sound: " + a.getMessage());
                }
                break; // Exit the loop once a barcode is found
            }

        } while (true);

        webcam.close(); // Close the webcam after scanning
    }
}
