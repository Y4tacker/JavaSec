public class HelloWorld {
    public String username;
    public String password;

    public HelloWorld(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void hello(){
        System.out.println("HeeloWorld");
    }
    public String helllo(String a){
        return a+username;
    }
}
