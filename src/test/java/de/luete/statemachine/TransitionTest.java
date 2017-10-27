package de.luete.statemachine;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TransitionTest
{
    private StateMachine<States> _stateMachine;

    public enum States implements IState
    {
	INITIAL, SECOND, TROLL, FOURTH, FOURTY_TWO, FINISH;

	@Override
	public void enter()
	{
	    System.out.println("Entered State: " + this.name());
	}

	@Override
	public void exit()
	{
	    System.out.println("Exited State: " + this.name());
	}
    }

    @Before
    public void setUp()
    {
	List<StateTransition<TransitionTest.States>> transitions = new ArrayList<>();
	transitions.add(new StateTransition<>(States.INITIAL, States.SECOND));
	transitions.add(new StateTransition<>(States.SECOND, States.TROLL));
	transitions.add(new StateTransition<>(States.SECOND, States.INITIAL));
	transitions.add(new StateTransition<>(States.TROLL, States.FOURTY_TWO));
	transitions.add(new StateTransition<>(States.FOURTY_TWO, States.FOURTH));
	transitions.add(new StateTransition<>(States.FOURTH, States.FINISH));

	_stateMachine = new StateMachine<>(States.INITIAL, transitions);
    }

    @Test
    public void testTransitions_Valid()
    {
	_stateMachine.triggerTransition(States.SECOND);
	_stateMachine.triggerTransition(States.INITIAL);
	_stateMachine.triggerTransition(States.SECOND);
	_stateMachine.triggerTransition(States.TROLL);
	_stateMachine.triggerTransition(States.FOURTY_TWO);
	_stateMachine.triggerTransition(States.FOURTH);
	_stateMachine.triggerTransition(States.FINISH);
    }

    @Test(expected = IllegalStateException.class)
    public void testTransitions_Invalid()
    {
	_stateMachine.triggerTransition(States.SECOND);
	_stateMachine.triggerTransition(States.INITIAL);
	_stateMachine.triggerTransition(States.SECOND);
	_stateMachine.triggerTransition(States.TROLL);
	_stateMachine.triggerTransition(States.FOURTY_TWO);
	_stateMachine.triggerTransition(States.FOURTH);
	_stateMachine.triggerTransition(States.FINISH);
	_stateMachine.triggerTransition(States.FOURTH);
    }
}
