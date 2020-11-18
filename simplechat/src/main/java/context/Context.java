package context;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author 2020-08-30
 */
public enum  Context {
    cx;
    private Map<String, io.netty.channel.Channel> map = new HashMap<>();

    public Map<String, Channel> getMap() {
        return map;
    }
}
