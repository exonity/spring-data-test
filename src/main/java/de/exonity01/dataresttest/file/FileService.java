package de.exonity01.dataresttest.file;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class FileService {

    private final @NonNull FileRepository fileRepository;

    public Optional<File> findById(long id) {
        return fileRepository.findById(id);
    }

}
