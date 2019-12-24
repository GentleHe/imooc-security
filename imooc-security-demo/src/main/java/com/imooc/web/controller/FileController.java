package com.imooc.web.controller;


import com.imooc.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @author 何国锋
 * @date 2019-12-23 21:32
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "E:\\DevelopSoftware\\IntelliJ IDEA 2019.1.1 Workspace\\imooc-security\\imooc-security-demo\\src\\main\\java\\com\\imooc\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println("name: " + file.getName());
        System.out.println("origin name: " + file.getOriginalFilename());
        System.out.println("file size: " + file.getSize());


        File localFile = new File(folder, new Date().getTime()+".txt");
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }


    @GetMapping("/{id:\\d+}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){


        try(
                InputStream inputStream = new FileInputStream(new File(folder, id+".txt"));
                OutputStream outputStream = response.getOutputStream();
        ) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");

            //输入流内容弄到输出流
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
