package com.ht.controller;

import com.ht.mapping.ControllerResult;
import com.ht.common.PathUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/upload")
public class UploadController {

    @GetMapping("up_page")
    public String upPage(){
        return "upload";
    }

    /**
     * 上传图片
     * */
    @PostMapping("up")
    @ResponseBody
    public ControllerResult upload(MultipartFile file, HttpServletRequest request) {
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(PathUtils.uploadDir(request) + "/" + file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getOriginalFilename());
        return ControllerResult.getSuccessResult("上传成功");
    }

    /**
     * 下载图片
     * */
    @PostMapping("download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("filename") String filename,@RequestParam("filepath") String paths) throws IOException {
        //下载文件路径
        File file = new File(paths);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文乱码的问题
        String downloadFileName = new String(filename.getBytes("utf-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment",downloadFileName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity <byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }

}
