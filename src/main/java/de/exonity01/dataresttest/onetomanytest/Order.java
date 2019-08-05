package de.exonity01.dataresttest.onetomanytest;

import de.exonity01.dataresttest.core.BaseEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "order")
public class Order extends BaseEntity {

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines = new ArrayList<>();

    public Order addLineToOrder(String name, int quantity) {
        orderLines.add(new OrderLine(name, quantity));

        return this;
    }

}
