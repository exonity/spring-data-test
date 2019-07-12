package de.exonity01.dataresttest.storage;

import de.exonity01.dataresttest.core.converters.ResourceToByteArrayConverter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class StorageManagement {

    private final @NonNull DocumentRepository documentRepository;

    private final @NonNull ResourceToByteArrayConverter resourceToByteArrayConverter;

    @Transactional
    public Document createDocumentAndAddToStorage(
            Storage storage,
            String contentType,
            Resource fileResource,
            String filename) {

        Assert.notNull(storage, "Storage must not be null!");
        Assert.notNull(fileResource, "FileContent must not be null!");
        Assert.notNull(filename, "Filename must not be null!");
        Assert.notNull(contentType, "ContentType must not be null!");

        // Check if the customer to which the storage belongs is enabled for using his storage.
        if (!storage.getCustomer().isDocumentStorageEnabled()) {
            throw new CustomerDocumentStorageIsNotEnabledException();
        }

        byte[] content = resourceToByteArrayConverter.convert(fileResource);

        Document document = documentRepository.save(Document.builder()
                .attachedStorage(storage)
                .content(content)
                .contentType(contentType)
                .filename(filename)
                .build());

        storage.addDocumentToStorage(document);

        return document;
    }
}
