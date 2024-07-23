package com.springboot.entity;

import com.springboot.util.TransactionCodeSeqGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {

	@Column(name = "name")
	public String name;

	@Column(name = "ref_code", unique = true)
	public String refCode;

	@GeneratorType(type = TransactionCodeSeqGenerator.class, when = GenerationTime.INSERT)
	@Column(name = "transaction_code", unique = true, nullable = false, updatable = false, length = 15)
	private String transactionCode;

}
