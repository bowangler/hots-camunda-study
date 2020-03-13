package cn.hots.ch10;

import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.DeploymentBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wangb on 2020/3/1.
 */
public class TaskServiceTest {
    public IdentityService identityService;
    AuthorizationService authorizationService;
    ProcessEngineConfigurationImpl processEngineConfiguration;
    ManagementService managementService;
    RepositoryService repositoryService;
    RuntimeService runtimeService;
    TaskService taskService;
    HistoryService historyService;
    @Before
    public void init() {
        processEngineConfiguration = (ProcessEngineConfigurationImpl) ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("cn/hots/ch10/camunda.cfg.xml");
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        identityService = processEngine.getIdentityService();
        authorizationService = processEngine.getAuthorizationService();
        managementService = processEngine.getManagementService();
        repositoryService = processEngine.getRepositoryService();
        runtimeService=processEngine.getRuntimeService();
        taskService=processEngine.getTaskService();
        historyService=processEngine.getHistoryService();
    }

    /**
     * 部署指定路径下的流程模板文件
     */
    @Test
    public void createDeployment() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("测试请假流程")
                .source("本地测试")
                .tenantId("a")
                .addClasspathResource("cn/hots/ch10/leave.bpmn")
                        // .nameFromDeployment("101")
                .deploy();
        System.out.println(deploymentBuilder);
        System.out.println(deployment);
    }
    @Test
    public void startProcesInstanceByKey() {
        runtimeService.startProcessInstanceByKey("leave");
    }

}
