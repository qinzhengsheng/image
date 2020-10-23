package com.imageserver.image.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/10
 * @DESC 文件实体类
 */
@Data
@ApiModel(value = "FileBean", description = "文件实体类")
public class FileBean implements Serializable {


    @ApiModelProperty(value = "文件名", name = "fileName")
    private String fileName;
    @ApiModelProperty(value = "文件类型", name = "fileType")
    private String fileType;
    @ApiModelProperty(value = "文件路径", name = "filePath")
    private String filePath;
    @ApiModelProperty(value = "文件大小", name = "size")
    private Long size;


}