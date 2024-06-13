package raven.application.form;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import helper.processImage.processImage;

public class test {

    private String dir = System.getProperty("user.dir");
    private String imageFolderPath = dir + "\\src\\image\\";
    
     // Di chuyển image vào bên trong thư mục image của dự án
    public void moveImage(String rootImagePath) {
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
                    String fileNameWithoutExtension = rootImageName.substring(0, rootImageName.lastIndexOf('.'));
                    System.out.println(fileNameWithoutExtension);
                    String fileExtension = rootImageName.substring(rootImageName.lastIndexOf('.'));
                    System.out.println(fileExtension);

                    do {
                        newFileName = fileNameWithoutExtension + "_" + count + fileExtension;
                        newFile = new File(imageFolderPath + newFileName);
                        count++;
                    } while (newFile.exists());

                    // Di chuyển file với tên mới
                    Files.copy(new File(rootImagePath).toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } else {
                    // Nếu file không tồn tại, di chuyển file vào thư mục image
                    Files.copy(new File(rootImagePath).toPath(), tempImageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Lấy image từ thư mục image
    public String getImage(String imageName) {
        if (imageName != null && !imageName.isEmpty()) {
            File f = new File(imageFolderPath + imageName);
            if (f.exists()) {
                return f.getAbsolutePath();
            }
        }
        return null;
    }
    
    
    public void deleteImage(String imageName) {
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

    public static void main(String[] args) {
        // Tạo một đối tượng của lớp Test
        test test = new test();
        
        // Chuỗi ví dụ cho rootImagePath
//        String rootImagePath = "C:\\Users\\ndchi\\Downloads\\login_thumb.jpg";
//        
//        // Gọi phương thức moveImage với chuỗi rootImagePath
//        test.moveImage(rootImagePath);

           test.deleteImage("login_thumb.jpg");
        
//        if(test.getImage("login_thumb.jpg") != null){
//            System.out.println("Tồn tại");
//            System.out.println(test.getImage("login_thumb.jpg"));
//        }
//        else{
//            System.out.println("Không tồn tại");
//        }
    }
}
