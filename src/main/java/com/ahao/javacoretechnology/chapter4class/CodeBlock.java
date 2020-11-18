package com.ahao.javacoretechnology.chapter4class;

/**
 * @author ahao
 */
public class CodeBlock {
    private static int id ;
//    static {
//        System.out.println("aaaa");
//    }
    {
        id +=1;
        System.out.println("bbbb");
    }

    public int getId() {
        return id;
    }

    public void setId(int aId) {
        id = aId;
    }
}
