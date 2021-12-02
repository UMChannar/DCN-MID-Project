
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {

        this.serverSocket = serverSocket;

    }

    public void startServer() throws IOException {

        int i = 0;
        while (!serverSocket.isClosed()) {
            Socket socket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            System.out.println(i + " - " + ClientHandler.clientHandlers.get(i).clientUsername + " has connected to server");
            i++;
            Thread thread = new Thread(clientHandler);
            thread.start();

        }
    }
}
