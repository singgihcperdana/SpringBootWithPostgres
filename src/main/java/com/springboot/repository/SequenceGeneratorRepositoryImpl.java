package com.springboot.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@Slf4j
@Component
public class SequenceGeneratorRepositoryImpl implements SequenceGeneratorCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Long getNextId(String sequenceGeneratorName) {
    String query = String.format("SELECT nextval('\"%s\"')", sequenceGeneratorName);
    return ((BigInteger) entityManager.createNativeQuery(query)
        .getSingleResult())
        .longValue();
  }

}
