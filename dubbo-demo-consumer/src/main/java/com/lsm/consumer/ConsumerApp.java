package com.lsm.consumer;

import com.lsm.api.GreetingService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.registry.NotifyListener;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;

import java.io.IOException;
import java.util.List;

public class ConsumerApp {
    public static void main(String[] args) throws Exception {
        String registryUrl = "zookeeper://appjishu.com:2181";

        ReferenceConfig<GreetingService> referenceConfig = new ReferenceConfig<GreetingService>();
        referenceConfig.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        referenceConfig.setRegistry(new RegistryConfig(registryUrl));
        referenceConfig.setInterface(GreetingService.class);
        GreetingService greetingService = referenceConfig.get();
        System.out.println(greetingService.sayHello("world"));


        RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
//        String providerUrlText = "dubbo://192.168.31.238:20880/com.lsm.api.GreetingService?anyhost=true&application=first-dubbo-provider&bind.ip=192.168.31.238&bind.port=20880&default.deprecated=false&default.dynamic=false&default.register=true&deprecated=false&dubbo=2.0.2&dynamic=false&generic=false&interface=com.lsm.api.GreetingService&methods=sayHello&pid=41067&register=true&release=2.7.1&side=provider";
        String providerUrlText = "dubbo://*/com.lsm.api.GreetingService?*";
//        String providerUrlText = "*://*/org.apache.dubbo.registry.RegistryService?*";
        Registry registry = registryFactory.getRegistry(URL.valueOf(registryUrl));

        URL providerURL = URL.valueOf(providerUrlText);
        registry.subscribe(providerURL, new NotifyListener() {
            @Override
            public void notify(List<URL> urls) {
                System.out.println(">>>>>>>>>>>>>>>>>>>notfiy>>>>>>>>>");
                if (urls ==null || urls.size()< 1) {
                    System.out.println("notify_urls=NULL");
                }

                System.out.println("notify_urls_size=" + urls.size());
                for (URL urlVar : urls) {
                    String serviceInterface = urlVar.getServiceInterface();
                    System.out.println("---url="+ urlVar);
                    System.out.println("---serviceInterface=" + serviceInterface);

                }
            }
        });
        System.out.println("run here>>>");

        String myUrlText = "dubbo://*/com.lsm.api.GreetingService?*";
//        String myUrlText = "dubbo://*/*?*";       //没有指名interface，是查不到结果的
        URL myURL = URL.valueOf(myUrlText);
        List<URL> findUrlList = registry.lookup(myURL);
        System.out.println("------");
        for (URL findUrl: findUrlList){
            System.out.println(">>>findUrl=" + findUrl);
        }

        for (; ; ) {
            Thread.sleep(1000);
        }
    }
}
