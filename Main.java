package RMI;

public class Main {

    public static void main(String[] args) {
        if(args[0].toLowerCase().equals("server")) {
            BankImp bank = new BankImp();
            Account niels = new Account("niels", 500.0);
            bank.add_account(niels);
            Server server = new Server(bank);
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