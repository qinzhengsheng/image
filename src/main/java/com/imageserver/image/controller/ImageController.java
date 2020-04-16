package com.imageserver.image.controller;

import com.imageserver.image.bean.ImageBean;
import com.imageserver.image.common.ResultBody;
import com.imageserver.image.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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
     * @param file
     * @param high
     * @param wide
     * @return
     */
    @PostMapping("file")
    @ApiOperation(value = "单图片上传", notes = "单图片上传", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "图片", name = "file", required = true),
            @ApiImplicitParam(value = "宽（上传后的图片宽）", name = "wide"),
            @ApiImplicitParam(value = "高（上传后的图片高）", name = "high")
    })
    public ResultBody uploadFile(MultipartFile file, Integer wide, Integer high) {
        if (file.isEmpty()) {
            return error("图片上传失败，未收到图片！请重新上传");
        }
        String originalFilename = file.getOriginalFilename();
        ImageBean imageBean=new ImageBean();
        imageBean.setImageName(originalFilename);
        imageBean.setImageType(originalFilename.substring(originalFilename.lastIndexOf(".")));
        imageBean.setSize(file.getSize());
        try {
            imageService.uploadFile(file, wide, high, imageBean);
            return success(imageBean);
        } catch (Exception e) {
            log.error("图片上传出错，错误消息："+e.getMessage());
            return error(e.getMessage());
        }
    }

    /**
     * 多图片上传
     * @param files
     * @param high
     * @param wide
     * @return
     */
    @PostMapping("files")
    @ApiOperation(value = "多图片上传", notes = "多图片上传", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "图片", name = "files", required = true),
            @ApiImplicitParam(value = "宽（上传后的图片宽）", name = "wide"),
            @ApiImplicitParam(value = "高（上传后的图片高）", name = "high")
    })
    public ResultBody uploadFiles(MultipartFile[] files, Integer wide, Integer high) {
        List<ImageBean> imageBeanList=new ArrayList<>();
        try {
            for (MultipartFile multipartFile:files) {
                String originalFilename = multipartFile.getOriginalFilename();
                ImageBean imageBean=new ImageBean();
                imageBean.setImageName(originalFilename);
                imageBean.setImageType(originalFilename.substring(originalFilename.lastIndexOf(".")));
                imageBean.setSize(multipartFile.getSize());
                imageService.uploadFile(multipartFile, wide, high, imageBean);
                imageBeanList.add(imageBean);
            }
            return success(imageBeanList);
        } catch (Exception e) {
            log.error("图片上传出错，错误消息："+e.getMessage());
            return error(e.getMessage());
        }
    }


}