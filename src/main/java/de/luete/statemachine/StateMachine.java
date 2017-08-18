package de.luete.statemachine;

import java.util.List;

public class StateMachine<StateType extends IState> extends AbstractStateMachine<StateType>
{

	private final List<StateTransition<StateType>> stateTransitions;

	public StateMachine(StateType initialState, List<StateTransition<StateType>> stateTransitions)
	{
		super(initialState);
		
		this.stateTransitions = stateTransitions;
	}

	@Override
	protected List<StateTransition<StateType>> getValidTransitions()
	{
		return stateTransitions;
	}

}
