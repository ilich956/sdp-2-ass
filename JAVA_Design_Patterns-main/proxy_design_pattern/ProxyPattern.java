package proxy_design_pattern;

//creation of interface
interface DatabaseExecuter {
    public void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImpl implements DatabaseExecuter {  //create implementation of DatabaseExecuter for DatabaseExecuterImpl
    //overriding void method
    @Override
    public void executeDatabase(String query) throws Exception { //throw exception
        System.out.println("Going to execute Query: " + query);
    }
}

class DatabaseExecuterProxy implements DatabaseExecuter { //create implementation of DatabaseExecuter for DatabaseExecuterProxy
    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;

    //return true if name and passwd of admin
    public DatabaseExecuterProxy(String name, String passwd) {
        if (name == "Admin" && passwd == "Admin@123") {
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
    }

    //void method to execute database
    @Override
    public void executeDatabase(String query) throws Exception {
        if (ifAdmin) {
            dbExecuter.executeDatabase(query);
        } else {
            if (query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non-admin user");
            } else {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

public class ProxyPattern {
    public static void main(String[] args) throws Exception {
        //create new object
        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("DELEE");

        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuterDELETE.executeDatabase("DELETE");

        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE");
    }
}