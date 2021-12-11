package com.aaa.edu.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.aaa.edu.pojo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/files")
public class FileController {
    @ApiOperation("普通上传")
    @PostMapping("upload")
    public RespBean upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String rootFilePath = System.getProperty("user.dir")+"/src/main/resources/files/"+originalFilename;

        FileUtil.writeBytes(file.getBytes(),rootFilePath);
        log.info(rootFilePath);
//        file.transferTo(Paths.get(rootFilePath));
        return RespBean.success("上传成功","http://localhost:8888/files/"+originalFilename);
    }
    @ApiOperation("头像上传")
    @PostMapping("/avatar")
    public RespBean uploadAvatar(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String rootFilePath = System.getProperty("user.dir")+"/src/main/resources/files/avatar/"+originalFilename;

        FileUtil.writeBytes(file.getBytes(),rootFilePath);
        log.info(rootFilePath);
//        file.transferTo(Paths.get(rootFilePath));
        return RespBean.success("上传成功","http://localhost:8888/files/avatar/"+originalFilename);
    }
    @ApiOperation("头像下载")
    @GetMapping("/avatar/{flag}")
    public void getAvatar(@PathVariable String flag, HttpServletResponse response) {
        OutputStream os;  // 新建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/src/main/resources/files/avatar/";  // 定于文件上传的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath);  // 获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");  // 找到跟参数一致的文件
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);  // 通过文件的路径读取文件字节流
                os = response.getOutputStream();   // 通过输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }
    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response) {
        OutputStream os;  // 新建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/src/main/resources/files/";  // 定于文件上传的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath);  // 获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");  // 找到跟参数一致的文件
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);  // 通过文件的路径读取文件字节流
                os = response.getOutputStream();   // 通过输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }
    @ApiOperation("生产环境")
    @PostMapping("upload2")
    public RespBean upload2(MultipartFile file, HttpSession session) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String hzName= originalFilename.substring(originalFilename.lastIndexOf("."));

        String fileName=UUID.randomUUID()+hzName;

//        String rootFilePath = session.getServletContext().getRealPath("files")+fileName;
//        UUID.randomUUID()
        String rootFilePath = System.getProperty("user.dir")+"/src/main/resources/files/"+fileName;

//        FileUtil.writeBytes(file.getBytes(),rootFilePath);
        log.info(rootFilePath);
        file.transferTo(Paths.get(rootFilePath));
        return RespBean.success("上传成功");
    }

    @ApiOperation("上传重命名")
    @PostMapping("upload3")
    public RespBean upload3(MultipartFile file, HttpSession session) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String hzName= originalFilename.substring(originalFilename.lastIndexOf("."));

        String fileName=UUID.randomUUID()+"";

        String rootFilePath = System.getProperty("user.dir")+"/src/main/resources/files/"+fileName+hzName;

        log.info(rootFilePath);
        file.transferTo(Paths.get(rootFilePath));
        return RespBean.success("上传成功","http://localhost:8888/files/"+fileName);
    }
}
