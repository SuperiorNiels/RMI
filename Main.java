package RMI;

public class Main {

    public static void main(String[] args) {
        if(args[0].toLowerCase().equals("server")) {
            BankImp bank = new BankImp();
            Account niels = new Account("niels", 500.0);
            Account dieter = new Account("Dieter", 500.0);
            bank.add_account(niels);
            bank.add_account(dieter);
            Server server = new Server(bank);
            server.run();
        }
        else if(args[0].toLowerCase().equals("client")) {
            Client client = new Client("127.0.0.1");
            client.connect();
        }
        else {
            System.out.println("Please use parameter: server/client.");
        }
    }

}