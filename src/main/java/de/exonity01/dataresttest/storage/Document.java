package de.exonity01.dataresttest.storage;


import de.exonity01.dataresttest.core.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "document")
public class Document extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "attachedStorageId")
    private Storage attachedStorage;

    @Column(name = "contentType")
    private String contentType;

    @Column(name = "filename")
    private String filename;

    @Lob
    @Column(length = 100000)
    private byte[] content;

}
