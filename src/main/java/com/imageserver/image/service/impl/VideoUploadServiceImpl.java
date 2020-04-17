package com.imageserver.image.service.impl;

import com.imageserver.image.bean.VideoBean;
import com.imageserver.image.common.CommonConstant;
import com.imageserver.image.service.VideoUploadService;
import com.imageserver.image.util.VideoUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/16
 * @DESC 音视频业务类
 */
@Service
public class VideoUploadServiceImpl implements VideoUploadService {


    @Override
    public void uploadVideo(MultipartFile multipartFile, VideoBean videoBean) throws IOException {
        Calendar instance = Calendar.getInstance();
        String tempPath = CommonConstant.VIDEOPATH + instance.get(Calendar.YEAR) + "-" + instance.get(Calendar.MONTH) + "-" + instance.get(Calendar.DAY_OF_MONTH);
        File file=new File(tempPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File targetFile = new File(tempPath, videoBean.getVideoName());
        multipartFile.transferTo(targetFile);
        videoBean.setVideoPath(tempPath+"/"+videoBean.getVideoName());
        videoBean.setDuration(VideoUtils.getVideoDuration(targetFile.getAbsolutePath()));
        if (videoBean.getVideoType().equalsIgnoreCase(CommonConstant.VIDEO_TYPE_AVI) || videoBean.getVideoType().equalsIgnoreCase(CommonConstant.VIDEO_TYPE_M4V)||videoBean.getVideoType().equalsIgnoreCase(CommonConstant.VIDEO_TYPE_MOV)||videoBean.getVideoType().equalsIgnoreCase(CommonConstant.VIDEO_TYPE_MP4)||videoBean.getVideoType().equalsIgnoreCase(CommonConstant.VIDEO_TYPE_WMV)||videoBean.getVideoType().equalsIgnoreCase(CommonConstant.VIDEO_TYPE_RM)||videoBean.getVideoType().equalsIgnoreCase(CommonConstant.VIDEO_TYPE_RMVB)) {
            videoBean.setFrontCover(tempPath+"/pic_"+videoBean.getVideoName());
            VideoUtils.getVideoPic(targetFile.getAbsolutePath(), videoBean.getFrontCover());
        }
    }



}