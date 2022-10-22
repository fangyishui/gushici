package org.gushi.gushici.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

/**
 * Author: fang
 * Date:   2022-02-24 16:10 星期四
 * Class:  TestController
 **/
@Controller
public class TestController {

    @RequestMapping("/upload")
    public String uploadPage(){
        return "upload.html";
    }
    @RequestMapping("/uploadFile")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "C://temp//";
        File dest = new File(filePath + fileName);
        if (!dest.exists()){
            dest.mkdirs();
        }
        try {
            file.transferTo(dest);
//            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
//            LOGGER.error(e.toString(), e);
            e.printStackTrace();
        }
        return "上传失败！";
    }


}
