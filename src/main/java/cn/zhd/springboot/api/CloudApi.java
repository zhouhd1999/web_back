package cn.zhd.springboot.api;


import cn.zhd.springboot.entity.Article;
import cn.zhd.springboot.entity.Directory;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.ArticleService;

import cn.zhd.springboot.service.CloudService;
import cn.zhd.springboot.service.DirectoryService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.deploy.net.URLEncoder;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RequestMapping("/cloud")
@RestController
public class CloudApi {

    private final DirectoryService directoryService;
    private final CloudService cloudService;
    @Autowired
    public CloudApi(DirectoryService directoryService, CloudService cloudService)
    {
        this.directoryService = directoryService;
        this.cloudService = cloudService;
    }

    @RequestMapping("/get_directory")
    public Msg<Object> getDirector(Integer userId)
    {
        Directory directory = directoryService.getDirectory(userId);
        System.out.println(directory);
        if(directory!=null)
        {
            return ResultUtil.success(directory);
        }
        else {
            return ResultUtil.error(ResultEnum.CLOUD_GET_ERROR);
        }

    }

    @RequestMapping("/save_directory")
    public Msg<Object> saveDirector(String dirContent, Integer directoryId,Integer countId)
    {
        Directory directory = new Directory();
        directory.setDirectoryId(directoryId);
        directory.setCountId(countId);
        directory.setDirectoryContent(dirContent);
        if(directoryService.saveDirectory(directory))
        {
            return ResultUtil.success();
        }else{
            return  ResultUtil.error(ResultEnum.CLOUD_SAVE_ERROR);
        }
    }



    @RequestMapping("download")
    public void getDownload(HttpServletRequest request, HttpServletResponse response, String name) throws UnsupportedEncodingException {
        String fileName = name;// 文件名
        if (fileName != null) {
            //设置文件路径
            File file = new File("E:/fileUpload/"+name);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                response.setCharacterEncoding("UTF-8");

                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @PostMapping("uploadFile")
    @ResponseBody
    public Msg<Object> getUpload(MultipartFile file)
    {
        Directory directory = new Directory();
//        directory.setDirectoryId(directoryId);
//        directory.setDirectoryContent(dirContent);

        if(cloudService.getUpload(file,directory))
        {
            return ResultUtil.success();
        }
        else
        {
            return ResultUtil.error(ResultEnum.CLOUD_UPLOAD_ERROR);
        }
    }
}
