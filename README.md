# RAPI-Demo
1.动态代理解决复杂的通信细节
2.反射应用类名、方法名、参数等信息完成服务实体的初始化

## RPC定义
一种分布式环境下的通信方式。
远程过程调用,网络中机器A通过网络与机器B建立连接,A发送一些参数给B,B执行某个过程,并把结果返回给A.

a.代理问题

b.服务实例化问题

c.序列化问题

d.通信问题

## RPC通信协议
HTTP\TCP-UDP等
## RPC序列化方案
java.Serializable\Hession\protobuf\Thrift\json\xml

## RPC架构
1.服务发现 
2.服务治理
3.负载均衡

