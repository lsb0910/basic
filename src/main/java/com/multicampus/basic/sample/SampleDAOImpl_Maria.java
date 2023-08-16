package com.multicampus.basic.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("maria")
public class SampleDAOImpl_Maria implements SampleDAO{
}
