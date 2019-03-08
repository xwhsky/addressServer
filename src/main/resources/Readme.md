![全文](https://img-blog.csdn.net/20151118190949363?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

顺序从上到下依次为：

详细说明：https://blog.csdn.net/qq598535550/article/details/51703190


dao： 数据访问层（接口）。与数据打交道，可以是数据库操作，也可以是文件读写操作，甚至是redis缓存操作，总之与数据操作有关的都放在这里，也有人叫做dal或者数据持久层都差不多意思。为什么没有daoImpl，因为我们用的是mybatis，所以可以直接在配置文件中实现接口的每个方法。

entitiy:实体类。一般与数据库的表相对应，封装dao层取出来的数据为一个对象，也就是我们常说的pojo，一般只在dao层与service层之间传输。

service：业务逻辑（接口）。写我们的业务逻辑，也有人叫bll，在设计业务接口时候应该站在“使用者”的角度。额，不要问我为什么这里没显示！IDE调皮我也拿它没办法~

serviceImpl：业务逻辑（实现）。	实现我们业务接口，一般事务控制是写在这里，没什么好说的。

web：	控制器。springmvc就是在这里发挥作用的，一般人叫做controller控制器，相当于struts中的action。