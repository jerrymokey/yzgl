package com.jerry.yzgl.yw.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.jerry.yzgl.util.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author： jerry
 * @version： 2022/9/10 18:59
 * 文件相关控制器
 */
@ApiOperation("文件上传下载接口")
@Controller
@RequestMapping("file")
public class FileController {
    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @Value("${file.uploadAddr}")
    private String fileUploadAddr;


    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResultVO upload(MultipartFile file, HttpServletRequest request) throws IOException {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("文件上传失败");
        try {
            String fileName = file.getOriginalFilename();
            File filePath = new File(fileUploadAddr);
            if (!filePath.exists()) {
                filePath.mkdir();
            }
            file.transferTo(new File(filePath, fileName));
            resultVO.setCode(200);
            resultVO.setMsg("文件上传成功");
            resultVO.setData(fileName);
            logger.info(resultVO.getMsg() + "上传路径：" + fileUploadAddr + File.separator + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文件上传失败");
        }
        return resultVO;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取文件的绝对路径
        String realPath = fileUploadAddr;
        //获取输入流对象（用于读文件）
        FileInputStream fis = new FileInputStream(new File(realPath, fileName));
        //获取文件后缀（.txt）
        String extendFileName = fileName.substring(fileName.lastIndexOf('.'));
        //动态设置响应类型，根据前台传递文件类型设置响应类型
        response.setContentType(request.getSession().getServletContext().getMimeType(extendFileName));
        //设置响应头,attachment表示以附件的形式下载，inline表示在线打开
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        //获取输出流对象（用于写文件）
        ServletOutputStream os = response.getOutputStream();
        //下载文件,使用spring框架中的FileCopyUtils工具
        FileCopyUtils.copy(fis, os);
    }
}
