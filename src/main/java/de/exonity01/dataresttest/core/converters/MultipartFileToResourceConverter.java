package de.exonity01.dataresttest.core.converters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class MultipartFileToResourceConverter {

    public Resource convert(MultipartFile multipartFile) {
        Assert.notNull(multipartFile, "MultipartFile must not be null!");
        try {
            return new InputStreamResource(multipartFile.getInputStream());
        } catch (IOException exception) {
            log.error("Can't convert InputStream to Resource!", exception);
            throw new RuntimeException("Can't convert InputStream to Resource!", exception);
        }
    }

}
