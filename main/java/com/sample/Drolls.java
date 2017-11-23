package com.sample;

import javax.swing.JFrame;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Drolls
{
	KieServices ks;
    KieContainer kContainer;
    KieSession kSession;
	public Drolls(JFrame frame)
	{
		try
		{
			ks = KieServices.Factory.get();
    		kContainer = ks.getKieClasspathContainer();
    		kSession = kContainer.newKieSession("ksession-rules");
    		kSession.setGlobal("frame", frame);
    		kSession.fireAllRules();
		
    	} catch (Throwable t) {
    		t.printStackTrace();
    	}
		
	}
}
