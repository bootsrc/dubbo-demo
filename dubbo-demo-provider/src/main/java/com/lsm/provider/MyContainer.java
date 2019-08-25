package com.lsm.provider;

import org.apache.dubbo.container.Container;

    public class MyContainer implements Container {
    @Override
    public void start() {
        System.out.println("MyContainer started.");
        new ProviderApp().start();
    }

    @Override
    public void stop() {
        System.out.println("MyContainer stopped.");
    }
}
