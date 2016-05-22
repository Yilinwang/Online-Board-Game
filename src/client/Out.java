package client;

import server.Request;

import java.io.ObjectOutputStream;

/**
 * Created by ralph on 2016/1/17.
 */
public class Out extends Thread{
    private ObjectOutputStream out;
    private Request request;
    private final Object lock;
    private boolean ready;
    public Out(ObjectOutputStream _out){
        lock = new Object();
        out = _out;
        ready = false;
    }
    public void write(Request message){
        try {
            out.writeObject(message);
        } catch (Exception e){
            System.out.println("error!!!");
        }
    }
    @Override
    public void run(){
        synchronized (lock){
            while(true) {
                try {
                    ready = true;
                    lock.wait();
                }catch (Exception e){
                    System.err.printf("Interrupt!!");
                    continue;
                }
                try {
                    out.writeObject(request);
                } catch (Exception e) {
                    System.err.printf("Socket close");
                    break;
                }
            }
        }
    }
}
