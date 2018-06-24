package edu.bupt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.bupt.pojo.Book;
import edu.bupt.serviceImp.BookServiceImp;
import edu.bupt.util.HttpClientUtil;
import edu.bupt.util.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
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
                    @RequestParam("descr") String descr) throws Exception {
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

            resp.put("code",200);
            resp.put("msg","ok");

        } catch (Exception e) {
            throw new Exception(e);
        }
        return resp;
    }


    /*
    * 得到处书籍
    * */
    @RequestMapping(value = "get-book",method = RequestMethod.GET)
    public Map getBook(@RequestParam("bookId") long id) throws Exception {
        HashMap<String,Object> resp = new HashMap<>();
        Book book = bookServiceImp.getUserBook(id);
        if (book == null){
            throw new Exception("bookId错误!");
        }

        resp.put("code",200);
        resp.put("msg","ok");
        resp.put("book",book);
        return resp;
    }

    /*
    * 查询书籍
    * */
    @RequestMapping(value = "searchbook",method = RequestMethod.GET)
    public Map searchbooks(@RequestParam Map<String,Object> params) throws Exception {
        HashMap<String,Object> resp = new HashMap<>();
        List<Book> books = bookServiceImp.search(params);
        if (books.size() == 0){
            throw new Exception("无该状态的图书!");
        }

        resp.put("code",200);
        resp.put("msg","ok");
        resp.put("count",books.size());
        resp.put("books",books);
        return resp;
    }
}
