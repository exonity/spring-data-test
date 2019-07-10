package de.exonity01.dataresttest.storage;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class StorageManagement {

    private long maxFileSizeInBytes = 1024 * 1024;

    private final @NonNull DocumentRepository documentRepository;

    @Transactional
    public Document createDocumentAndAssignToStorage(Storage storage, Resource fileResource, String filename) {
        Assert.notNull(storage, "Storage must not be null!");
        Assert.notNull(fileResource, "FileContent must not be null!");
        Assert.notNull(filename, "Filename must not be null!");

        byte[] content;
        try {
            content = IOUtils.toByteArray(fileResource.getInputStream());

            if (content.length > maxFileSizeInBytes) {
                throw new DocumentTooLargeException();
            }
        } catch (IOException exception) {
            log.error("Can't convert InputStream to Resource!", exception);
            throw new RuntimeException("Can't convert InputStream to Resource!", exception);
        }

        Document document = documentRepository.save(Document.builder()
                .attachedStorage(storage)
                .content(content)
                .filename(filename)
                .build());

        storage.attachDocumentToStorage(document);

        return document;
    }
}
