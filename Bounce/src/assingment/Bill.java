package assingment;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Bill {

	@JsonProperty
	private int totalAmount;
	@JsonProperty
	private Map<String, Integer> liability;
	@JsonProperty
	private Map<String, Integer> payment;
	@JsonProperty
    private Map<String, Map<String, Integer>> simplifiedBill = null; 
	@JsonProperty
	private Map<String, Integer> bill = null; 

	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(int totalAmount, Map<String, Integer> liability, Map<String, Integer> payment) {
		super();
		this.totalAmount = totalAmount;
		this.liability = liability;
		this.payment = payment;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Map<String, Map<String, Integer>> getSimplifiedBill() {
		return simplifiedBill;
	}
	public void setSimplifiedBill(Map<String, Map<String, Integer>> simplifiedBill) {
		this.simplifiedBill = simplifiedBill;
	}
	public Map<String, Integer> getBill() {
		return bill;
	}
	public void setBill(Map<String, Integer> bill) {
		this.bill = bill;
	}
	public Map<String, Integer> getLiability() {
		return liability;
	}
	public void setLiability(Map<String, Integer> liability) {
		this.liability = liability;
	}
	public Map<String, Integer> getPayment() {
		return payment;
	}
	public void setPayment(Map<String, Integer> payment) {
		this.payment = payment;
	}
	
	

	
	
}
