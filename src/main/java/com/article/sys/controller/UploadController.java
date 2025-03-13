package com.article.sys.controller;

import com.article.sys.util.LayuiData;
import com.article.sys.util.SYS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class UploadController {
    @RequestMapping("upload")
    @ResponseBody
    public LayuiData upload(@RequestParam("file") MultipartFile file) {
        //获取后缀，
        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        // 重新命名，名字尽量不重复
        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + fileType;

        try {
            //将上传的文件写入到新文件中
            file.transferTo(new File(SYS.FILE_UPLOAD_DIR + newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //将上传的文件写入到新文件中，
        // 返回结果
        return new LayuiData(SYS.FILE_UPLOAD_URL+"/"+newFileName);
    }


}
