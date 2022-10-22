package org.gushi.gushici;

import org.gushi.gushici.domain.AuthorInfo;
import org.gushi.gushici.service.AuthorInfoService;
import org.gushi.gushici.service.ImportLogService;
import org.gushi.gushici.service.LiteratureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: fang
 * Date:   2022-02-20 10:44 星期日
 * Class:  AuthorApplicatiosTests
 **/
@SpringBootTest
public class AuthorApplicatiosTests {

    @Autowired
    private AuthorInfoService authorInfoService;

//    @Autowired
//    private AuthorInfoMapper authorInfoMapper;

    @Autowired
    private ImportLogService importLogService;

    @Autowired
    private LiteratureService literatureService;



    @Test
    public void add (){
        AuthorInfo authorInfo = new AuthorInfo();
        authorInfo.setName("白居易2");
        authorInfoService.save(authorInfo);

//        assertThat(authorInfo.getId()).isNotNull();
    }

    @Test
    public void delete (){
//        AuthorInfo authorInfo = new AuthorInfo();
//        authorInfo.setName("白居易2");
//        authorInfo.setId(1711308803);
        System.out.println(authorInfoService.removeById(2076192770));
//        assertThat(authorInfo.getId()).isNotNull();
    }

    @Test
    public void update (){
        AuthorInfo authorInfo = new AuthorInfo();
        authorInfo.setName("李白");
        authorInfo.setId(2076192770);
        authorInfoService.updateById(authorInfo);
        assertThat(authorInfo.toString()).isNotNull();
//        UpdateWrapper updateWrapper = new UpdateWrapper<>();
//        updateWrapper.set("name", "李白");
//        updateWrapper.set("id", 1711308803);
//        authorInfoMapper.update(updateWrapper);
//        updateWrapper.
//        assertThat(authorInfo.getId()).isNotNull();
    }

    @Test
    public void query (){
        AuthorInfo authorInfo = authorInfoService.getById(2076192770);

        System.out.println(authorInfo.toString());
//        assertThat(authorInfo.getId()).isNotNull();
    }
}
