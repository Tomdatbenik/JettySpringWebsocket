package server.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import org.eclipse.jetty.websocket.api.Session;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Service("helloWorldSvc")
public class HelloWorldService {

    private Set<Session> listenerSessions = new CopyOnWriteArraySet<>();

    public void removeSession(Session session) {
        listenerSessions.remove(session);
    }

    public void addSession(Session session) {
        listenerSessions.add(session);
    }

    @PostConstruct
    private void init() {
        Runnable runnable = () -> {
            while (true){
                try {
                    Thread.sleep(10000);
                    String message = "HelloWorld";
                    listenerSessions.stream()
                            .filter(s-> s.isOpen())
                            .forEach(s -> SendHelloWorld(s,message));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void SendHelloWorld(Session s, String message) {
        try {
            s.getRemote().sendString(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
