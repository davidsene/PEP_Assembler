package main;

public enum BranchingCondition {
	
	EQ("0000","EQ","="),
	NEQ("0001","NEQ","<>");
	
	private String codeOpCond;
	private String stringCode;
	private String operatorLabel;
	
	private BranchingCondition(String codeOpCond, String stringCode, String operatorLabel) {
		this.codeOpCond = codeOpCond;
		this.stringCode = stringCode;
		this.operatorLabel = operatorLabel;
	}
	
	public static BranchingCondition getBanchingConditionFromOperator(String operator){
		
		switch (operator) {
		case "=": return BranchingCondition.EQ;
		case "<>": return BranchingCondition.NEQ;
		default:
			return null;
		}
	}

	public String getCodeOpCond() {
		return codeOpCond;
	}

	public String getStringCode() {
		return stringCode;
	}

	public String getOperatorLabel() {
		return operatorLabel;
	}
	
	

	
}
