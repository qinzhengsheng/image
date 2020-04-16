package com.imageserver.image.service.impl;

import com.imageserver.image.bean.FileBean;
import com.imageserver.image.common.CommonConstant;
import com.imageserver.image.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/16
 * @DESC 文件上传业务类
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {


    @Override
    public void uploadFile(MultipartFile multipartFile, FileBean fileBean) throws IOException {
        Calendar instance = Calendar.getInstance();
        String tempPath = CommonConstant.FILEPATH + instance.get(Calendar.YEAR) + "-" + instance.get(Calendar.MONTH) + "-" + instance.get(Calendar.DAY_OF_MONTH);
        String fileName = multipartFile.getName() + "_" + System.currentTimeMillis();
        File file=new File(tempPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File targetFile = new File(tempPath, fileName);
        multipartFile.transferTo(targetFile);
        fileBean.setFilePath(tempPath+fileName);
    }



}