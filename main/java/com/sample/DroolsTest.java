package com.sample;

import java.awt.EventQueue;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	
    public static final void main(String[] args) {
    	
    	EventQueue.invokeLater(() ->
        {
        	MyFrame frame = new MyFrame();
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }


}


