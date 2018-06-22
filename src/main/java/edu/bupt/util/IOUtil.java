package edu.bupt.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by 73681 on 2018/6/22.
 */
public class IOUtil {
    /*
    * 将inputStream的内容变为String
    * */
    public static String inputStream2String(InputStream inputStream){
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while ((line = br.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}
