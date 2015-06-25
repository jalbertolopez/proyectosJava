package mx.bbv.alerts.drools;

import org.drools.KnowledgeBase;
import org.drools.command.Command;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class RuleRunner {

	private StatelessKnowledgeSession ksession;

	private String ruleFile;

	public RuleRunner() {
	}
		

	public void setKsession(StatelessKnowledgeSession ksession) {
		this.ksession = ksession;
	}


	public <T> void runRules(Object fact) throws Exception {
		System.out.println("Loading file: " + ruleFile);
		ksession.execute(fact);
	}

	public String getRuleFile() {
		return ruleFile;
	}

	public void setRuleFile(String ruleFile) {
		this.ruleFile = ruleFile;
	}
}