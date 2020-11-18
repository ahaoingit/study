package com.ahao.designpatterns.proxy.staticproxy;

import org.junit.Test;

/**
 * TODO
 *
 * @author ahao 2020-10-06
 */
public class ProxyTest {
    @Test
    public void proxyTest() {
        TopInterface topInterface = new TopInterfaceImpl();
        TopInterfaceProxy topInterfaceProxy = new TopInterfaceProxy(topInterface);
        topInterfaceProxy.print();
    }
}
