package cn.hots.ch1;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.ProcessEngines;

/**
 * Created by wangb on 2020/2/28.
 */
public class ProcessEngineTest {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
        String name = processEngine.getName();
        System.out.println(name);
        ProcessEngineConfiguration processEngineConfiguration = processEngine.getProcessEngineConfiguration();
        System.out.println("流程引擎配置类" + processEngineConfiguration);
    }
}
