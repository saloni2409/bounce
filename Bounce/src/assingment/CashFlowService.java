package assingment;

import java.util.Map;

public class CashFlowService {

	public Map<String, Map<String, Integer>> getBillSimplified(Bill bill) {
		CashFlowUtil.generateBill(bill);
		return bill.getSimplifiedBill();
	}

	public Map<String, Integer> getBillBasic(Bill bill) {
		CashFlowUtil.generateBill(bill);
		return bill.getBill();
	}

	public Bill getBill(Bill bill) {
		CashFlowUtil.generateBill(bill);
		return bill;
	}

}
