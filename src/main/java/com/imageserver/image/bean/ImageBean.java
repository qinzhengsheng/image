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
    @ApiModelProperty(value = "小图路径", name = "minUrl")
    private String minUrl;
    @ApiModelProperty(value = "大图路径", name = "maxUrl")
    private String maxUrl;
    @ApiModelProperty(value = "图片大小", name = "size")
    private Integer size;


}