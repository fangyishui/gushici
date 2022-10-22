package org.gushi.gushici.controller;

import org.gushi.gushici.domain.Literature;
import org.gushi.gushici.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: fang
 * Date:   2022-03-01 10:46 星期二
 * Class:  LiteratureController
 *
 * GET：从服务器取出资源（一项或多项）。
 * POST：在服务器新建一个资源。
 * PUT：在服务器更新资源（客户端提供改变后的完整资源）。
 * PATCH：在服务器更新资源（客户端提供改变的属性）。
 * DELETE：从服务器删除资源。
 *
 * 1、@GetMapping，处理 Get 请求
 * 　　2、@PostMapping，处理 Post 请求
 * 　　3、@PutMapping，用于更新资源
 * 　　4、@DeleteMapping，处理删除请求
 * 　　5、@PatchMapping，用于更新部分资源
 **/
@RestController
public class LiteratureController {

    @Autowired
    private LiteratureService literatureService;


    @PostMapping("literature")
    public Object add(Literature literature){
        return literatureService.save(literature);
    }

    @DeleteMapping("literature/{userId}")
    public Object delete(@PathVariable String userId){
        return literatureService.removeById(userId);
    }
    @PutMapping("literature")
    public Object update(Literature literature){
        return literatureService.update();
    }

    @PatchMapping("literature")
    public Object update2(Literature literature){
        return literatureService.update();
    }

    @GetMapping("literature/{userId}")
    public Object queryById(){
        return literatureService.list().subList(0, 100);
    }

    @GetMapping("literature")
    public Object list(){
        return literatureService.list().subList(0, 100);
    }
}
