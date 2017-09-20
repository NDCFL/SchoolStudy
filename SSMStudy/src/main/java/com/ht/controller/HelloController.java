package com.ht.controller;

import com.ht.FileUpload.PathAutil;
import com.ht.pojo.Message;
import com.ht.pojo.Student;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5.
 */
@Controller
@RequestMapping("/first")
public class HelloController {
    @RequestMapping(value="/hellow")
    public String hellow(HttpServletResponse response){
        response.addCookie(new Cookie("key","I am cookie"));
        return "hellow";
    }
   @RequestMapping("/cookie")
    public ModelAndView cookie(@CookieValue("key") String key){
       ModelAndView modelAndView = new ModelAndView();
       System.out.println("cookie="+key);
       modelAndView.setViewName("cookie");
       modelAndView.addObject("key",key);
       return modelAndView;
    }
    @GetMapping("json")
    @ResponseBody
    public Student jsonStudent() throws  Exception{
        Student student = new Student();
        student.setId("11");
        student.setName("李四");
        return student;
    }
    @PostMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws  Exception{
        String newname = getFileName(file.getOriginalFilename());
        FileUtils.copyInputStreamToFile(file.getInputStream(),new File(new PathAutil().getPath(request)+"/",newname));
        return "hello";
    }
    private synchronized String getFileName(String filename) {
        int position = filename.lastIndexOf(".");
        String ext = filename.substring(position);
        return System.nanoTime() + ext;
    }
    @RequestMapping("fileList")
    public ModelAndView fileList(HttpServletRequest request) throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        String list[];
        File file = new File(new PathAutil().getPath(request)+"/");
        list = file.list();
        modelAndView.setViewName("down");
        modelAndView.addObject("filelist",list);
        return modelAndView;
    }
    @RequestMapping("/loadFile/{suffix}/{name}")
    public ResponseEntity<byte[]> download(@PathVariable("suffix") String suffix,@PathVariable("name") String name,HttpServletRequest request) throws Exception {
        String filename = name+suffix;
        if(filename==null && "".equals(filename)){
            return null;
        }else{
            File file = new File(new PathAutil().getPath(request)+"/"+filename);
            HttpHeaders headers = new HttpHeaders();
            String fileName=new String(name.getBytes("UTF-8"),"iso-8859-1");
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
        }
    }
}
