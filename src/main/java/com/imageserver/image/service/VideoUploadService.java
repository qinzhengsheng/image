package com.imageserver.image.service;

import com.imageserver.image.bean.VideoBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/16
 * @DESC 音视频上传业务层
 */
public interface VideoUploadService {

    /**
     * 音视频处理
     * @param multipartFile
     * @param videoBean
     * @throws IOException
     */
    void uploadVideo(MultipartFile multipartFile, VideoBean videoBean) throws IOException;


}