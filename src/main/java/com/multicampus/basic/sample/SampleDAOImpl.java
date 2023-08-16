package com.multicampus.basic.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//@Primary : 여러개의 SampleDAO 구현 클래스들 중 SampleService에 주입됨.
@Qualifier("normal")
public class SampleDAOImpl implements SampleDAO{
}
