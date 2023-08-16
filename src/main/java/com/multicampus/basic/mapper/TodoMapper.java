package com.multicampus.basic.mapper;

import com.multicampus.basic.domain.TodoVO;

// 1.Mapper => 2.Service => 3.Controller => 4.JSP
public interface TodoMapper {
    String getTime();
    //TodoVo를 파라미터로 입력받는 insert() 정의
    void insert(TodoVO todoVO);

}
