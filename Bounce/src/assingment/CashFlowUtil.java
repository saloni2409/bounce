package assingment;

import java.util.HashMap;
import java.util.Map;

class CashFlowUtil {

	private static Map.Entry<String, Integer> getMin(Map<String, Integer> map) {
		Map.Entry<String, Integer> minEntry = null;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (minEntry == null || minEntry.getValue() > entry.getValue()) {
				minEntry = entry;
			}
		}
		return minEntry;
	}

	private static Map.Entry<String, Integer> getMax(Map<String, Integer> map) {
		Map.Entry<String, Integer> maxEntry = null;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
				maxEntry = entry;
			}
		}
		return maxEntry;

	}

	private static int minOf2(int x, int y) {
		return (x < y) ? x : y;
	}

	private static Map<String, Map<String, Integer>> minCashFlow(Map<String, Integer> bill) {
		Map<String, Map<String, Integer>> simplifiedBill = new HashMap<String, Map<String, Integer>>();
		System.out.println(bill);
		minCashFlowRec(bill, simplifiedBill);
		return simplifiedBill;
	}

	private static void minCashFlowRec(Map<String, Integer> bill, Map<String, Map<String, Integer>> simplifiedBill) {

		Map.Entry<String, Integer> mxCredit = getMax(bill);
		Map.Entry<String, Integer> mxDebit = getMin(bill);

		if (mxCredit.getValue() == 0 && mxDebit.getValue() == 0)
			return;

		int min = minOf2(-mxDebit.getValue(), mxCredit.getValue());

		bill.put(mxCredit.getKey(), mxCredit.getValue() - min);
		bill.put(mxDebit.getKey(), mxDebit.getValue() + min);

		Map<String, Integer> map = simplifiedBill.get(mxDebit.getKey());
		if (null == map) {
			map = new HashMap<String, Integer>();
		}
		map.put(mxCredit.getKey(), min);
		simplifiedBill.put(mxDebit.getKey(), map);
		minCashFlowRec(bill, simplifiedBill);
	}

	public static void generateBill(Bill bill) {
		int totalPayment=0;
		int totalLiability=0;
		Map<String, Integer> credit = new HashMap<String, Integer>();
		for (String person : bill.getLiability().keySet()) {
			Integer creditAmt = bill.getPayment().get(person) - bill.getLiability().get(person);
			credit.put(person, creditAmt);
			totalPayment+=bill.getPayment().get(person);
			totalLiability+=bill.getLiability().get(person);
		}

		if (totalLiability!=totalPayment || totalPayment!=bill.getTotalAmount()) {
			throw new RuntimeException("Invalid inputs");
		}
		bill.setBill(new HashMap<String, Integer>(credit));
		Map<String, Map<String, Integer>> minCashFlow = minCashFlow(credit);
		bill.setSimplifiedBill(minCashFlow);
	}
}
