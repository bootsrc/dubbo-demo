## 代码说明

1.请问dubbo-demo-provider/src/main/resources/assembly/bin下的start.sh,stop.sh等几个shell脚本是哪里来的？

答案：maven下载了dubbo后，在idea里可以直接看到dubbo-2.7.1.jar里的META-INF/assembly/bin下有6个脚本，包括shell和windows下的batch脚本。
如下图 
![](/doc/img/shell.png)

我们可以自己把这些脚本拷贝到dubbo-demo-provider/src/main/resources/assembly/bin下

## 部署

部署脚本可以参考 [dubbo-demo-provider/deploy/package.sh](dubbo-demo-provider/deploy/package.sh)
```shell script
mvn clean package -Denv=dev
```
得到tar.gz包后，解压，并允许bin/start.sh即可启动provider端，日志在logs/stdout.log

## IDE上debug
添加一个Launcher对应对启动Application, 例如IDEA应该配置VM options
```shell script
-Ddubbo.container=spring,my
```
如下图 ![](/doc/img/debug.png)