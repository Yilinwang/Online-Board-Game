PORT=5000
SERVER=127.0.0.1
CC=javac
all:
	$(CC) -cp src src/server/*.java
	$(CC) -cp src src/client/*.java
	$(CC) -cp src src/gui/*.java
	$(CC) -cp src src/game/*.java
	$(CC) -cp src src/ServerMain.java
runServer:
	java -cp src ServerMain $(PORT)
runClient:
	java -cp "src:src/gui" TicketToRide $(SERVER) $(PORT)
clean:
	rm -f src/*.class
	rm -f src/server/*.class
	rm -f src/client/*.class
	rm -f src/gui/*.class
	rm -r src/game/*.class
