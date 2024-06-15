package helper.processImage;

import controller.GoodReciptController;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class processImage {
    
    private static String dir = System.getProperty("user.dir");
    private static String imageFolderPath = dir + "\\src\\image\\";
    
    // Di chuyển image vào bên trong thư mục image của dự án
    public static String moveImage(String rootImagePath) {
        if (rootImagePath != null && !"".equals(rootImagePath)) {
            String[] rootImageNameArray = rootImagePath.split("\\\\");
            ArrayList<String> rootImageNameArrayList = new ArrayList<>(Arrays.asList(rootImageNameArray));
            String rootImageName = rootImageNameArrayList.get(rootImageNameArrayList.size() - 1); // Ví dụ: imageHello.jpg

            String tempImagePath = imageFolderPath + rootImageName;
            File tempImageFile = new File(tempImagePath);

            try {
                if (tempImageFile.exists()) {
                    // Nếu file tồn tại, thêm hậu tố vào tên file
                    int count = 1;
                    String newFileName;
                    File newFile;

                    // Tách tên file và phần mở rộng
                    String fileNameWithoutExtension = rootImageName.substring(0, rootImageName.lastIndexOf('.')); // C:\...\abcxyz
                    String fileExtension = rootImageName.substring(rootImageName.lastIndexOf('.')); // .jpg

                    do {
                        newFileName = fileNameWithoutExtension + "_" + count + fileExtension;
                        newFile = new File(imageFolderPath + newFileName);
                        count++;
                    } while (newFile.exists());

                    // Di chuyển file với tên mới
                    Files.copy(new File(rootImagePath).toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    
                    return newFile.getName();
                } else {
                    // Nếu file không tồn tại, di chuyển file vào thư mục image
                    Files.copy(new File(rootImagePath).toPath(), tempImageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    return tempImageFile.getName();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // Lấy image từ thư mục image
    public static String getImagePath(String imageName) {
        if (imageName != null && !imageName.isEmpty()) {
            File f = new File(imageFolderPath + imageName);
            if (f.exists()) {
                return f.getAbsolutePath();
            }
        }
            File f = new File(imageFolderPath + imageName);
            return f.getAbsolutePath();
    }

    // Lấy tên image
    public static String getImageName(String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            File file = new File(imagePath);
            String fileName = file.getName();
            int lastDotIndex = fileName.lastIndexOf(".");
            if (lastDotIndex != -1) {
                return fileName.substring(0, lastDotIndex);
            } else {
                return fileName;
            }
        }
        return null;
    }

    // Lấy image có đuôi mở rộng
    public static String getImageNameExtension(String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            File file = new File(imagePath);
            String fileName = file.getName();
            return fileName;
        }
        return null;
    }

    // Xóa ảnh từ thư mục image
    public static void deleteImage(String imageName) {
        if (imageName != null && !imageName.isEmpty()) {
            File imageFile = new File(imageFolderPath + imageName);
            if (imageFile.exists()) {
                if (imageFile.delete()) {
                    System.out.println("File " + imageName + " deleted successfully.");
                } else {
                    System.out.println("Failed to delete file " + imageName);
                }
            } else {
                System.out.println("File " + imageName + " does not exist.");
            }
        } else {
            System.out.println("Invalid image name.");
        }
    }

    // Lấy IconImage từ tên image có đuôi dạng ảnh như .jpg
    public static ImageIcon getImage(String imageName) {

        if (imageName != null && !"".equals(imageName)) {
            try {
                File file = new File(getImagePath(imageName));
                BufferedImage originalImage = ImageIO.read(file);                
                // Thay đổi kích thước ảnh
                BufferedImage resizedImage = resizeImage(originalImage, 284, 177);
                return new ImageIcon(resizedImage);
            } catch (IOException ex) {
                Logger.getLogger(GoodReciptController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    // Thay đổi kích thước ảnh
    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, originalImage.getType());
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g2d.dispose();
        return resizedImage;
    }
}

