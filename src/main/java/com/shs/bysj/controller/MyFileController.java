package com.shs.bysj.controller;

import com.shs.bysj.exception.FileNotExistException;
import com.shs.bysj.exception.FilenameExistException;
import com.shs.bysj.pojo.MyFile;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IMyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @GetMapping(value = "/api/home/findAllFileByState")
    public Result findAllFileByState() {
        List<MyFile> list = myFileService.findAllFileByState();
        return ResultFactory.buildSuccessResult(list);
    }

    @PostMapping(value = "/api/home/download")
    public void downloadFile(
            @RequestBody MyFile file,
            HttpServletResponse response) {
        //获取文件名
        String filename = file.getName();

        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            // 获取输入流
            File f = new File("E:/zip",filename);
            if (!f.exists()) {
                throw new FileNotExistException("文件不存在");
            }

            // 获取输出流
            os = response.getOutputStream();

            // 设置response
            response.setContentType("application/octet-stream;charset=UTF-8"); //文件类型
            response.setCharacterEncoding("UTF-8");

            // 复制进入输出流
            bis = new BufferedInputStream(new FileInputStream(f));
            byte[] buff = new byte[bis.available()];

            bis.read(buff);

            os.write(buff);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
                if (os != null) {
                    os.flush();
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/updateFileState")
    public Result updateFileState(@RequestBody MyFile myFile) {
        myFileService.updateFileState(myFile);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @GetMapping(value = "/api/admin/findAllFile")
    public Result FindAllFile() {
        List<MyFile> list = myFileService.findAllFile();
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/addCheckInfo")
    public Result addCheckInfo(@RequestBody MyFile myFile) {
        myFileService.addCheckInfo(myFile);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/deleteFile")
    public Result deleteFileById(@RequestBody MyFile myFile) {
        myFileService.deleteFileById(myFile.getId());
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @PostMapping(value = "/api/home/files")
    public Result findAllbyUploadName(@RequestBody MyFile myFile) {
        String uploadName = myFile.getUploadName();
        List<MyFile> list = myFileService.findAllByName(uploadName);
        return ResultFactory.buildSuccessResult(list);
    }
}

