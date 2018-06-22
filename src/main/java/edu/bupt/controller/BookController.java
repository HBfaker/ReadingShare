package edu.bupt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.tools.corba.se.idl.StringGen;
import edu.bupt.pojo.Book;
import edu.bupt.serviceImp.BookServiceImp;
import edu.bupt.util.HttpClientUtil;
import edu.bupt.util.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 73681 on 2018/6/22.
 */
@RestController
public class BookController {
    @Autowired
    BookServiceImp bookServiceImp;

    /*
    * 书籍上传接口
    * */

    @RequestMapping(value = "book-upload",method = RequestMethod.POST)
    public Map bookUpload(@RequestParam("isbn") String ISBN, @RequestParam("userId") int userId,
                    @RequestParam("descr") String descr){
        String douban = "https://api.douban.com/v2/book/isbn/:" + ISBN;

        Map<String,Object> resp = new HashMap<String,Object>();

        try {
            //根据isbn请求图书信息
            InputStream respInputStream = HttpClientUtil.get(douban,null);
            String respStr = IOUtil.inputStream2String(respInputStream);
            //将得到的数据转为json对象
            JSONObject bookInfo = JSON.parseObject(respStr);

            //得到豆瓣评分
            String doubanAverage = bookInfo.getJSONObject("rating").getString("average");

            //得到书籍作者的信息
            JSONArray authorArray = bookInfo.getJSONArray("author");
            String authorInfo = authorArray.toJSONString();

            //书籍的图片
            String imageUrl = bookInfo.getString("image");

            //数据出版社
            String publisher = bookInfo.getString("publisher");

            //书籍名字
            String bookName = bookInfo.getString("title");

            Book book = new Book();
            book.setISBN(ISBN);
            book.setUserId(userId);
            book.setAuthor(authorInfo);
            book.setPublisher(publisher);
            book.setBookName(bookName);
            book.setBookImgPath(imageUrl);
            book.setDemandDecr(descr);

            bookServiceImp.insert(book);

            resp.put("status",200);
            resp.put("msg","ok");

        } catch (Exception e) {
            resp.put("status",1000);
            resp.put("msg",e.getMessage());
            e.printStackTrace();
        }
        return resp;
    }
}
