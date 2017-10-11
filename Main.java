package RMI;

public class Main {

    public static void main(String[] args) {
        if(args[0].toLowerCase().equals("server")) {
            Server server = new Server();
            server.run();
        }
        else if(args[0].toLowerCase().equals("client")) {
            Client client = new Client();
            client.connect();
        }
        else {
            System.out.println("Please use parameter: server/client.");
        }
    }

}