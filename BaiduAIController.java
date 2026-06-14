package com.spboot.tx.controller;

import cn.hutool.core.io.FileUtil;
import com.spboot.tx.config.Configure;
import com.spboot.tx.utils.ResponseData;
import com.spboot.tx.utils.baidu.BaiduAIResult;
import com.spboot.tx.utils.baidu.BaiduAIService;
import com.spboot.tx.utils.JsonResult;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 百度图像识别控制器
 */
@RestController
@RequestMapping("/api/baidu/ai")
public class BaiduAIController {

    @Autowired
    private BaiduAIService baiduAIService;

    /**
     * 通用物体识别 - 通过文件上传
     */
    @PostMapping("/generalRecognitionByFile")
    public ResponseData generalRecognitionByFile(@RequestParam("image") MultipartFile image) {
        try {
            if (image.isEmpty()) {
                return JsonResult.error("上传的图片不能为空");
            }

            byte[] imageData = image.getBytes();
            BaiduAIResult result = baiduAIService.generalRecognition(imageData);

            if (result.isSuccess()) {
                return JsonResult.success(result);
            } else {
                return JsonResult.error("识别失败: " + result.getError_msg());
            }
        } catch (IOException e) {
            return JsonResult.error("文件处理异常: " + e.getMessage());
        } catch (Exception e) {
            return JsonResult.error("识别异常: " + e.getMessage());
        }
    }

    /**
     * 通用物体识别 - 通过URL
     */
    @PostMapping("/generalRecognition")
    public ResponseData generalRecognitionByUrl(@RequestParam("image") String imageUrl) {
        try {
            byte[] imageData = downloadImageFromUrl(imageUrl);
            if (imageData == null || imageData.length == 0) {
                return JsonResult.error("下载图片失败");
            }

            BaiduAIResult result = baiduAIService.generalRecognition(imageData);

            if (result.isSuccess()) {
                return JsonResult.success(result);
            } else {
                return JsonResult.error("识别失败: " + result.getError_msg());
            }
        } catch (Exception e) {
            return JsonResult.error("识别异常: " + e.getMessage());
        }
    }

    /**
     * 菜品识别 - 通过文件上传
     */
    @PostMapping("/dishRecognitionByFile")
    public ResponseData dishRecognitionByFile(@RequestParam("image") MultipartFile image) {
        try {
            if (image.isEmpty()) {
                return JsonResult.error("上传的图片不能为空");
            }

            byte[] imageData = image.getBytes();
            BaiduAIResult result = baiduAIService.dishRecognition(imageData);

            if (result.isSuccess()) {
                return JsonResult.success(result);
            } else {
                return JsonResult.error("识别失败: " + result.getError_msg());
            }
        } catch (IOException e) {
            return JsonResult.error("文件处理异常: " + e.getMessage());
        } catch (Exception e) {
            return JsonResult.error("识别异常: " + e.getMessage());
        }
    }

    /**
     * 菜品识别 - 通过URL
     */
    @PostMapping("/dishRecognition")
    public ResponseData dishRecognitionByUrl(@RequestParam("image") String imageUrl) {
        try {
            byte[] imageData = downloadImageFromUrl(imageUrl);
            if (imageData == null || imageData.length == 0) {
                return JsonResult.error("下载图片失败");
            }

            BaiduAIResult result = baiduAIService.dishRecognition(imageData);

            if (result.isSuccess()) {
                return JsonResult.success(result);
            } else {
                return JsonResult.error("识别失败: " + result.getError_msg());
            }
        } catch (Exception e) {
            return JsonResult.error("识别异常: " + e.getMessage());
        }
    }

    /**
     * 植物识别 - 通过文件上传
     */
    @PostMapping("/plantRecognitionByFile")
    public ResponseData plantRecognitionByFile(@RequestParam("image") MultipartFile image) {
        try {
            if (image.isEmpty()) {
                return JsonResult.error("上传的图片不能为空");
            }

            byte[] imageData = image.getBytes();
            BaiduAIResult result = baiduAIService.plantRecognition(imageData);

            if (result.isSuccess()) {
                return JsonResult.success(result);
            } else {
                return JsonResult.error("识别失败: " + result.getError_msg());
            }
        } catch (IOException e) {
            return JsonResult.error("文件处理异常: " + e.getMessage());
        } catch (Exception e) {
            return JsonResult.error("识别异常: " + e.getMessage());
        }
    }

    /**
     * 植物识别 - 通过URL
     */
    @PostMapping("/plantRecognition")
    public ResponseData plantRecognitionByUrl(@RequestParam("image") String imageUrl) {
        try {
            byte[] imageData = downloadImageFromUrl(imageUrl);
            if (imageData == null || imageData.length == 0) {
                return JsonResult.error("下载图片失败");
            }

            BaiduAIResult result = baiduAIService.plantRecognition(imageData);

            if (result.isSuccess()) {
                return JsonResult.success(result);
            } else {
                return JsonResult.error("识别失败: " + result.getError_msg());
            }
        } catch (Exception e) {
            return JsonResult.error("识别异常: " + e.getMessage());
        }
    }

    /**
     * 动物识别 - 通过文件上传
     */
    @PostMapping("/animalRecognitionByFile")
    public ResponseData animalRecognitionByFile(@RequestParam("image") MultipartFile image) {
        try {
            if (image.isEmpty()) {
                return JsonResult.error("上传的图片不能为空");
            }

            byte[] imageData = image.getBytes();
            BaiduAIResult result = baiduAIService.animalRecognition(imageData);

            if (result.isSuccess()) {
                return JsonResult.success(result);
            } else {
                return JsonResult.error("识别失败: " + result.getError_msg());
            }
        } catch (IOException e) {
            return JsonResult.error("文件处理异常: " + e.getMessage());
        } catch (Exception e) {
            return JsonResult.error("识别异常: " + e.getMessage());
        }
    }

    /**
     * 动物识别 - 通过URL
     */
    @GetMapping("/animalRecognition")
    public ResponseData animalRecognitionByUrl(@RequestParam("image") String imageUrl) {
        try {
            byte[] imageData = downloadImageFromUrl(imageUrl);
            if (imageData == null || imageData.length == 0) {
                return JsonResult.error("下载图片失败");
            }

            BaiduAIResult result = baiduAIService.animalRecognition(imageData);

            if (result.isSuccess()) {
                return JsonResult.success(result);
            } else {
                return JsonResult.error("识别失败: " + result.getError_msg());
            }
        } catch (Exception e) {
            return JsonResult.error("识别异常: " + e.getMessage());
        }
    }

    /**
     * 从URL下载图片
     */
    private byte[] downloadImageFromUrl(String imageUrl) throws IOException {

        File file=new File(Configure.ROOT_DIR + imageUrl);
        if (!file.exists()) {
            return null;
        }
        // 读取文件所有内容
        return FileUtils.readFileToByteArray(file);
    }
}