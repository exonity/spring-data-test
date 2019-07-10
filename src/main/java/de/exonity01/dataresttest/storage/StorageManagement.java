package de.exonity01.dataresttest.storage;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class StorageManagement {

    private long maxFileSizeInBytes = 1024 * 1024;

    private final @NonNull DocumentRepository documentRepository;

    @Transactional
    public Document createDocumentAndAssignToStorage(Storage storage, byte[] fileContent, String filename) {
        Assert.notNull(storage, "Storage must not be null!");
        Assert.notNull(fileContent, "FileContent must not be null!");
        Assert.notNull(filename, "Filename must not be null!");

        if (fileContent.length > maxFileSizeInBytes) {
            throw new DocumentTooLargeException();
        }

        Document document = documentRepository.save(Document.builder()
                .attachedStorage(storage)
                .content(fileContent)
                .filename(filename)
                .build());

        storage.attachDocumentToStorage(document);

        return document;
    }
}
