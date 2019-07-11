package de.exonity01.dataresttest.core;

import de.exonity01.dataresttest.storage.DocumentTooLargeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;

@Slf4j
@Service
public class ResourceToByteArrayConverter {

    public byte[] convert(Resource resource) {
        Assert.notNull(resource, "Resource must not be null!");

        try {
            return IOUtils.toByteArray(resource.getInputStream());
        } catch (IOException exception) {
            log.error("Can't convert InputStream to Resource!", exception);
            throw new RuntimeException("Can't convert InputStream to Resource!", exception);
        }
    }
}
