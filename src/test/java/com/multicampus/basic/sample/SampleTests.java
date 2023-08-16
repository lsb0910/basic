package com.multicampus.basic.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class) //spring-test를 이용하기 위한 설정 Junit5버전  , Junit4 @Runwith사용
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml") //빈의 위치
public class SampleTests {

    @Autowired  //해당 타입의 빈이 존재하면 주입해라!
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testService(){
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }


    @Test
    public void testConnection() throws Exception{
        Connection con = dataSource.getConnection();    //주입받은 DataSource를 이용해서 마리아DB와 연결가능한지 확인
        log.info(con);
        Assertions.assertNotNull(con);

        //리소스기 때문에 반드시 닫아줘야 한다.
        con.close();
    }

}
