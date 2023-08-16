package com.multicampus.basic.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@ToString
@Service
@RequiredArgsConstructor    //생성자 주입방식
public class SampleService {

    /* Field Injection */
//    @Autowired
//    private SampleDAO2 sampleDAO2;

    /* 생성자 주입방식 */
//   private final SampleDAO2 sampleDAO2;

    /* 인터페이스를 이용한 느슨한 결합 */
//    @Qualifier("maria")
//    @Qualifier("normal")
    @Qualifier("oracle")
    private final SampleDAO sampleDAO;

     // 1. @Primary : SampleDAOImpl => @Primary 어노테이션 붙으면 SampleDAOImpl이 주입됨
     // 2. @Qualifier : 원하는 객체로 선택적으로 주입 가능 but, @Qualifier를 사용하려면.. lombok.config 생성 해줘야함 !
}
