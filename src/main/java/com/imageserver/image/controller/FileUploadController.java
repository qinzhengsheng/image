package com.imageserver.image.controller;

import com.imageserver.image.bean.FileBean;
import com.imageserver.image.common.ResultBody;
import com.imageserver.image.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinzhengsheng
 * @{USER}
 * @{DATE}
 * @{DESC} 文件上传管理
 */
@RestController("files")
@Slf4j
@Api(value = "文件上传接口", tags = {"文件控制器"})
@RequestMapping("file")
public class FileUploadController extends BaseController {


    @Autowired
    private FileUploadService fileUploadService;


    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("uploadFile")
    @ApiOperation(value = "文件上传", notes = "文件上传", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "文件数据", name = "file", required = true)
    })
    public ResultBody uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return error("文件上传失败，未收到文件！请重新上传");
        }
        String originalFilename = file.getOriginalFilename();
        FileBean fileBean = new FileBean();
        fileBean.setFileName(originalFilename);
        fileBean.setSize(file.getSize());
        fileBean.setFileType(originalFilename.substring(originalFilename.lastIndexOf(".")));
        try {
            fileUploadService.uploadFile(file, fileBean);
            return success(fileBean);
        } catch (Exception e) {
            log.error("文件上传出差，出错消息：" + e.getMessage());
            return error(e.getMessage());
        }
    }

    /**
     * 文件上传
     *
     * @param files
     * @return
     */
    @PostMapping("uploadFiles")
    @ApiOperation(value = "文件上传", notes = "文件上传", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "文件数据", name = "files", required = true)
    })
    public ResultBody uploadFiles(MultipartFile[] files) {
        List<FileBean> fileBeanList = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                String originalFilename = file.getOriginalFilename();
                FileBean fileBean = new FileBean();
                fileBean.setFileName(originalFilename);
                fileBean.setSize(file.getSize());
                fileBean.setFileType(originalFilename.substring(originalFilename.lastIndexOf(".")));
                fileUploadService.uploadFile(file, fileBean);
                fileBeanList.add(fileBean);
            }
            return success(fileBeanList);
        } catch (Exception e) {
            log.error("文件上传出差，出错消息：" + e.getMessage());
            return error(e.getMessage());
        }
    }


}