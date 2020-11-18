package client; /**
 * TODO
 *
 * @author ahao 2020-08-21
 */

import exception.SqlIllegalException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import utils.SqlParsingUtils;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.*;


public class MinaClient {

    private static String host = "127.0.0.1";
    private static int port = 7080;
    public static void main(String[] args){
        IoSession session = null;
        IoConnector connector = new NioSocketConnector();// 提供客户端实现
        connector.setConnectTimeout(3000);// 设置超时时间
        // 设置过滤器(编码和解码)
        connector.getFilterChain().addLast("coderc", new ProtocolCodecFilter(
                new TextLineCodecFactory(StandardCharsets.UTF_8,
                        LineDelimiter.WINDOWS.getValue(),
                        LineDelimiter.WINDOWS.getValue())));
        // 业务处理
        connector.setHandler(new MinaClientHandler());
        // 设置session属性,获取服务端连接
        ConnectFuture future = connector.connect(new InetSocketAddress(host,port));
        future.awaitUninterruptibly();// 等待我们的连接
        session = future.getSession();
        // 写入数据,发往服务端
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if ("quit".equals(s)){
                System.out.println("bey");
                session.getCloseFuture().awaitUninterruptibly();// 等待关闭连接
                connector.dispose();
                return;
            }
            try {
                session.write(SqlParsingUtils.getParam(s));
            } catch (SqlIllegalException | SQLException ignored) {
                System.out.println("sql不合法");
            }
        }
    }
}