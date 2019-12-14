package cn.zhd.springboot.api;


import cn.zhd.springboot.entity.Article;
import cn.zhd.springboot.entity.Directory;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.ArticleService;

import cn.zhd.springboot.service.DirectoryService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/cloud")
@RestController
public class CloudApi {

    public final DirectoryService directoryService;

    @Autowired
    public CloudApi(DirectoryService directoryService)
    {
        this.directoryService = directoryService;
    }

    @RequestMapping("/get_directory")
    public Msg<Object> getDirector(Integer userId)
    {
        String path = directoryService.getDirectory(userId);
        System.out.println(path);
        if(path!=null)
        {
            return ResultUtil.success(path);
        }
        else {
            return ResultUtil.error(ResultEnum.Cloud_GET_ERROR);
        }

    }

    @RequestMapping("/save_directory")
    public Msg<Object> saveDirector(String jsonpObject, Integer directoryId)
    {
        Directory directory = new Directory();
        directory.setDirectoryId(directoryId);
        directory.setDirectoryContent(jsonpObject);
        if(directoryService.saveDirectory(directory))
        {
            return ResultUtil.success();
        }else{
            return  ResultUtil.error(ResultEnum.Cloud_SAVE_ERROR);
        }
    }

    @RequestMapping("aaa")
    public void roomAdd(HttpServletRequest request)
    {
        System.out.println(123);
        MultipartHttpServletRequest multipart  = (MultipartHttpServletRequest) request;
        return;
    }



    @RequestMapping("download")
    public String getDownload(HttpServletRequest request, HttpServletResponse response,String name)
    {
        String fileName = name;// 文件名
        if (fileName != null) {
            //设置文件路径
            File file = new File("E:/fileUpload/"+name);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
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
                    return "下载成功";
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
        return "下载失败";
    }

    @PostMapping("uploadFile")
    @ResponseBody
    public void getUpload(MultipartFile file)
    {

        System.out.print("上传文件==="+"\n");
        //判断文件是否为空
        if (file.isEmpty()) {
            System.out.print("文件为空"+"\n");
            return;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        String fileName0 = file.getOriginalFilename();
        System.out.println(fileName);
        System.out.println(fileName0);
        System.out.print("上传的文件名为: "+fileName+"\n");

        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: "+fileName+"\n");


        //加个时间戳，尽量避免文件名称重复
        String path = "E:/fileUpload/" +fileName;
        //String path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        //文件绝对路径
        System.out.print("保存文件绝对路径"+path+"\n");

        //创建文件路径
        File dest = new File(path);

        //判断文件是否已经存在
        if (dest.exists()) {
            System.out.print("文件已经存在==="+"\n");
            return;
        }

        //判断文件父目录是否存在
        //
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            //上传文件
            file.transferTo(dest); //保存文件
            System.out.print("保存文件路径"+path+"\n");

        } catch (IOException e) {
            System.out.println("上传失败");
            return;
        }
        System.out.println("上传成功");
        return;
    }

    @RequestMapping("start")
    public void getstart(){
        try {
            System.out.println("asdasd");
            Process process = Runtime.getRuntime().exec("java -jar C:/Users/a1191/Desktop/kiftd/kiftd-1.0.26-RELEASE.jar -console");
            //以独立的线程实时监控该进程输出信息
            System.out.println("2");
            System.out.println(process);
            Thread t = new Thread(() -> {
                System.out.println("3");
                System.out.println(process.getOutputStream());
                PrintWriter writer = new PrintWriter(process.getOutputStream());//使用process对象得到输出流并生成一个PrintWriter。
                System.out.println(writer);
                writer.println("-start");
                writer.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                System.out.println(reader);
                String line = null;
                try {
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);//实时打印进程的返回信息，您可以根据这个信息判断kiftd的运行状态
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t.start();
            //...
        } catch (Exception e) {
            //...
        }

    }
}
