import server.Server;

/**
 * Created by ralph on 2016/1/16.
 */
public class ServerMain {
	static public void main(String[] args){
		int port = 5410;
		try{
			port = Integer.valueOf(args[0]);
		}
		catch (Exception e){
			System.err.println("No specific of port number... Default 5410  ");
		}

		Server server = new Server(port);
		server.start();
	}
}
