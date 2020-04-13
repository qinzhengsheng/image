package com.imageserver.image.controller;

import com.imageserver.image.common.ResultBody;
import com.imageserver.image.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author qinzhengsheng
 * @ImageController
 * @2020/3/24
 * 图片上传管理
 */
@RestController("image")
@Slf4j
@Api(value = "图片上传接口", tags = {"图片控制器"})
@RequestMapping("/image")
public class ImageController extends BaseController {


    @Autowired
    private ImageService imageService;

    /**
     * 单图片上传
     * @return
     */
    @PostMapping("file")
    @ApiOperation(value = "单图片上传", notes = "单图片上传", httpMethod = "POST")
    public ResultBody uploadFile(MultipartFile file) {
        return success();
    }

    /**
     * 多图片上传
     * @return
     */
    @PostMapping("files")
    @ApiOperation(value = "多图片上传", notes = "多图片上传", httpMethod = "POST")
    public ResultBody uploadFiles(MultipartFile[] file) {
        return success();
    }


}