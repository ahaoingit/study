package com.ahao.file;


import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author ahao
 */
public class PathTest {
    /***.
     *[]
     *@author ahao
     *@date 2020-05-11 12:44
     *@return
     */
    @Test
    public void pathClass() {
        Path path = Paths.get("D:\\studyworkspace\\src\\main\\java\\com\\ahao\\file\\PathTest.java");
        //测试此路径是否存在
        System.out.println(Files.exists(path));
        System.out.println(Files.isRegularFile(path));
    }
}
