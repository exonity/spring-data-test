package de.exonity01.dataresttest.storage.web;

import de.exonity01.dataresttest.storage.Document;
import de.exonity01.dataresttest.storage.Storage;
import de.exonity01.dataresttest.storage.StorageManagement;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/storage")
public class StorageController {

    private final @NonNull StorageManagement storageManagement;

    @PostMapping("/{id}/document")
    public ResponseEntity<Document> createDocumentAndAssignToStorage(@PathVariable("id") Storage storage,
                                                         @RequestParam("file") MultipartFile fileMultipart) {
        if (storage == null) {
            return ResponseEntity.notFound().build();
        }

        byte[] fileContent;
        try {
            fileContent = IOUtils.toByteArray(fileMultipart.getInputStream());
        } catch (IOException exception) {
            log.error("Can't convert InputStream to ByteArray!", exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ok(storageManagement.createDocumentAndAssignToStorage(storage, fileContent, fileMultipart.getOriginalFilename()));
    }

}
