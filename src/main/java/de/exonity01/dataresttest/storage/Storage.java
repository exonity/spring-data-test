package de.exonity01.dataresttest.storage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.exonity01.dataresttest.core.BaseEntity;
import de.exonity01.dataresttest.customer.Customer;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "storage")
public class Storage extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "attachedStorage")
    private List<Document> documents;

    public Storage addDocumentToStorage(Document document) {
        Assert.notNull(document, "Document must not be null!");

        documents.add(document);

        return this;
    }
}
