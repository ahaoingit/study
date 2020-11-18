package com.ahao.websoket;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author ahao
 */
@ServerEndpoint("/webSocket")
public class Web {
    @OnOpen
    public void onOpen(Session session){

    }
}
