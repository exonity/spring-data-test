package de.exonity01.dataresttest.storage.web;

import de.exonity01.dataresttest.core.MultipartFileToResourceConverter;
import de.exonity01.dataresttest.storage.Document;
import de.exonity01.dataresttest.storage.Storage;
import de.exonity01.dataresttest.storage.StorageManagement;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
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

    private final @NonNull MultipartFileToResourceConverter multipartFileToResourceConverter;

    @PostMapping("/{id}/document")
    public ResponseEntity<Document> createDocumentAndAssignToStorage(@PathVariable("id") Storage storage,
                                                                     @RequestParam("file") MultipartFile fileMultipart) {
        if (storage == null) {
            return ResponseEntity.notFound().build();
        }

        Resource fileResource = multipartFileToResourceConverter.convert(fileMultipart);

        return ok(storageManagement.createDocumentAndAssignToStorage(storage, fileResource, fileMultipart.getOriginalFilename()));
    }

    // Method to show all customer documents is missing

}
