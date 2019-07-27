package de.exonity01.dataresttest.customerstorage;


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

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_size")
    private long fileSize;

    @Lob
    @Column(length = 100000)
    private byte[] content;

}
