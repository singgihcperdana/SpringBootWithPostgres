package com.springboot.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.math.BigInteger;

public class OrderIdSeqGenerator implements IdentifierGenerator {

  @Override
  public Serializable generate(SharedSessionContractImplementor session,
      Object o) throws HibernateException {
    String sequenceGeneratorName = "order_id_seq";
    String query = String.format("SELECT nextval('\"%s\"')", sequenceGeneratorName);
    Long sequence = ((BigInteger) session.createNativeQuery(query)
        .getSingleResult())
        .longValue();
    return constructCode(sequence);
  }

  private String constructCode(Long sequence){
    int length = 10;
    return "ORDER-"+ String.format("%0"+length+"d", sequence);
  }

}
