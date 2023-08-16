package com.multicampus.basic.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("oracle")
public class SampleDAOImpl_Oracle implements SampleDAO{
}
