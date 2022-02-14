package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {

	private Machine machine;
	private State currentState;

	public void run(Machine m) {
		this.machine = m;
		currentState = machine.getInitialState();
	}

	public State getCurrentState() {
		return currentState;
	}

	public void processEvent(String event) {
		
		System.out.println(currentState.getName());
		System.out.println(event);
		
		if (!(currentState.getTransitionByEvent(event) == null)) {
			
			Transition transition = currentState.getTransitionByEvent(event);
			boolean condition = true;

			if (transition.isConditional()) {
				String condName = (String) transition.getConditionVariableName();
				int compare = transition.getConditionComparedValue();

				if (transition.isConditionEqual()) {
					condition = compare == machine.getInteger(condName);
				}

				if (transition.isConditionGreaterThan()) {
					condition = compare < machine.getInteger(condName);
				}

				if (transition.isConditionLessThan()) {
					condition = compare > machine.getInteger(condName);
				}
			}
			
			if (transition.hasOperation() && condition) {
				String opName = (String) transition.getOperationVariableName();
				int opVal = transition.getOperationalValue();

				if (transition.hasSetOperation()) {
					machine.setInteger(opName, opVal);
				}
				if (transition.hasIncrementOperation()) {
					machine.setInteger(opName, machine.getInteger(opName) + 1);
				}
				if (transition.hasDecrementOperation()) {
					machine.setInteger(opName, machine.getInteger(opName) - 1);
				}
			}
			
			if (condition) {
				currentState = transition.getTarget();
			}
		}
	}

	public int getInteger(String string) {
		return machine.getInteger(string);
	}

}
