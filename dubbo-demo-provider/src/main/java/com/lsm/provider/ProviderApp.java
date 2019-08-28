package com.lsm.provider;

import com.lsm.api.GreetingService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.container.spring.SpringContainer;
import org.apache.dubbo.registry.NotifyListener;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;
import org.apache.dubbo.registry.RegistryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class ProviderApp {

//    public static void main(String[] args) throws Exception {
//        String registryUrl = "zookeeper://appjishu.com:2181";
//
//        ServiceConfig<GreetingService> serviceConfig = new ServiceConfig<GreetingService>();
//        serviceConfig.setApplication(new ApplicationConfig("first-dubbo-provider"));
//        serviceConfig.setRegistry(new RegistryConfig(registryUrl));
//        serviceConfig.setInterface(GreetingService.class);
//        serviceConfig.setRef(new GreetingServiceImpl());
//        serviceConfig.setDynamic(true);
//        serviceConfig.export();
//        List<URL> urlList = serviceConfig.getExportedUrls();
//
//        while (true) {
//            Thread.sleep(1000);
//        }
//    }

    public void start() {
        System.out.println("ProviderApp started");
        String registryUrl = "zookeeper://appjishu.com:2181";

        ServiceConfig<GreetingService> serviceConfig = new ServiceConfig<GreetingService>();
        serviceConfig.setApplication(new ApplicationConfig("first-dubbo-provider"));
        serviceConfig.setRegistry(new RegistryConfig(registryUrl));
        serviceConfig.setInterface(GreetingService.class);
        serviceConfig.setRef(new GreetingServiceImpl());
        serviceConfig.setDynamic(true);
        serviceConfig.setVersion("1.0.0");
        serviceConfig.export();
        System.out.println("===GreetingService is exported");
    }


    private static void testRegisterService() {
//        (String protocol, String username, String password, String host, int port, String path)


//        2.2. 获取注册中心：url.setProtocol(url.getParameter("registry", "dubbo"))
//        GETREGISTRY(dubbo://registry-address/com.alibaba.dubbo.registry.RegistrySerevice)

//        URL url = new URL(RegistryConstant.PROTOCOL, RegistryConstant.USERNAME, RegistryConstant.PASSWORD, RegistryConstant.HOST, RegistryConstant.PORT, RegistryConstant.PATH_REGISTRY_SERVICE);

//        ReferenceConfig reference = new ReferenceConfig();
//        reference.setId("registryService");
//        String address = "zookeeper://appjishu.com";
//        reference.setRegistry(new RegistryConfig(address));
//        reference.setInterface(RegistryService.class);
////        reference.setTimeout(5000);
//        reference.setApplication(new ApplicationConfig("myApp"));
//
//        RegistryService registryService = null;
//        try {
//            registryService = (RegistryService) reference.get();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("dubbo.xml");
//        appContext.start();

//        ClassPathXmlApplicationContext appContext1 = SpringContainer.getContext();
//        RegistryService registryService = (RegistryService) appContext1.getBean("registryService");
//        System.out.println("-----doIt()---->>>");
//        registryService.subscribe(url, new NotifyListener() {
//            public void notify(List<URL> urls) {
//                System.out.println("step in here");
//                System.out.println("size =" + urls.size());
//                System.out.println("urls=" + urls);
//            }
//        });

//        RegistryContainer container = new RegistryContainer();
//        container.start();

//        RegistryService registryService = (RegistryService) appContext.getBean("registryService");
//        System.out.println(">>>registryService=" + registryService);


//        URL url = new URL(RegistryConstant.PROTOCOL, RegistryConstant.USERNAME, RegistryConstant.PASSWORD, RegistryConstant.HOST, RegistryConstant.PORT, RegistryConstant.PATH_REGISTRY_SERVICE);
//
//        ReferenceConfig reference = new ReferenceConfig();
//        reference.setId("registryService");
//        String address = "zookeeper://appjishu.com";
//        reference.setRegistry(new RegistryConfig(address));
//        reference.setInterface(RegistryService.class);
////        reference.setTimeout(5000);
//        reference.setApplication(new ApplicationConfig("myApp"));
//
//        RegistryService registryService = null;
//        try {
//            registryService = (RegistryService) reference.get();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        registry.register(URL.valueOf("memcached://10.20.153.11/com.foo.BarService?category=providers&dynamic=false&application=foo"));
//        通常由脚本监控中心页面等调用 ↩︎


    }
}
