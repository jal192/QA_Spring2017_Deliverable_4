package com.laboon;

import java.util.*;

/*

	Refactored Method: toString() - Starts on line 86

*/

/**
 * The program stack.
 */

public class ProgramStack {

    /**
     * The internal stack which holds these values.
     * Because of the differences between the Befunge stack and
     * the Java stack (chiefly, an empty Befunge stack returns 0
     * when empty, whereas the Java version throws an 
     * EmptyStackException), a "wrapper" class was made.
     */
    
    private Stack<Integer> _stack = new Stack<Integer>();

    /**
     * Default constructor (no elements on stack)
     */

    public ProgramStack() {
	// This space deliberately kept blank
    }
    
    /**
     * Push an int value onto the stack.
     * @param val value to push
     */
    
    public void push(int val) {
	_stack.push(new Integer(val));
    }

    /**
     * Pop an int value off of the stack.
     * If stack is empty, return 0.
     * @return int - last-input value on stack
     */
    
    public int pop() {
	try {
	    Integer val = _stack.pop();
	    return val.intValue();
	} catch (EmptyStackException esex) {
	    return 0;
	}

    }

    /**
     * View the top int value on the stack WITHOUT popping
     * If stack is empty, return 0.
     * @return int - last-input value on stack
     */

    
    public int peek() {
	try {
	    Integer val = _stack.peek();
	    return val.intValue();
	} catch (EmptyStackException esex) {
	    return 0;
	}
    }
	
	// ############################################
	// ####### Refactored Version of Method #######
	// ############################################
	
    /**
     * Return String version of the stack for output.
     * @return String string version of stack
     */
    
	// Modified
    public String toString() {
	
	if (_stack.size() == 0) {
	    return new String("[]");
	}
	if (_stack.size() == 1) {
	    return new String("[" + _stack.peek() + "]");
	}
	
	String toReturn = new String("[");
	for (Integer i: _stack) {
	    toReturn += "" + i.intValue() + ", ";
	}
	toReturn = toReturn.substring(0, toReturn.length() - 2) + "]";
	return toReturn;

    }
	
    
}
