package org.gushi.gushici.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: fang
 * Date:   2022-02-25 14:09 星期五
 * Class:  FileController
 **/
@RestController
public class FileController {


    @PostMapping("")
    public String JsonFileSave(){

        String path = "C:\\Users\\y\\Desktop\\chinese-poetry-master\\ci\\author.song.json";
        JSONArray jsonArray = JSONUtil.parseArray(path);

        System.out.println(jsonArray.toString());

        return "";
    }
}
