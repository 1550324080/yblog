package com.boot;

import com.boot.pojo.Article;
import com.boot.pojo.tag;
import com.boot.service.articleService;
import com.boot.service.tagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class test {


    @Autowired
    private articleService articleService;

//    @Test
//    public void test(){
//
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            int x = random.nextInt(5);
//            System.out.println(x);
//        }
//
//    }


    /**
     *导入tag数据
     */
    private Map<String,Integer> map=new LinkedHashMap<>();

    @Autowired
    private tagService tagService;

    @Test
    public void test1(){
        List<Article> articles = articleService.selectTagsByArticle();
        for (Article article : articles) {
            String tags = article.getTags();
            String[] split = tags.split(",");
            for (String s : split) {

                if (map.containsKey(s)) {
                    int i = map.get(s);
                    i++;
                    map.put(s,i);

                }else {
                    map.put(s,1);
                }
            }

        }
        Set<String> strings = map.keySet();
        for (String string : strings) {
            tag tag = new tag();
            tag.setTagName(string);
            tag.setTagCount(map.get(string));
            tagService.addTag(tag);
        }

    }





}