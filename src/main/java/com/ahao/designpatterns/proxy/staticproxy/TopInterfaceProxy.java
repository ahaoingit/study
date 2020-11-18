package com.ahao.designpatterns.proxy.staticproxy;

/**
 * TODO
 *
 * @author ahao 2020-10-06
 */
public class TopInterfaceProxy implements TopInterface{
    private TopInterface topInterface ;

    public TopInterfaceProxy(TopInterface topInterface) {
        this.topInterface = topInterface;
    }

    /***.
     *@author ahao
     *@date 2020-10-06 10:31
     *@return
     *顶层接口
     */
    @Override
    public void print() {
        System.out.println("proxy方法增强");
        topInterface.print();
    }
}
