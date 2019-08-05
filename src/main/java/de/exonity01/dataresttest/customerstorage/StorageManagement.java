package de.exonity01.dataresttest.customerstorage;

import de.exonity01.dataresttest.core.converters.ResourceToByteArrayConverter;
import de.exonity01.dataresttest.customer.Customer;
import de.exonity01.dataresttest.customer.CustomerManagement;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StorageManagement {

    private final @NonNull CustomerManagement customerManagement;

    private final @NonNull DocumentRepository documentRepository;

    private final @NonNull StorageRepository storageRepository;

    private final @NonNull ResourceToByteArrayConverter resourceToByteArrayConverter;

    public Storage create(long customerId) {
        Storage storage = Storage.builder()
                .customerId(customerId)
                .build();

        return storageRepository.save(storage);
    }

    public Document createDocumentAndAddToStorage(
            Storage storage,
            String contentType,
            Resource fileResource,
            String filename) {

        Assert.notNull(storage, "Storage must not be null!");
        Assert.notNull(fileResource, "FileContent must not be null!");
        Assert.notNull(filename, "Filename must not be null!");
        Assert.notNull(contentType, "ContentType must not be null!");

        byte[] content = resourceToByteArrayConverter.convert(fileResource);

        // Create document
        Document document = documentRepository.save(Document.builder()
                .attachedStorage(storage)
                .content(content)
                .contentType(contentType)
                .fileSize(content.length)
                .filename(filename)
                .build());

        storage.addDocumentToStorage(document);

        return document;
    }


}
