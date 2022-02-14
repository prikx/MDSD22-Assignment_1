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
		currentState.getTransitionByEvent(event); // NOT FINISHED
		
	}

	public int getInteger(String string) {
		return 0;
	}

}
