package com.xtkj.test;

import java.io.File;
import java.io.InputStream;
 
import org.apache.commons.io.FileUtils;
import com.xtkj.utils.FastDFSClientUtils;
 
public class FastDFSTest {
    
    /**
     * 上传
     */
    public static void upload() throws Exception {
        String path = "D:\\5M958.jpg";
        File file = new File(path);
        String fileId = FastDFSClientUtils.upload(file, path);
        // 本地文件：C:\Users\Leon.sun\Desktop\Temp\img\56.jpg，上传成功！ 文件ID为：group1/M00/00/00/rBH2Clw3EpeAbO70AAB5yKpbklA306.jpg
        System.out.println("本地文件：" + path + "，上传成功！ 文件ID为：" + fileId);
    }
    
    /**
     * 下载
     */
    public static void download() throws Exception {
        String fileId = "group1/M00/00/00/rBH2Clw3EpeAbO70AAB5yKpbklA306.jpg";
        InputStream inputStream = FastDFSClientUtils.download("group1", fileId);
        System.out.println(inputStream.available());
        String path = "C:\\Users\\Leon.sun\\Desktop\\Temp\\img\\66.jpg";
        System.out.println(path);
        FileUtils.copyInputStreamToFile(inputStream,  new File(path));
    }
 
    /**
     * 删除
     */
    public static void delete() throws Exception {
        String fileId = "group1/M00/00/00/rBH2Clw3EpeAbO70AAB5yKpbklA306.jpg";
        int result = FastDFSClientUtils.delete("group1", fileId);
        System.out.println(result == 0 ? "删除成功" : "删除失败:" + result);
    }
 
 
    
    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
    
 
        	upload();
//        download();
//        Thread.sleep(10000);
//        download();
//        Thread.sleep(10000);
//        download();
 
    }
 
}
