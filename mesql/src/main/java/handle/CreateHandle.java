package handle;

import Enity.Db;
import Enity.Table;
import exception.TableHasBeenCreateException;
import groovy.lang.GroovyClassLoader;
import client.Context;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * TODO
 *
 * @author ahao 2020-08-19
 */
public class CreateHandle {
    /**
     * 数据库创建
     *
     * @param dbName
     */
    public static void createDb(String dbName) {
        //注册到全局变量中
        Map<String, Db> map = Context.context.getMap();
        Db db = new Db();
        db.setDbName(dbName);
        map.put(dbName, db);
    }

    /**
     * 表的创建
     */
    public static void createTb(String tbName, String dbName, String structure) throws TableHasBeenCreateException, IOException {

        Map<String, Db> map = Context.context.getMap();
        Db db = map.get(dbName);
        //表的注册
        Map<String, Table> tableMap = db.getTables();
        Table table = tableMap.get(tbName);
        if (table != null) {
            throw new TableHasBeenCreateException("此表已存在");
        } else {
            //jvm 加载此类的字节码
            Object o = StringParseObj(tbName, structure);
            //往数据库添加此表
            Table<Integer, Object> tb = new Table<>();
            tableMap.put(tbName, tb);
        }
    }

    /**
     * structure 数据格式  name 类型,name 类型
     *
     * @param tbName
     * @param structure
     * @return
     */
    private static Object StringParseObj(String tbName, String structure) throws IOException {
        String packageStr = "package Enity;\n";
        String classHead = "public class " + tbName + " " + "{\n";
        StringBuilder attributes = new StringBuilder();
        StringBuilder function = new StringBuilder();
        StringBuilder constructor = new StringBuilder();
//        //解析所传数据
//        String[] split = structure.split(",");
//        for (String s : split) {
//            String[] s1 = s.split("\\s+");
//            attributes.append("\t" + s1[1] + " " + s1[0] + ";\n");
//        }
//        //有参 无参构造函数生成
//        constructor.append("\tpublic "+tbName+" (");
//        StringBuilder constructorContent = new StringBuilder();
//        for (String s : split) {
//            String[] s1 = s.split("\\s+");
//            constructor.append(s1[1]+" "+s1[0]+", ");
//            constructorContent.append("\tthis."+s1[0]+"="+s1[0]+";\n\t");
//        }
//        constructor.deleteCharAt(constructor.length()-2);
//        constructor.append(") {\n\t"+constructorContent.toString()+"\n\t}\n");
//
//
//
//        //get set 方法生成
//        for (String s : split) {
//            String[] s1 = s.split("\\s+");
//            function.append("\t" + "public " + s1[1] + " get" + s1[0] + "()" + "{\n" + "     return this." + s1[0] + ";\n\t}\n");
//            function.append("\tpublic void set" + s1[0] + "(" + s1[1] + " " + s1[0] + ") {\n\t" + "this." + s1[0] + "=" + s1[0] + ";\n\t}\n");
//        }

        //解析所传数据
        String[] split = structure.split(",");
        for (String s : split) {
            String[] s1 = s.split("\\s+");
            attributes.append("\t" + "String" + " " + s1[0] + ";\n");
        }
        //有参 无参构造函数生成
        constructor.append("\tpublic "+tbName+" (");
        StringBuilder constructorContent = new StringBuilder();
        for (String s : split) {
            String[] s1 = s.split("\\s+");
            constructor.append("String"+" "+s1[0]+", ");
            constructorContent.append("\tthis."+s1[0]+"="+s1[0]+";\n\t");
        }
        constructor.deleteCharAt(constructor.length()-2);
        constructor.append(") {\n\t"+constructorContent.toString()+"\n\t}\n");



        //get set 方法生成
        for (String s : split) {
            String[] s1 = s.split("\\s+");
            function.append("\t" + "public " + "String" + " get" + s1[0] + "()" + "{\n" + "     return this." + s1[0] + ";\n\t}\n");
            function.append("\tpublic void set" + s1[0] + "(" + "String" + " " + s1[0] + ") {\n\t" + "this." + s1[0] + "=" + s1[0] + ";\n\t}\n");
        }
        String strObj = packageStr + classHead + attributes.toString() + constructor.toString() +function.toString() + "}";

        create(tbName, strObj);

        return new GroovyClassLoader().parseClass(strObj);
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException, TableHasBeenCreateException {
        System.out.println(StringParseObj("Student","uname String,age int"));
//        Class<?> aClass = Class.forName("Enity.Student");
//        System.out.println(aClass);
//        createDb("test");
//
//        createTb("Person", "test", "uname String,age int");
//        createTb("Person", "test", "uname String,age int");


    }

    public static void create(String tbName, String content) throws IOException {
        Path path = Paths.get("D:\\studyworkspace\\mesql\\src\\main\\java\\Enity\\" + tbName + ".java");
        Path file = Files.write(path, content.getBytes());
    }

}
