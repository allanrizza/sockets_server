package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    private void createServerSocket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private Socket waitConnection() throws IOException {
        return serverSocket.accept();
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.createServerSocket(5555);
            Socket socket = server.waitConnection();
        } catch(IOException ignored) {
        }


    }
}
