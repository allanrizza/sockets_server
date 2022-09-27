package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    private void treatConnection(Socket socket) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            String msg = input.readUTF();
            System.out.println("Message received.");
            output.writeUTF("This is a Socket Connection example!");
        } catch(IOException ignore) {
        }
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
