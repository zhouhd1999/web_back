package cn.zhd.springboot.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;

public class FileSaveUtil {
    public static boolean filesave(MultipartFile file,String path)
    {
        String fileName = file.getOriginalFilename();
        String filePath = path + fileName;
        System.out.println(filePath);
        File dest = new File(filePath);
        try{
            file.transferTo(dest);

        }catch (Exception e)
        {
            System.out.println("上传失败");
            return false;
        }
        System.out.println("上传成功");
        return true;
    }
}
