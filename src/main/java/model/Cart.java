package model;

import java.time.LocalDateTime;

public class Cart {
    private int id;
    private String cartCode;
    private String orderDateTime;
    private User user;

    public Cart(String cartCode, String orderDateTime, User user) {
        this.cartCode = cartCode;
        this.orderDateTime = orderDateTime;
        this.user = user;
    }

    public Cart() {
    }

    public Cart(String cartCode, LocalDateTime orderDate) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
