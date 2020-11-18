

import Enity.User;
import groovy.lang.GroovyClassLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test {

    @org.junit.Test
    public void testGroovyClassLoader() throws Exception {

        //groovy提供了一种将字符串文本代码直接转换成Java Class对象的功能
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        //里面的文本是Java代码,但是我们可以看到这是一个字符串我们可以直接生成对应的Class<?>对象,而不需要我们写一个.java文件
        Class<?> clazz = groovyClassLoader.parseClass("package Enity;\n" +
                "\n" +
                "/**\n" +
                " * TODO\n" +
                " *\n" +
                " * @author ahao 2020-08-19\n" +
                " */\n" +
                "public class User {\n" +
                "    int id;\n" +
                "    String name;\n" +
                "\n" +
                "    public User() {\n" +
                "    }\n" +
                "\n" +
                "    public int getId() {\n" +
                "        return this.id;\n" +
                "    }\n" +
                "\n" +
                "    public String getName() {\n" +
                "        return this.name;\n" +
                "    }\n" +
                "\n" +
                "    public void setId(int id) {\n" +
                "        this.id = id;\n" +
                "    }\n" +
                "\n" +
                "    public void setName(String name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "\n" +
                "    public boolean equals(final Object o) {\n" +
                "        if (o == this) return true;\n" +
                "        if (!(o instanceof User)) return false;\n" +
                "        final User other = (User) o;\n" +
                "        if (!other.canEqual((Object) this)) return false;\n" +
                "        if (this.getId() != other.getId()) return false;\n" +
                "        final Object this$name = this.getName();\n" +
                "        final Object other$name = other.getName();\n" +
                "        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;\n" +
                "        return true;\n" +
                "    }\n" +
                "\n" +
                "    protected boolean canEqual(final Object other) {\n" +
                "        return other instanceof User;\n" +
                "    }\n" +
                "\n" +
                "    public int hashCode() {\n" +
                "        final int PRIME = 59;\n" +
                "        int result = 1;\n" +
                "        result = result * PRIME + this.getId();\n" +
                "        final Object $name = this.getName();\n" +
                "        result = result * PRIME + ($name == null ? 43 : $name.hashCode());\n" +
                "        return result;\n" +
                "    }\n" +
                "\n" +
                "    public String toString() {\n" +
                "        return \"User(id=\" + this.getId() + \", name=\" + this.getName() + \")\";\n" +
                "    }\n" +
                "}\n");

        //构造函数的获取
        Constructor<?>[] constructors = clazz.getConstructors();
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Object o = declaredConstructor.newInstance();
        Method setId = clazz.getDeclaredMethod("setId",int.class);
        setId.invoke(o,12);

        //获取类名
        String name = clazz.getName();
        System.out.println(name);
        System.out.println(o);

        Class<?> aClass = Class.forName("Enity.User");
        System.out.println(aClass.getName());
        User user = new User();
    }
}
