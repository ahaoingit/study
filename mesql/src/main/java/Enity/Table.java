package Enity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author ahao 2020-08-19
 */
@Data
public class Table<E , V> {
    /**
     * 主键问题
     */
    V id;
    /**
     * 存储对象 代表行数据数据
     */
    List<E> obs = new ArrayList<>();

}
