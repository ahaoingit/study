package com.ahao.javacoretechnology.chapter4class;
import static java.lang.Math.*;
import static com.ahao.javacoretechnology.chapter4class.PrintUtils.print;
/**
 * @author ahao
 */
public class CodeBlockTest {
    /**
     * @deprecated 代码块 与 静态导入
     * @param args
     */
    public static void main(String[] args) {
        CodeBlock codeBlock = new CodeBlock();
        CodeBlock codeBlock2 = new CodeBlock();
        CodeBlock codeBlock3 = new CodeBlock();
        System.out.println(codeBlock.getId());
        //静态库导入
        double sqrt = sqrt(pow(2,2));
        System.out.println(sqrt);
        print(sqrt);
    }
}
