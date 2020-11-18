package com.ahao.designpatterns.composite;

/**
 * @author ahao
 */
public class Client {

    public static void main(String[] args) {
        Component root = new Composite("D盘");
        Component favoriteDir = new Composite("收藏夹");
        Component picDir = new Composite("图片");
        picDir.addChild(new Leaf("img1.png"));
        picDir.addChild(new Leaf("img2.png"));


        Component workDir = new Composite("工作");
        workDir.addChild(new Leaf("需求文档.doc"));
        Component learningDir = new Composite("学习");
        learningDir.addChild(new Leaf("Java笔记.md"));
        learningDir.addChild(new Leaf("数据库笔记.doc"));

        root.addChild(favoriteDir);
        root.addChild(workDir);
        root.addChild(learningDir);
        root.addChild(picDir);
        root.addChild(new Leaf("log.txt"));


        root.printStruct("");

    }

}
