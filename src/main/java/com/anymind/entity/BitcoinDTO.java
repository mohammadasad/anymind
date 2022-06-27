package com.anymind.entity;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="bitcoin")
public class BitcoinDTO {
	
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bitcoin_id", updatable = false, nullable = false)
	private int bitCoinId;
	@Column(name = "amount")
	private BigDecimal amount;
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datetime",nullable = false, updatable = false)
	private Date datetime;
	
	public BitcoinDTO(){}
	
	public BitcoinDTO(BigDecimal amount,Date datetime,int bitCoinId){
		this.amount=amount;
		this.datetime=datetime;
		this.bitCoinId=bitCoinId;
	}
	public BitcoinDTO(BigDecimal amount,Date datetime){
		this.amount=amount;
		this.datetime=datetime;
	}
	public int getBitCoinId() {
		return bitCoinId;
	}
	public void setBitCoinId(int bitCoinId) {
		this.bitCoinId = bitCoinId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Temporal(TemporalType.DATE)
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
