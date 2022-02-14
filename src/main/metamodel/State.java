package main.metamodel;

import java.util.List;

public class State {
	
	private String name;

	public Object getName() {
		return name;
	}
	
	public State(String name) {
		this.name = name;
	}

	public List<Transition> getTransitions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Transition getTransitionByEvent(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
