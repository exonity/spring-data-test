package de.exonity01.dataresttest.storage.web;

import de.exonity01.dataresttest.core.converters.MultipartFileToResourceConverter;
import de.exonity01.dataresttest.storage.Document;
import de.exonity01.dataresttest.storage.Storage;
import de.exonity01.dataresttest.storage.StorageManagement;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/storage")
public class StorageController {

    private final @NonNull StorageManagement storageManagement;

    private final @NonNull MultipartFileToResourceConverter multipartFileToResourceConverter;

    @Value("${storage.allowed-max-file-size}")
    private long STORAGE_ALLOWED_MAX_FILE_SIZE;

    @Value("${storage.allowed_content_types}")
    private Set<String> STORAGE_ALLOWED_CONTENT_TYPES;

    @PostMapping("/{id}/document")
    public ResponseEntity<Document> createDocumentAndAssignToStorage(@PathVariable("id") Storage storage,
                                                                     @RequestParam("file") MultipartFile documentContent) {
        if (storage == null) {
            return ResponseEntity.notFound().build();
        }

        // Check file size
        if (documentContent.getSize() > STORAGE_ALLOWED_MAX_FILE_SIZE) {
            return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).build();
        }

        // Check content type
        if (!STORAGE_ALLOWED_CONTENT_TYPES.contains(documentContent.getContentType())) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
        }

        return ResponseEntity
                .ok()
                .body(storageManagement.createDocumentAndAssignToStorage(
                        storage,
                        documentContent.getContentType(),
                        multipartFileToResourceConverter.convert(documentContent),
                        documentContent.getOriginalFilename()));
    }
}
