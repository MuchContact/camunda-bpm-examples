package org.camunda.bpm.spring.boot.example.web.listener;

import org.camunda.bpm.engine.ProcessEngineServices;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.stereotype.Component;

@Component
public class Listener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        TypedValue invoice = delegateExecution.getVariableTyped("invoice", false);
        delegateExecution.setVariable("ni", invoice);
//        ProcessEngineServices engineServices = delegateExecution.getProcessEngineServices();
//        RuntimeService runtimeService = engineServices.getRuntimeService();
//        runtimeService.setVariable();
    }
}
