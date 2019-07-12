package com.wch.as.as;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
public class App {
    public static void main(String[] args) {
        String hdfsfilePath = "/user/cc.txt";
        //copyLocalFiletoHdfs(hdfsfilePath);
        copyHdfsFileToConsole(hdfsfilePath);
    }
 
    /**
     * 读取hdfs的文件并且显示在控制台
     *
     * @param hdfsPath hdfs的文件路径
     */
    public static void copyHdfsFileToConsole(String hdfsPath) {
        FileSystem fileSystem = null;
        FSDataInputStream inputStream = null;
 
        try {
            //1.获取
            Configuration conf = new Configuration();
            //2.配置hdfs的访问入口  (配置文件core-site.xml放到同包的resources下)
            conf.set("fs.defaultFS","hdfs://192.168.1.191:9000");
            //3.获取hdfs对象
            fileSystem = FileSystem.newInstance(conf);
            //4.对hdfs对象进行操作
            inputStream = fileSystem.open(new Path(hdfsPath));
            IOUtils.copyBytes(inputStream, System.out, 4096, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 
    /**
     * 上传windows本地文件到hdfs
     *
     * @param hdfsFilePath
     */
    public static void copyLocalFiletoHdfs(String hdfsFilePath) {
        FileSystem fileSystem = null;
        FSDataOutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        Properties properties = System.getProperties();
        properties.setProperty("HADOOP_USER_NAME", "hduser");
        Configuration conf = new Configuration();
        //2.配置hdfs的访问入口  (配置文件core-site.xml放到同包的resources下)

        conf.set("fs.defaultFS","hdfs://192.168.1.191:9000");
        System.out.print(hdfsFilePath);
        /*File file = new File(hdfsFilePath);
        if (!file.exists()){
            file.mkdirs();
        }*/
        try {
            
            fileSystem = FileSystem.newInstance(conf);
            outputStream = fileSystem.create(new Path(hdfsFilePath), true);
            fileInputStream = new FileInputStream(new File("D://aa.txt"));
            IOUtils.copyBytes(fileInputStream, outputStream, 4096, true);
            //fileSystem.copyFromLocalFile(false, new Path("D://aa.txt"), new Path(hdfsFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 
}

