package com.imageserver.image.controller;

import com.imageserver.image.bean.VideoBean;
import com.imageserver.image.common.ResultBody;
import com.imageserver.image.service.VideoUploadService;
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

/**
 * @author qinzhengsheng
 * @{USER}
 * @{DATE}
 * @{DESC} 音视频上传管理
 */
@RestController("video")
@Slf4j
@Api(value = "音视频上传接口", tags = {"音视频控制器"})
@RequestMapping("video")
public class VideoUploadController extends BaseController {

    @Autowired
    private VideoUploadService videoUploadService;

    /**
     * 音视频上传
     *
     * @param file
     * @return
     */
    @PostMapping("uploadVideo")
    @ApiOperation(value = "音视频上传", httpMethod = "POST", notes = "音视频上传")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "音视频数据", name = "file", required = true)
    })
    public ResultBody uploadVideo(MultipartFile file) {
        if (file.isEmpty()) {
            return error("音视频上传失败！请重新上传");
        }
        String originalFilename = file.getOriginalFilename();
        VideoBean videoBean = new VideoBean();
        videoBean.setSize(file.getSize());
        videoBean.setVideoName(originalFilename);
        videoBean.setVideoType(originalFilename.substring(originalFilename.lastIndexOf(".")));
        try {
            videoUploadService.uploadVideo(file, videoBean);
            return success(videoBean);
        } catch (Exception e) {
            log.error("音视频上传失败，错误信息：" + e.getMessage());
            return error(e.getMessage());
        }
    }


}