package de.exonity01.dataresttest.test;

import de.exonity01.dataresttest.core.web.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController extends BaseController {

    @PostMapping("")
    public ResponseEntity<TestDto> create(@RequestBody @Valid TestDto testDto) {
        return ok(testDto);
    }

}
