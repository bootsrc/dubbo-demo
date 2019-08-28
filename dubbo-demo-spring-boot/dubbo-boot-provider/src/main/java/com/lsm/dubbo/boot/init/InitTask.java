package com.lsm.dubbo.boot.init;

import com.alibaba.dubbo.common.Constants;
import org.apache.dubbo.common.URL;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.registry.RegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitTask implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(InitTask.class);

    @Reference(id = "registryService")
    private RegistryService registryService;

    @Override
    public void run(String... args) throws Exception {
        URL subscribeUrl = new URL(Constants.ADMIN_PROTOCOL, "appjishu.com", 2181, "",
                Constants.INTERFACE_KEY, Constants.ANY_VALUE, Constants.GROUP_KEY, Constants.ANY_VALUE,
                Constants.VERSION_KEY, Constants.ANY_VALUE, Constants.CLASSIFIER_KEY,
                Constants.ANY_VALUE, Constants.CATEGORY_KEY,
                Constants.PROVIDERS_CATEGORY + "," + Constants.CONSUMERS_CATEGORY + ","
                        + Constants.ROUTERS_CATEGORY + ","
                        + Constants.CONFIGURATORS_CATEGORY,
                Constants.ENABLED_KEY, Constants.ANY_VALUE, Constants.CHECK_KEY, String.valueOf(false));

        String urlText = subscribeUrl.toString();
        // admin://appjishu.com:2181?category=providers,consumers,routers,configurators&check=false&classifier=*&enabled=*&group=*&interface=*&version=*
        log.info("urlText={}", urlText);
        registryService.subscribe(subscribeUrl, urls -> {
            if (urls == null || urls.size() == 0) {
                log.info("====urls is null");
                return;
            }
            log.info("urls.size={}", urls.size());
            for (URL url : urls) {
                log.info(">>>>>url=" + url);
            }
        });
    }
}
