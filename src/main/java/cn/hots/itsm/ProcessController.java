package cn.hots.itsm;

import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangb on 2020/3/13.
 */
public class ProcessController {
    @Autowired
    IdentityService identityService;
    @Autowired
    AuthorizationService authorizationService;
    @Autowired
    ProcessEngineConfigurationImpl processEngineConfiguration;
    @Autowired
    ManagementService managementService;
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    HistoryService historyService;
}
