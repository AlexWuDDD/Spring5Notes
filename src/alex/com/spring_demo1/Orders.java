package alex.com.spring_demo1;

/**
 * 使用有参数构造注入
 */

public class Orders {
    private String oname;
    private String address;

    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public void testDemo(){
        System.out.println("订单名："+oname+"  地址："+address);
    }
}
