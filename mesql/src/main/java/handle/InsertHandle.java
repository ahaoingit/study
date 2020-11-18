package handle;

import Enity.Db;
import Enity.Table;
import exception.TableHasBeenCreateException;
import org.junit.Test;
import client.Context;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static handle.CreateHandle.createDb;
import static handle.CreateHandle.createTb;

/**
 * TODO
 *
 * @author ahao 2020-08-19
 */
public class InsertHandle {
    //param 格式   4,5,6,4
    public void insert(String dbName, String tbName, String param) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Map<String, Db> map = Context.context.getMap();
        Db db = map.get(dbName);
        Map<String, Table> tables = db.getTables();
        Table table = tables.get(tbName);
        List obs = table.getObs();

        String[] split = param.split(",");
        Class<?>[] classes = new Class[split.length];
        for (int i = 0 ; i < split.length ; ++i) {
            classes[i] = String.class;
        }
        Class<?> aClass = Class.forName("Enity." + tbName);
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(classes);
        Object o = declaredConstructor.newInstance(split);
        obs.add(o);
        System.out.println(o);
    }
    @Test
    public void testInsert() throws TableHasBeenCreateException, IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            String db = scanner.nextLine();
            String tb = scanner.nextLine();
            String structure = scanner.nextLine();
            switch (i){
                case 0:
                    break;
                case 1:
                    init(db,tb,structure);
                    break;
                case 2:
                    insert(db,tb,"ahao,5");
                    break;
                default:
                    return;
            }
        }
    }

    public void init(String db,String tb,String structure) throws TableHasBeenCreateException, IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        createDb(db);
        createTb(tb, db, structure);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, TableHasBeenCreateException, IOException {
        InsertHandle insertHandle = new InsertHandle();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            String db = "test";
            String tb = "Teacher";
            String structure = "tid int,name String";
            insertHandle.init(db,tb,structure);
            switch (i){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    insertHandle.insert(db,tb,"ahao,5");
                    break;
                default:
                    return;
            }
        }
    }
}
