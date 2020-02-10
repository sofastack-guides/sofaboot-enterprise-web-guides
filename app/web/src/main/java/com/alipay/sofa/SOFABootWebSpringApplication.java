package com.alipay.sofa;

import com.alipay.sofa.endpoint.facade.SampleRestFacade;
import com.alipay.sofa.endpoint.impl.SampleRestFacadeRestImpl;
import com.alipay.sofa.endpoint.model.DemoUserModel;
import com.alipay.sofa.endpoint.response.RestSampleFacadeResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Slite2WebSpringBootApplication
 * <p/>
 * Created by yangguanchao on 16/7/22.
 */
@ImportResource({"classpath*:META-INF/sofaboot-enterprise-web-guides/*.xml"})
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SOFABootWebSpringApplication {

    // init the logger
    private static final Logger logger = LoggerFactory.getLogger(SOFABootWebSpringApplication.class);

    public static void main(String[] args){

        SpringApplication springApplication = new SpringApplication(SOFABootWebSpringApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);

        if (logger.isInfoEnabled()){
            logger.info("application start");
        }

        SampleRestFacade sampleRestFacade = applicationContext.getBean("sampleRestFacadeRest", SampleRestFacadeRestImpl.class);

        DemoUserModel demoUserModel = new DemoUserModel();
        demoUserModel.setUserId(12);
        demoUserModel.setRealName("realName");
        demoUserModel.setUserName("userName");

        RestSampleFacadeResp<Integer> resp =  sampleRestFacade.addUserInfo(demoUserModel);

        if (logger.isInfoEnabled()) {
            logger.info("the resp id is " + resp.getData());
        }

    }
}
