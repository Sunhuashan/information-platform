package com.shs.bysj.controller;

import com.shs.bysj.exception.FilenameExistException;
import com.shs.bysj.pojo.MyFile;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IMyFileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/5/1 16:29
 */
@CrossOrigin
@RestController
public class MyFileController {
    @Autowired
    IMyFileService myFileService;

    @ResponseBody
    @PostMapping(value = "/api/home/uploadFile")
    public Result uploadFile(
            @RequestParam(value = "file") MultipartFile file,
                             @RequestParam(value = "username") String uploadName) {
        try {
            myFileService.uploadFile(file,uploadName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("服务器异常，请重试");
        } catch (FilenameExistException e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("文件名已存在，请更改后重试");
        }
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @GetMapping(value = "/api/home/findAllFile")
    public Result findAllFileByState() {
        List<MyFile> list = myFileService.findAllFileByState();
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PostMapping(value = "/api/home/download")
    public void downloadFile(
            @RequestBody String fileJSON,
                               HttpServletRequest request,
            HttpServletResponse response) {
        //字符串截取
        String filename = fileJSON;
        System.out.println(filename);

        OutputStream os = null;
        InputStream is = null;
        try {
            // 获取输出流
            os = response.getOutputStream();

            // 清空输出流
            response.reset();

            // 设置response
            response.setContentType("application/octet-stream"); //文件类型
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);

            // 获取输入流
            File f = new File("E:/zip",filename);
            if (!f.exists()) {
                return;
            }
            is = new FileInputStream(f);

            // 复制进入输出流
            IOUtils.copy(is, os);
            os.flush();
            System.out.println(filename);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (os != null){
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
