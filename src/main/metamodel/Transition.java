package main.metamodel;

public class Transition {

	private String event;
	private State to;
	private String opVar;
	private String condVar;
	private int operationalValue;
	private int compareValue;

	private boolean hasSetOperation = false;
	private boolean hasIncrementOperation = false;
	private boolean hasDecrementOperation = false;
	private boolean isConditionEqual = false;
	private boolean isConditionGreaterThan = false;
	private boolean isConditionLessThan = false;

	public Transition(String event, State destination) {
		this.event = event;
		this.to = destination;
	}

	public Object getEvent() {
		return event;
	}

	public State getTarget() {
		return to;
	}

	public boolean hasSetOperation() {
		return hasSetOperation;
	}

	public boolean hasIncrementOperation() {
		return hasIncrementOperation;
	}

	public boolean hasDecrementOperation() {
		return hasDecrementOperation;
	}

	public Object getOperationVariableName() {
		return opVar;
	}

	public boolean isConditional() {
		return isConditionEqual || isConditionLessThan || isConditionGreaterThan;
	}

	public Object getConditionVariableName() {
		return condVar;
	}

	public Integer getConditionComparedValue() {
		return compareValue;
	}

	public Integer getOperationalValue() {
		return this.operationalValue;
	}

	public boolean isConditionEqual() {
		return isConditionEqual;
	}

	public boolean isConditionGreaterThan() {
		return isConditionGreaterThan;
	}

	public boolean isConditionLessThan() {
		return isConditionLessThan;
	}

	public boolean hasOperation() {
		return hasSetOperation || hasIncrementOperation || hasDecrementOperation;
	}

	public void setHasSetOperation(boolean hasSetOperation) {
		this.hasSetOperation = hasSetOperation;
	}

	public void setHasIncrementOperation(boolean hasIncrementOperation) {
		this.hasIncrementOperation = hasIncrementOperation;
	}

	public void setHasDecrementOperation(boolean hasDecrementOperation) {
		this.hasDecrementOperation = hasDecrementOperation;
	}

	public void setConditionEqual(boolean isConditionEqual) {
		this.isConditionEqual = isConditionEqual;
	}

	public void setConditionGreaterThan(boolean isConditionGreaterThan) {
		this.isConditionGreaterThan = isConditionGreaterThan;
	}

	public void setConditionLessThan(boolean isConditionLessThan) {
		this.isConditionLessThan = isConditionLessThan;
	}

	public void setOperationalVariable(String opVar) {
		this.opVar = opVar;
	}

	public void setConditionalVariable(String condVar) {
		this.condVar = condVar;
	}

	public void setCompareValue(int comp) {
		this.compareValue = comp;
	}

	public void setOperationalValue(int opVal) {
		this.operationalValue = opVal;
	}

}
