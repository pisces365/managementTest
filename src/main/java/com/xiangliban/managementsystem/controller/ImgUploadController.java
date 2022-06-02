package com.xiangliban.managementsystem.controller;

import com.xiangliban.managementsystem.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/09/13:41
 * @Description:
 */

@Api(tags = "图片上传类")
@RestController
public class ImgUploadController {
    @ApiOperation("图片上传")
    @CrossOrigin
    @PostMapping("api/imgUpload")
    public String coversUpload(@RequestBody MultipartFile file) throws Exception {
        String folder = "/www/wwwroot/managementsystem_springboot/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(12) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            String imgURL = "http://112.124.35.32:8081/xiangliban/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "" + e;
        }
    }

}
