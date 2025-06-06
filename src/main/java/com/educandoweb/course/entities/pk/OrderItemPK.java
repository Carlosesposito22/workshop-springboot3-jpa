package com.educandoweb.course.entities.pk;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OrderItemPK that)) return false;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(order);
        result = 31 * result + Objects.hashCode(product);
        return result;
    }
}
