package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ralph on 2016/1/16.
 */
public class Listen extends Thread{
    private final LinkedBlockingQueue<Socket> connections;
    private final Object power_lock = new Object();
    private boolean power;
    private ServerSocket server;
    public Listen(int port){
        power = true;
        connections = new LinkedBlockingQueue<>();
        try {
            server = new ServerSocket(port);
        } catch (Exception e){
            System.err.println("Server create error!!!!!");
            System.err.println(e);
        }
    }
    public ArrayList<Socket> getConnections(){
        ArrayList<Socket> buffer = new ArrayList<>(10);
        synchronized (connections){
            connections.drainTo(buffer, 10);
        }
        return buffer;
    }
    public void power_down(){
        synchronized (power_lock) {
            power = false;
            try {
                server.close();
            }catch (Exception e){
                System.err.println("Listener shut down error");
            }
        }
    }
    @Override
    public void run(){
        while(true){
            try {
                Socket socket = server.accept();
                synchronized (connections){
                    connections.offer(socket);
                }
            }catch (Exception e){
                System.err.println("Connection broke from accept.");
            }
            synchronized (power_lock){
                if(!power)
                    break;
            }
        }
    }
}
