package com.multicampus.basic.mapper;

import com.multicampus.basic.domain.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {
    @Autowired(required = false)
    private TodoMapper todoMapper;


    @Test
    public void testGetTime(){
        log.info(todoMapper.getTime());
    }


    //사용하지 않는 Service,Controller 등 다 제거해야 테스트됨!
    @Test
    public void testInsert(){
        TodoVO todoVO = TodoVO.builder()
                .title("스프링 TodoTest11")
                .dueDate(LocalDate.of(2023,8,18))
                .writer("user11")
                .build();
        todoMapper.insert(todoVO);

    }
}
