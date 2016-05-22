package server;

import java.io.ObjectOutputStream;

/**
 * Created by ralph on 2016/1/16.
 */

class Out extends Thread{
    private ObjectOutputStream out;
    private Request request;
    private final Object lock;
    public Out(ObjectOutputStream _out){
        lock = new Object();
        out = _out;
    }

    public void write(Request message){
        /*
        synchronized (lock){
            request = message;
            lock.notify();
        }*/
        try{
            out.writeObject(message);
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Write failed");
        }
    }
    @Override
    public void run(){
        synchronized (lock){
            while(true) {
                try {
                    lock.wait();
                }catch (Exception e){
                    System.err.printf("Interrupt!!");
                    continue;
                }
                try {
                    out.writeObject(request);
                    if(request.getType() != 0) {
                        System.err.println("send");
                        System.err.println(request.getType());
                    }
                } catch (Exception e) {
                    System.err.printf("Socket close");
                    break;
                }
            }
        }
    }
}