package com.sample;

import javax.swing.*;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MyFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 150;
    private JButton display;
    private JPanel panel;
    private JButton[] answer;
    private Drolls drolls;
    //konstruktor
    
    public MyFrame()
    {
    	setTitle("Which director's movies should I watch?");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setLayout(new BorderLayout());
        
        display = new JButton("No dalej licz to!");
        display.setEnabled(false);
        add(display,BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        add(panel,BorderLayout.CENTER);
        answer = new JButton[3];
        ButtonClicked action = new ButtonClicked();
        answer[0] = addButton("a", action);
        answer[1] = addButton("b", action);
        answer[2] = addButton("c", action);
        
        drolls = new Drolls(this);
        pack();
    }
    
    public void setDisplayText(String text)
    {
    	this.display.setText(text);
    }
    
    public void setButtonText(int indexButton, String text )
    {
    	answer[indexButton].setText(text);
    }
    
    private JButton addButton(String label, ActionListener listener) //z ButtonClicked tez dziala. z ActionListener jest poprawniej? Wg mnie bardziej intuicyjnie jest z tym 1
    {
        JButton button = new JButton(label);
        panel.add(button);
        button.addActionListener(listener);
        return button;
    }
    
    private class ButtonClicked implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent event)
        {
        	
        	String input = event.getActionCommand();
        	drolls.kSession.insert(new Answer (input));
        	drolls.kSession.fireAllRules();
        }
    }
    
    public static class Answer
    {
    	private String answer;
    	public Answer(String answer)
    	{
    		this.answer = answer;
    	}
    	
    	public String getAnswer()
    	{
    		return answer;
    	}
    }
    
}
