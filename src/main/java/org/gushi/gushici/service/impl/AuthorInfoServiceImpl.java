package org.gushi.gushici.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.gushi.gushici.domain.AuthorInfo;
import org.gushi.gushici.mapper.AuthorInfoMapper;
import org.gushi.gushici.service.AuthorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author y
* @description 针对表【author_info】的数据库操作Service实现
* @createDate 2022-02-23 17:05:10
*/
@Service
public class AuthorInfoServiceImpl extends ServiceImpl<AuthorInfoMapper, AuthorInfo>
    implements AuthorInfoService {

    @Autowired
    private AuthorInfoMapper authorInfoMapper;

    @Override
    public AuthorInfo queryAuthorInfoByName(String name) {

        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        queryWrapper.last("LIMIT 1");
        AuthorInfo authorInfo = authorInfoMapper.selectOne(queryWrapper);
        return authorInfo;
    }
}




