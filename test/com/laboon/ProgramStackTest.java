package com.laboon;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Test methods in ProgramStack class
 */



public class ProgramStackTest {
	
	
	// #############################################
	// ######### PINNING TESTS BY JASON LY #########
	// #############################################
	
	//	Ensure that negative values pushed to the stacked is correctly represented as a string.
	
	// A ProgramStack with one negative element should be represented by that one
    // element surrounded by brackets, e.g. "[-713]".
	@Test
    public void testToStringPushNegInt() {
	ProgramStack stack = new ProgramStack();
	stack.push(-713);
	assertTrue(stack.toString().equals("[-713]"));

    }
	
	//	Ensure that negative values pushed to the stacked is correctly represented as a string.
	
	// A ProgramStack with multiple negative elements should consist of the elements
    // in that Stack in order, separated by commas and spaces.
	@Test
    public void testToStringMultipleNeg() {
	ProgramStack stack = new ProgramStack();
	stack.push(-1);
	stack.push(-713);
	stack.push(-7);
	stack.push(-42);
	stack.push(-1000000);
	assertTrue(stack.toString().equals("[-1, -713, -7, -42, -1000000]"));

    }
	
	// Ensure that the string representation of the stack matches the changes to the stack.
	@Test
    public void testToStringAfterStackChanges() {
	ProgramStack stack = new ProgramStack();
	stack.push(0);
	stack.push(100);
	assertTrue(stack.toString().equals("[0, 100]"));
	stack.pop();
	assertTrue(stack.toString().equals("[0]"));

    }
	
	// Test implicit maximum boundary value
	
	// Ensure that if the maximum value for an integer is added to the stack that it's represented
	// appropriately as a string.
	@Test
    public void testToStringMaxInt() {
	ProgramStack stack = new ProgramStack();
	stack.push(Integer.MAX_VALUE);
	assertTrue(stack.toString().equals("[2147483647]"));

    }
	
	// Test implicit minimum boundary value
	
	// Ensure that if the minimum value for an integer is added to the stack that it's represented
	// appropriately as a string.
	@Test
    public void testToStringMinInt() {
	ProgramStack stack = new ProgramStack();
	stack.push(Integer.MIN_VALUE);
	assertTrue(stack.toString().equals("[-2147483648]"));

    }
	
	// ##################################
	// ######### EXISTING TESTS #########
	// ##################################

	
    // Test that pushing a positive integer (20) will result in the next
    // pop being that value.
    @Test
    public void testPositivePush() {
	ProgramStack stack = new ProgramStack();
	final int testVal = 20;
	stack.push(testVal);
	int topVal = stack.pop();
	assertEquals(testVal, topVal);
    }
    // Test that pushing a negative integer (-1) will result in the next
    // pop being that value.
    @Test
    public void testNegativePush() {
	ProgramStack stack = new ProgramStack();
	final int testVal = -1;
	stack.push(testVal);
	int topVal = stack.pop();
	assertEquals(testVal, topVal);
    }

    // Test that pushing a zero (0) will result in the next
    // pop being that value.
    @Test
    public void testZeroPush() {
	ProgramStack stack = new ProgramStack();
	final int testVal = 0;
	stack.push(testVal);
	int topVal = stack.pop();
	assertEquals(testVal, topVal);
    }

    // Popping a newly-created stack (with 0 elements) should return
    // 0 (and not an EmptyStackException like a normal Java stack would)
    @Test
    public void testPop0Elements() {
	ProgramStack stack = new ProgramStack();
	try {
	    int val = stack.pop();
	    assertEquals(val, 0);
	} catch (EmptyStackException esex) {
	    fail();
	}
    }

    // Peeking a newly-created stack (with 0 elements) should return
    // 0 (and not an EmptyStackException like a normal Java stack would)
    @Test
    public void testPeek0Elements() {
	ProgramStack stack = new ProgramStack();
	try {
	    int val = stack.peek();
	    assertEquals(val, 0);
	} catch (EmptyStackException esex) {
	    fail();
	}

    }

    // Popping an element with multiple elements should return the
    // top element only.
    @Test
    public void testPopWithManyElements() {
	ProgramStack stack = new ProgramStack();
	for (int j = 0; j < 10; j++) {
	    stack.push(j);
	}
	assertEquals(stack.pop(), 9);
	assertEquals(stack.pop(), 8);
	assertEquals(stack.pop(), 7);
    }
    
    // Peeking an element with multiple elements should return the
    // top element only.  The stack should remain the same, so
    // multiple peeks should return the same value.
    @Test
    public void testPeekWithManyElements() {
	ProgramStack stack = new ProgramStack();
	for (int j = 0; j < 10; j++) {
	    stack.push(j);
	}
	assertEquals(stack.peek(), 9);
    }

    // Pushing and popping multiple elements should not cause any problems.
    @Test
    public void testPushPopMultiple() {
	ProgramStack stack = new ProgramStack();
	int retVal = 0;
	for (int j = 0; j < 10; j++) {
	    stack.push(j);
	    assertEquals(stack.peek(), j);
	}
	for (int j = 0; j < 10; j++) {
	    assertEquals(stack.pop(), (9 - j));
	}
	assertEquals(stack.peek(), 0);
	
    }

    // An empty ProgramStack should be represented by the String "[]".
    @Test
    public void testToStringEmpty() {
	ProgramStack stack = new ProgramStack();
	assertTrue(stack.toString().equals("[]"));
    }
    
    // A ProgramStack with one element should be represented by that one
    // element surrounded by brackets, e.g. "[8]".
    @Test
    public void testToStringOne() {
	ProgramStack stack = new ProgramStack();
	stack.push(8);
	assertTrue(stack.toString().equals("[8]"));

    }
    
    // A ProgramStack with multiple elements should consist of the elements
    // in that Stack in order, separated by commas and spaces.
    @Test
    public void testToStringMultiple() {
	ProgramStack stack = new ProgramStack();
	stack.push(1);
	stack.push(2);
	stack.push(3);
	assertTrue(stack.toString().equals("[1, 2, 3]"));
    }
    
}
