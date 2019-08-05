package de.exonity01.dataresttest.onetomanytest;

import de.exonity01.dataresttest.core.BaseEntity;
import lombok.Getter;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "order_line")
public class OrderLine extends BaseEntity {

    @Column(name="name")
    private String name;

    @Column(name="quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    protected OrderLine(String name, int quantity) {
        Assert.notNull(name, "Name must not be null!");
        Assert.isTrue(name.length() > 3, "Name must be at least 3 characters!");
        Assert.isTrue(quantity > 0, "Quantity must be > 0");

        this.name = name;
        this.quantity = quantity;
    }

}
