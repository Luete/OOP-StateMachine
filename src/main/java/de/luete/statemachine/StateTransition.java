package de.luete.statemachine;

public class StateTransition<StateType extends IState>
{
	private final StateType m_fromState;
	private final StateType m_toState;

	public StateTransition(StateType fromState, StateType toState)
	{
		this.m_fromState = fromState;
		this.m_toState = toState;
	}

	public StateType getFromState()
	{
		return m_fromState;
	}

	public StateType getTargetState()
	{
		return m_toState;
	}
	
	public boolean equals(StateTransition<StateType> other)
	{
		boolean l_areEqual = true;

		l_areEqual &= this.getFromState().equals(other.getFromState());
		l_areEqual &= this.getTargetState().equals(other.getTargetState());
		
		return l_areEqual;
	}
	
	
}
