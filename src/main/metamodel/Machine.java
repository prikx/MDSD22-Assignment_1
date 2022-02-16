package main.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {

	private List<State> states = new ArrayList<State>();
	private State initialState;
	private Map<String, Integer> integers = new HashMap<>();

	public Machine(Collection<State> states, State initialState, Map<String, Integer> integers) {
		this.states.addAll(states);
		this.initialState = initialState;
		this.integers = integers;
	}

	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return initialState;
	}

	public State getState(String name) {
		for (State s : states) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}

	public int numberOfIntegers() {
		return integers.size();
	}

	public boolean hasInteger(String string) {
		return integers.containsKey(string);
	}

	public int getInteger(String string) {
		return integers.get(string);
	}

	public void setInteger(String string, int i) {
		if (hasInteger(string)) {
			integers.replace(string, i);
		}
	}

}
