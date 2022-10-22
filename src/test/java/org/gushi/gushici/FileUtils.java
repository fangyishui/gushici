package org.gushi.gushici;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import org.gushi.gushici.domain.AuthorInfo;
import org.gushi.gushici.domain.ImportLog;
import org.gushi.gushici.domain.Literature;
import org.gushi.gushici.enums.LiteraryStyleEnum;
import org.gushi.gushici.service.AuthorInfoService;
import org.gushi.gushici.service.ImportLogService;
import org.gushi.gushici.service.LiteratureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: fang
 * Date:   2022-02-25 14:25 星期五
 * Class:  FileUtils
 **/

@SpringBootTest
public class FileUtils {

    //声明request变量
    private MockHttpServletRequest request;

    @Autowired
    private AuthorInfoService authorInfoService;

    @Autowired
    private ImportLogService importLogService;

    @Autowired
    private LiteratureService literatureService;

    @Test
    public void JsonFileSave(){
        String path = "C:\\Users\\y\\Desktop\\chinese-poetry-master\\ci\\author.song.json";
        String jsonStr = FileUtil.readUtf8String(path);
        JSONArray jsonArray = JSONUtil.parseArray(jsonStr);
        List<Dict> dicts = JSONUtil.toList(jsonArray, Dict.class);

        List<AuthorInfo> authorInfoList = new ArrayList<>();
        for (Dict dict:dicts) {
            AuthorInfo authorInfo = new AuthorInfo();
            authorInfo.setName(dict.getStr("name"));
            authorInfo.setShortDescription(dict.getStr("short_description"));
            authorInfo.setDescription(dict.getStr("description"));
            authorInfoList.add(authorInfo);
        }
        boolean batch = authorInfoService.saveBatch(authorInfoList);
        System.out.println(batch);
    }

    @Test
    void TestWorks(){
        String path = "C:\\Users\\y\\Desktop\\chinese-poetry-master\\ci";
        List<File> files = FileUtil.loopFiles(path);
        //遍历列表作品
        List<String> absoluteFileLis = new ArrayList<>();
        List<ImportLog> importLogList = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            String name = files.get(i).getName();
            String extName = FileNameUtil.extName(name);
            if(extName.equals("json")){
//                File absoluteFile = files.get(i).getAbsoluteFile();
                absoluteFileLis.add(files.get(i).getPath());

                ImportLog importLog = new ImportLog();
                importLog.setFilePath(files.get(i).getPath());
                importLog.setImportName(files.get(i).getName());

                //创建request对象并设置字符编码
                request = new MockHttpServletRequest();
                request.setCharacterEncoding("UTF-8");
                String clientIP = ServletUtil.getClientIP(request, null);
                importLog.setImportIp(clientIP);

                importLogList.add(importLog);
            }
        }
//        importLogService.saveBatch(importLogList);

        //根据作者名查询作者id 关联

        List<Literature> literatureList = new ArrayList<>();
        for (String filePath: absoluteFileLis) {
            System.out.println(filePath);
            String jsonStr = FileUtil.readUtf8String(filePath);
            JSONArray jsonArray = JSONUtil.parseArray(jsonStr);
            List<Dict> dicts = JSONUtil.toList(jsonArray, Dict.class);


            for (Dict dict:dicts) {
                Literature literature = new Literature();

                if(dict.getStr("author") == null){
                    continue;
                }
                String name = dict.getStr("author");
                AuthorInfo authorInfo = authorInfoService.queryAuthorInfoByName(name);
                if (authorInfo != null){
                    literature.setAuthorId(authorInfo.getAuthorId());
                }
                literature.setContent(dict.getStr("paragraphs"));
                literature.setDetailType(dict.getStr("rhythmic"));
                literature.setUpdatePerson("admin");

                literature.setType(LiteraryStyleEnum.Ci.getCode());

                literatureList.add(literature);
            }

        }
//        for (int i = 0; i < literatureList.size(); i++) {
//            try {
//                literatureService.save(literatureList.get(i));
//            }catch (Exception e){
//                System.out.println(literatureList.get(i).toString());
//                e.printStackTrace();
//                break;
//            }
//
//        }
        literatureService.saveBatch(literatureList);

        //保存

    }


    @Test
    void IdGen(){

        for (int i = 0; i < 20; i++) {
            String id2 = IdUtil.objectId();
            System.out.println(id2);
        }
    }
}
