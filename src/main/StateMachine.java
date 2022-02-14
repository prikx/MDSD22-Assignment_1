package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {
	
	private List<State> states = new ArrayList<>();
	private Map<String, Integer> integers = new HashMap<>();
	
	private State currentState;
	private State initialState;
	private String eventCall;
	private Transition currentTran;
	

	public Machine build() {
		Machine m = new Machine(states, initialState, integers);
		return m;
	}

	public StateMachine state(String string) {
		currentState = getState(string);
		return this;
	}
	
	public State getState(String name) {
		for(State s : states) {
			if(s.getName().equals(name)) {
				return s;
			}
		}
		
		State state = new State(name);
		states.add(state);
		return state;
		
	}

	public StateMachine initial() {
		initialState = currentState;
		return this;
	}

	public StateMachine when(String string) {
		eventCall = string;
		return this;
	}

	public StateMachine to(String string) {
		State destination = getState(string);
		
		Transition tran = new Transition(eventCall, destination);
		currentTran = tran;
		currentState.addTransition(tran);
		return this;
	}

	public StateMachine integer(String string) {
		integers.put(string, 0);
		return this;
	}

	public StateMachine set(String string, int i) {
		currentTran.setOperationalVariable(string);
		currentTran.setOperationalValue(i);
		currentTran.setHasSetOperation(true);
		return this;
	}

	public StateMachine increment(String string) {
		currentTran.setOperationalVariable(string);
		currentTran.setHasIncrementOperation(true);
		return this;
	}

	public StateMachine decrement(String string) {
		currentTran.setOperationalVariable(string);
		currentTran.setHasDecrementOperation(true);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		currentTran.setConditionalVariable(string);
		currentTran.setCompareValue(i);
		currentTran.setConditionEqual(true);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		currentTran.setCompareValue(i);
		currentTran.setConditionalVariable(string);
		currentTran.setConditionGreaterThan(true);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		currentTran.setCompareValue(i);
		currentTran.setConditionalVariable(string);
		currentTran.setConditionLessThan(true);
		return this;
	}

}
