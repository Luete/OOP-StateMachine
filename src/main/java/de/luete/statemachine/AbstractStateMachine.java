package de.luete.statemachine;

import java.util.List;

public abstract class AbstractStateMachine<StateType extends IState>
{
    protected StateType	m_initialState;
    protected StateType	m_currentState;

    public AbstractStateMachine(StateType initialState)
    {
	m_initialState = initialState;
	m_currentState = initialState;
    }

    public void triggerTransition(StateType targetState) throws IllegalStateException
    {
	boolean l_validTransition = validateTransition(new StateTransition<>(m_currentState, targetState));

	if (!l_validTransition)
	{
	    throw new IllegalStateException(
		    "Invalid state transition: '" + m_currentState + "' to '" + targetState + "'");
	}

	m_currentState.exit();
	m_currentState = targetState;

	targetState.enter();
    }

    protected abstract List<StateTransition<StateType>> getValidTransitions();

    protected boolean validateTransition(StateTransition<StateType> transition)
    {
	List<StateTransition<StateType>> l_transitions = getValidTransitions();
	boolean l_isValid = l_transitions.stream().anyMatch(validTransition -> areEqual(validTransition, transition));

	return l_isValid;
    }

    private boolean areEqual(StateTransition<StateType> from, StateTransition<StateType> to)
    {
	return from.equals(to);
    }
}
