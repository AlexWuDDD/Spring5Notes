package alex.com.jdbc.entity;

public class Account {
    
    private String user_id;
    private String user_name;
    private int money;


    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "{" +
            " user_id='" + getUser_id() + "'" +
            ", user_name='" + getUser_name() + "'" +
            ", money='" + getMoney() + "'" +
            "}";
    }
    
}
