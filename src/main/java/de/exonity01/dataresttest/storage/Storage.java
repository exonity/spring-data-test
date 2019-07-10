package de.exonity01.dataresttest.storage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.exonity01.dataresttest.core.BaseEntity;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "storage")
public class Storage extends BaseEntity {

    @OneToMany(mappedBy = "attachedStorage")
    private List<Document> documents;

    public Storage attachDocumentToStorage(Document document) {
        Assert.notNull(document, "Document must not be null!");

        documents.add(document);

        return this;
    }
}
