package model;

import java.time.LocalDateTime;

public class Cart {
    private int id;
    private String cartCode;
    private LocalDateTime orderDateTime;
    private User user;

    public Cart(String cartCode, LocalDateTime orderDateTime, User user) {
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

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
