package server.socket;

import server.util.HelloWorldBeanUtil;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.Session;


@WebSocket
public class HelloWorldSocket {
    @OnWebSocketConnect
    public void onConnect(Session session) {
        HelloWorldBeanUtil.getHelloWorldService().addSession(session);
    }

    @OnWebSocketClose
    public void onClose(Session session, int _closeCode, String _closeReason) {
        HelloWorldBeanUtil.getHelloWorldService().removeSession(session);
    }
}