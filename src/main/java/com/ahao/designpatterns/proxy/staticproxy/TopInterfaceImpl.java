package com.ahao.designpatterns.proxy.staticproxy;

/**
 * TODO
 *
 * @author ahao 2020-10-06
 */
public class TopInterfaceImpl implements TopInterface{
    /***.
     *@author ahao
     *@date 2020-10-06 10:31
     *@return
     *顶层接口
     */
    @Override
    public void print() {
        System.out.println("我是实现类");
    }
}
