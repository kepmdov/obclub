package com.cn.base;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Util <T>{
    public static byte[] file2byte(File file) throws Exception{
        byte[] buffer = new byte[(int) file.listFiles().length];
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b=new byte[4096];
        int n;
        while ((n=fis.read(b))!=-1){
            bos.write(b,0,n);
        }
        fis.close();
        bos.close();
        buffer=bos.toByteArray();
        return buffer;
    }

    public static String changeDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString=formatter.format(date);
        return dateString;
    }
}
