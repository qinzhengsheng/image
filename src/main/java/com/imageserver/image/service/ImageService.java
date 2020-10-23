package com.imageserver.image.service;

import com.imageserver.image.bean.ImageBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author qinzhengsheng
 * @{USER}
 * @{DATE}
 * @{DESC} 图片服务业务层
 */
public interface ImageService {

    /**
     * 图片处理
     * @param file
     * @param wide
     * @param high
     * @param imageBean
     * @throws IOException
     * @return
     */
    void uploadFile(MultipartFile file, Integer wide, Integer high, ImageBean imageBean) throws IOException;



}