package com.lsm.provider;

public class RegistryConstant {
//    String protocol, String username, String password, String host, int port, String path
//        GETREGISTRY(dubbo://registry-address/com.alibaba.dubbo.registry.RegistrySerevice)
    public static final String PROTOCOL = "zookeeper";
    public static final String USERNAME = null;
    public static final String PASSWORD= null;
    public static final String HOST = "appjishu.com";
    public static final int PORT = 2181;

    public static final String PATH_REGISTRY_SERVICE = "com.alibaba.dubbo.registry.RegistrySerevice";
}
