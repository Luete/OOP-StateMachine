package de.luete.statemachine;

public class InvalidTransitionException extends Exception
{
    private static final long serialVersionUID = -5089793791953991070L;

    public InvalidTransitionException(String string)
    {
	super(string);
    }
}
