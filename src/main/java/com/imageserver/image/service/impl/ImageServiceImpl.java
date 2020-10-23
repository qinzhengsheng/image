package com.imageserver.image.service.impl;

import com.imageserver.image.bean.ImageBean;
import com.imageserver.image.common.CommonConstant;
import com.imageserver.image.service.ImageService;
import com.imageserver.image.util.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author qinzhengsheng
 * 2020/4/8
 * 图片服务业务实现
 */
@Service
public class ImageServiceImpl implements ImageService {


    @Override
    public void uploadFile(MultipartFile file, Integer wide, Integer high, ImageBean imageBean) throws IOException {
        Calendar instance = Calendar.getInstance();
        String tempPath = CommonConstant.IMAGEPATH + instance.get(Calendar.YEAR) + "-" + instance.get(Calendar.MONTH) + "-" + instance.get(Calendar.DAY_OF_MONTH);
        File file1 = new File(tempPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        File targetFile = new File(tempPath, imageBean.getImageName());
        file.transferTo(targetFile);
        imageBean.setSourceUrl(tempPath + "/" + imageBean.getImageName());
        if (wide != null && high != null) {
            imageBean.setAfterProcessingUrl(tempPath + "/scale_" + imageBean.getImageName());
            ImageUtils.scale2(imageBean.getSourceUrl(), imageBean.getAfterProcessingUrl(), high, wide, true);
        }
    }


}