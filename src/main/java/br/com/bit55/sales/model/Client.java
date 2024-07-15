package br.com.bit55.sales.model;

public class Client {
	
	private int id;
	private int salesCount;
	private int totalSalesValue;
	
	public Client(){
	}
	
	public Client(final int id, final int salesCount, final int totalSalesValue) {
		this.id = id;
		this.salesCount = salesCount;
		this.totalSalesValue = totalSalesValue;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(final int id) {
		this.id = id;
	}
	
	public int getSalesCount() {
		return salesCount;
	}
	
	public void setSalesCount(final int salesCount) {
		this.salesCount = salesCount;
	}
	
	public int getTotalSalesValue() {
		return totalSalesValue;
	}
	
	public void setTotalSalesValue(final int totalSalesValue) {
		this.totalSalesValue = totalSalesValue;
	}
	
	@Override
	public String toString() {
		return "Client{" + "id=" + id + ", salesCount=" + salesCount + ", totalSalesValue=" + totalSalesValue + '}';
	}
}
