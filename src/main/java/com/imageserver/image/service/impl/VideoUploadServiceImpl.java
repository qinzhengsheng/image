package com.imageserver.image.service.impl;

import com.imageserver.image.bean.VideoBean;
import com.imageserver.image.common.CommonConstant;
import com.imageserver.image.service.VideoUploadService;
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
        String fileName = multipartFile.getName() + "_" + System.currentTimeMillis();
        File file=new File(tempPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File targetFile = new File(tempPath, fileName);
        multipartFile.transferTo(targetFile);
        videoBean.setVideoPath(tempPath+fileName);


    }



}