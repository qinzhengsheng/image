package com.imageserver.image.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/10
 * @DESC 音视频实体类
 */
@Data
@ApiModel(value = "VideoBean", description = "音视频实体类")
public class VideoBean implements Serializable {

    @ApiModelProperty(value = "音视频地址", name = "videoPath")
    private String videoPath;
    @ApiModelProperty(value = "音视频大小", name = "size")
    private Integer size;
    @ApiModelProperty(value = "音视频类型", name = "videoType")
    private String videoType;
    @ApiModelProperty(value = "视频封面地址", name = "frontCover")
    private String frontCover;


}