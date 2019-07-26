package com.czxy.servlet;

import cn.itcast.servlet.BaseServlet;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * @author lenovo
 * @version v 1.0
 * @date 2019/3/19
 */
public class DownloadServlet extends BaseServlet {
    public void download() throws IOException {
        //1.获取文件名
        String filename = this.getRequest().getParameter("filename");
        //2.获取绝对路径
        String realPath = this.getServletContext().getRealPath(filename);
        //3. 把文件写入内存
        byte[] data = FileUtils.readFileToByteArray(new File(realPath));
        //4.设置响应头 告知浏览器要用的下载模式
        this.getResponse().addHeader("Content-Disposition","attachment;filename="+filename);

        //5. 把文件响应回去 1111111111111
        ServletOutputStream outputStream = this.getResponse().getOutputStream();
        outputStream.write(data);

    }
}
