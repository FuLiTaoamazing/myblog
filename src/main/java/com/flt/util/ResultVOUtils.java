package com.flt.util;

import com.flt.entity.Tag;
import com.flt.enums.ResponseStatusEnum;
import com.flt.mapper.TagMapper;
import com.flt.vo.ResultVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:返回结果视图层对象帮助类
 * path: myblog-com.flt.util-ResultVOUtils
 * date: 2020/7/31 16:18
 */
public class ResultVOUtils {

    public static ResultVO saveSuccess() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResponseStatusEnum.SUCCESS.getCode());
        resultVO.setMsg(ResponseStatusEnum.SUCCESS.getMsg());
        resultVO.setSuccess(true);
        return resultVO;
    }

    public static ResultVO saveError() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResponseStatusEnum.ERROR.getCode());
        resultVO.setMsg(ResponseStatusEnum.ERROR.getMsg());
        resultVO.setSuccess(false);
        return resultVO;
    }


    public static ResultVO sucess() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResponseStatusEnum.SUCCESS.getCode());
        resultVO.setMsg(ResponseStatusEnum.SUCCESS.getMsg());
        resultVO.setSuccess(true);
        return resultVO;
    }




    public static List<Tag> getTagsByBlog(String tags, TagMapper tagMapper) {
        List<Tag> tagList = new ArrayList<>();
        String[] split = tags.split(",");
        for (String s : split) {
            Tag tagById = tagMapper.findTagById(Integer.parseInt(s));
            tagList.add(tagById);
        }
        return tagList;
    }

}
