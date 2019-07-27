package de.exonity01.dataresttest.customerstorage;

import de.exonity01.dataresttest.core.BaseEntity;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "customerstorage")
public class Storage extends BaseEntity {

    @Value("${storage.max_size_for_customer}")
    private long STORAGE_MAX_SIZE_FOR_CUSTOMER;

    @Column(name = "used_space_in_bytes")
    private long usedSpaceInBytes;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @OneToMany(mappedBy = "attachedStorage")
    private List<Document> documents;

    public Storage addDocumentToStorage(Document document) {
        Assert.notNull(document, "Document must not be null!");

        // Check document space
        if (!checkEnoughSpaceToStoreDocument(document)) {
            throw new CustomerDocumentStorageIsNotEnabledException();
        }

        // Add document and update used space
        documents.add(document);
        usedSpaceInBytes += document.getFileSize();

        return this;
    }

    private boolean checkEnoughSpaceToStoreDocument(Document document) {
        Assert.notNull(document, "Document must not be null!");

        return (usedSpaceInBytes + document.getFileSize()) <= STORAGE_MAX_SIZE_FOR_CUSTOMER;
    }

}
