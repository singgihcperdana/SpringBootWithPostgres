package com.springboot.util;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.NativeQuery;
import org.hibernate.tuple.ValueGenerator;

import java.io.Serializable;
import java.math.BigInteger;

public class TransactionCodeSeqGenerator implements ValueGenerator<String> {

  @Override
  public String generateValue(Session session, Object owner) throws HibernateException {
    String sequenceGeneratorName = "transaction_code_seq";
    String query = String.format("SELECT nextval('\"%s\"')", sequenceGeneratorName);
    NativeQuery nextValQuery = session.createSQLQuery(query);
    Number nextVal = (Number) nextValQuery.setFlushMode(FlushMode.COMMIT).uniqueResult();
    Long sequence = nextVal.longValue();
    return constructCode(sequence);
  }

  private String constructCode(Long sequence){
    int length = 10;
    return "TRX-"+ String.format("%0"+length+"d", sequence);
  }

}
