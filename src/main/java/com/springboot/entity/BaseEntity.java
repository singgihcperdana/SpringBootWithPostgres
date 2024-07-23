package com.springboot.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity implements Serializable {

  @Id
  @Column(name = "id")
//  @GeneratedValue(generator = "system-uuid")
//  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
  @GenericGenerator(name = "order_id_seq", strategy = "com.springboot.util.OrderIdSeqGenerator")
  private String id;

  @CreatedDate
  @Column(name = "created_date")
  private Date createdDate;

}
