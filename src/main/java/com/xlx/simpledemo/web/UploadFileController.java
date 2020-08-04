//package com.xlx.simpledemo.web;
//
//import com.pagoda.fastdfs.core.FastDfsService;
//import com.pagoda.fastdfs.dto.enums.FileUploadTypeEnum;
//import com.pagoda.fastdfs.dto.enums.StoreServeTypeEnum;
//import com.pagoda.fastdfs.dto.input.FileUploadInput;
//import com.pagoda.fastdfs.dto.input.ImageMergeInput;
//import com.pagoda.fastdfs.dto.input.UploadChunkFileInput;
//import com.pagoda.fastdfs.dto.output.DownloadFileOutput;
//import com.pagoda.fastdfs.dto.output.FileUploadOutput;
//import com.pagoda.platform.service.ApiResult;
//import org.apache.commons.io.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.net.URLEncoder;
//
///**
// * @Author xieluxin
// * @Date 2020/4/10 14:23
// * @Version 1.0
// */
//@RestController
//@RequestMapping("/ms-fastdfs")
//public class UploadFileController {
//    @Autowired
//    private FastDfsService fastDfsService;
//
//    /**
//     * 上传文件
//     *
//     * @param file
//     * @return
//     */
//    @RequestMapping(value = "/commonUpload", method = RequestMethod.POST)
//    public ApiResult fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
//
//        FileUploadInput fileUploadInput = new FileUploadInput();
//        fileUploadInput.setInputStream(file.getInputStream());
//        fileUploadInput.setFileName(file.getOriginalFilename());
//        fileUploadInput.setFileSize(file.getSize());
//        fileUploadInput.setFileUploadType(FileUploadTypeEnum.COMMON);
//        fileUploadInput.setStoreServeType(StoreServeTypeEnum.TENCENT_COS.getCode());
//        fileUploadInput.setSubDirectory("test111/test222");
//        FileUploadOutput uploadOutput = fastDfsService.uploadFile(fileUploadInput);
//        return ApiResult.success(uploadOutput);
//    }
//
//    /**
//     * 删除文件
//     *
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public ApiResult fileDelete(@RequestParam(value = "fileInfoId", required = true) String fileInfoId,
//                                HttpServletRequest request) {
//
//        Boolean aBoolean = fastDfsService.deleteFile(fileInfoId);
//        return ApiResult.success(aBoolean);
//    }
//
//    /**
//     * 图片合成
//     *
//     * @param mergeInput 入参模型
//     * @return
//     */
//    @RequestMapping(value = "/imageMerge", method = RequestMethod.POST)
//    public ApiResult imageMerge(@RequestBody ImageMergeInput mergeInput) {
//        FileUploadOutput uploadOutput = fastDfsService.imageMerge(mergeInput);
//        return ApiResult.success(uploadOutput);
//    }
//
//    /**
//     * 文件下载
//     *
//     * @param fileInfoId 文件id
//     */
//    @RequestMapping(value = "/fileDownload", method = RequestMethod.GET)
//    public void fileDownload(String fileInfoId, HttpServletResponse response) throws IOException {
//
//        DownloadFileOutput output = fastDfsService.downloadFile(fileInfoId);
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(output.getFileName(), "UTF-8"));
//        response.setHeader("Content-Type", "image/jpeg;charset=UTF-8");
//        ServletOutputStream outputStream = response.getOutputStream();
//        IOUtils.copy(output.getInputStream(), outputStream);
//    }
//
//    /**
//     * 分块上传文件
//     *
//     * @param file
//     * @return
//     */
//    @RequestMapping(value = "/chunkUpload", method = RequestMethod.POST)
//    public ApiResult chunkUpload(@RequestParam("file") MultipartFile file) throws IOException {
//        UploadChunkFileInput fileInput = new UploadChunkFileInput();
//        fileInput.setFileData(file.getBytes());
//        fileInput.setFileName(file.getOriginalFilename());
//        fileInput.setChunkSize( 1024* 1024 );
//
//        FileUploadOutput uploadOutput = fastDfsService.chunkUploadFile(fileInput);
//        return ApiResult.success(uploadOutput);
//    }
//}