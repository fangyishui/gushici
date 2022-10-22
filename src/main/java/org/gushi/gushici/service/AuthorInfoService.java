package org.gushi.gushici.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.gushi.gushici.domain.AuthorInfo;

/**
* @author y
* @description 针对表【author_info】的数据库操作Service
* @createDate 2022-02-23 17:05:10
*/
public interface AuthorInfoService extends IService<AuthorInfo> {

    AuthorInfo queryAuthorInfoByName(String name);
}
