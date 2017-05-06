package ru.kpfu.itis.model;

import ru.kpfu.itis.model.enums.TypeOrder;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany
    private Collection<ProductInOrder> productInOrder;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;
    @Enumerated(EnumType.STRING)
    private TypeOrder typeOrder;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<ProductInOrder> getProductInOrder() {
        return productInOrder;
    }

    public void setProductInOrder(Collection<ProductInOrder> productInOrder) {
        this.productInOrder = productInOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeOrder getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(TypeOrder typeOrder) {
        this.typeOrder = typeOrder;
    }
}
