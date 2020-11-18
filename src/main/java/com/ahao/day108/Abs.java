package com.ahao.day108;

class Sub extends Parent {
    int x=30;
    public static void main(String a[ ]) {
        Parent x= new Sub();
        Object o = new Object();

        x.dosomething();
    }
    @Override
    void dosomething() {System.out.print("努力"+x); }
}

