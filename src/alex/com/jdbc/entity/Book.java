package alex.com.jdbc.entity;

public class Book {
    
    private String user_id;
    private String user_name;
    private String user_sts;


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

    public String getUser_sts() {
        return this.user_sts;
    }

    public void setUser_sts(String user_sts) {
        this.user_sts = user_sts;
    }

    @Override
    public String toString() {
        return "{" +
            " user_id='" + getUser_id() + "'" +
            ", user_name='" + getUser_name() + "'" +
            ", user_sts='" + getUser_sts() + "'" +
            "}";
    }

}
