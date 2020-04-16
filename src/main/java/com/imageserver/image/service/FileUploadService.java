package com.imageserver.image.service;

import com.imageserver.image.bean.FileBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/16
 * @DESC 文件上传业务层
 */
public interface FileUploadService {

    /**
     * 文件上传
     * @param multipartFile
     * @param fileBean
     * @throws IOException
     */
    void uploadFile(MultipartFile multipartFile, FileBean fileBean) throws IOException;

}