package com.flt.mapper;

import com.flt.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TagMapper {

    Tag findTagById(Integer tagId);
    List<Tag> findAllOrderCount();
}
