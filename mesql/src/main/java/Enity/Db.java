package Enity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author ahao 2020-08-19
 */
@Data
public class Db {
    private String dbName;
    private String coding = "utf-8";
    private Map<String,Table> tables = new HashMap<>();
}
