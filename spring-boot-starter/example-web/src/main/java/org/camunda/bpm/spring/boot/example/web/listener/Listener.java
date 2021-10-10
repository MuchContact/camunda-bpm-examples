package org.camunda.bpm.spring.boot.example.web.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Listener implements ExecutionListener {
    protected static final Logger LOG = LoggerFactory.getLogger(Listener.class);

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        LOG.info("enter listener");
        TypedValue invoice = delegateExecution.getVariableTyped("invoice", false);
        LOG.info("{}", invoice);
        VariableMap ni = Variables.createVariables().putValueTyped("ni", invoice);
        delegateExecution.setVariables(ni);
    }
}
