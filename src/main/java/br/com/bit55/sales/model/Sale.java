package br.com.bit55.sales.model;

import java.time.LocalDate;

public class Sale {
	
	private LocalDate date;
	private int clientId;
	private int count;
	private int value;
	
	public Sale(){
	}
	
	public Sale(final LocalDate date, final int clientId, final int count, final int value) {
		this.date = date;
		this.clientId = clientId;
		this.count = count;
		this.value = value;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(final LocalDate date) {
		this.date = date;
	}
	
	public int getClientId() {
		return clientId;
	}
	
	public void setClientId(final int clientId) {
		this.clientId = clientId;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(final int count) {
		this.count = count;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(final int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Sale{" + "date=" + date + ", clientId=" + clientId + ", count=" + count + ", value=" + value + '}';
	}
}
