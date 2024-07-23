package com.springboot.repository;

public interface SequenceGeneratorCustomRepository {

  Long getNextId(String sequenceGeneratorName);

}
