package com.imageserver.image.controller;

import com.imageserver.image.service.ImageService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinzhengsheng
 * @ImageController
 * @2020/3/24
 * 图片上传管理
 */
@RestController("image")
@Slf4j
@Api(value = "图片上传接口", tags = {"图片控制器"})
public class ImageController {


    @Autowired
    private ImageService imageService;





}