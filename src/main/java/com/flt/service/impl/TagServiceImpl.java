package com.flt.service.impl;

import com.flt.entity.Tag;
import com.flt.enums.ResponseStatusEnum;
import com.flt.mapper.TagMapper;
import com.flt.service.TagService;
import com.flt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.service.impl-TagServiceImpl
 * date: 2020/8/3 15:42
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public ResultVO findAllOrderCount() {
        ResultVO resultVO=new ResultVO();
        List<Tag> tag = tagMapper.findAllOrderCount();
        resultVO.setCode(ResponseStatusEnum.SUCCESS.getCode());
        resultVO.setMsg(ResponseStatusEnum.SUCCESS.getMsg());
        resultVO.setCount(tag.size());
        resultVO.setData(tag);
        return resultVO;
    }
}
