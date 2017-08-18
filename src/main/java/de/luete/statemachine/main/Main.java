package de.luete.statemachine.main;

import java.util.ArrayList;
import java.util.List;

import de.luete.statemachine.IState;
import de.luete.statemachine.StateMachine;
import de.luete.statemachine.StateTransition;

public class Main
{
	public enum States implements IState
	{
		INITIAL,
		SECOND,
		TROLL,
		FOURTH,
		FOURTY_TWO,
		FINISH;
		

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
	
	public static void main(String[] args)
	{
		List<StateTransition<States>> transitions = new ArrayList<>();

		transitions.add(new StateTransition<Main.States>(States.INITIAL, States.SECOND));
		transitions.add(new StateTransition<Main.States>(States.SECOND, States.TROLL));
		transitions.add(new StateTransition<Main.States>(States.SECOND, States.INITIAL));
		transitions.add(new StateTransition<Main.States>(States.TROLL, States.FOURTY_TWO));
		transitions.add(new StateTransition<Main.States>(States.FOURTY_TWO, States.FOURTH));
		transitions.add(new StateTransition<Main.States>(States.FOURTH, States.FINISH));
		StateMachine<States> stateMachine = new StateMachine<States>(States.INITIAL, transitions);

		stateMachine.triggerTransition(States.SECOND);
		stateMachine.triggerTransition(States.INITIAL);
		stateMachine.triggerTransition(States.SECOND);
		stateMachine.triggerTransition(States.TROLL);
		stateMachine.triggerTransition(States.FOURTY_TWO);
		stateMachine.triggerTransition(States.FOURTH);
		stateMachine.triggerTransition(States.FINISH);
		stateMachine.triggerTransition(States.FOURTH);
	}
}
