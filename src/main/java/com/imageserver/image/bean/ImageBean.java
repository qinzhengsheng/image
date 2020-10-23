package com.imageserver.image.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/10
 * @DESC 图片实体类
 */
@Data
@ApiModel(value = "ImageBean", description = "图片实体类")
public class ImageBean implements Serializable {


    @ApiModelProperty(value = "图片名", name = "imageName")
    private String imageName;
    @ApiModelProperty(value = "图片类型", name = "imageType")
    private String imageType;
    @ApiModelProperty(value = "图片源文件路径", name = "sourceUrl")
    private String sourceUrl;
    @ApiModelProperty(value = "处理后图片路径", name = "afterProcessingUrl")
    private String afterProcessingUrl;
    @ApiModelProperty(value = "图片大小", name = "size")
    private Long size;


}