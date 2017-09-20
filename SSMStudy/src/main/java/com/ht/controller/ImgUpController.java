package com.ht.controller;

import com.ht.FileUpload.PathAutil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by Administrator on 2017/9/10.
 */
@Controller
@RequestMapping("/upImg")
public class ImgUpController {

    @GetMapping("manyImgAdd")
    public String manyImgAdd(){
        return  "manyImgAdd";
    }
    @PostMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws  Exception{
        String newname = getFileName(file.getOriginalFilename());
        FileUtils.copyInputStreamToFile(file.getInputStream(),new File(new PathAutil().getPath(request)+"/",newname));
        return "hellow";
    }

    @GetMapping("ueditor")
    public String ueditor() throws  Exception{
        return "ueditor";
    }
    private synchronized String getFileName(String filename) {
        int position = filename.lastIndexOf(".");
        String ext = filename.substring(position);
        return System.nanoTime() + ext;
    }

}
