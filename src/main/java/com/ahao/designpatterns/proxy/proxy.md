**代理模式<结构型>** :<br>
    **代理的意图**<br>
        为其他对象提供一种代理以控制对这个对象的访问
    **静态代理**
        1.创建被代理类顶层接口<br>
        2.被代理类实现顶层接口 代理类也要实现顶层接口保证行为一致<br>
        3.被代理类持有代理类 <br>
      **优点**
        在不修改被代理的源码的情况下 扩展被代理类的功能
      **缺点**
        硬编码 一旦被代理类增方法 代理类同样要修改
        
        