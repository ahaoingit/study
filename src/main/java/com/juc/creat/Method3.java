package com.juc.creat;

import java.util.concurrent.Callable;

/**
 * TODO
 *方法三 实现Callable接口
 * @author ahao 2020-07-15
 */
public class Method3 {

    static class CallableImpl implements Callable<String> {

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public String call() throws Exception {
            Thread.sleep(1000 * 3);
            return "返回结果";
        }
    }

}
