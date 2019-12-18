package server.servlet;

import server.socket.HelloWorldSocket;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class HelloWorldServlet extends WebSocketServlet {
    @Override
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.register(HelloWorldSocket.class);
    }
}
