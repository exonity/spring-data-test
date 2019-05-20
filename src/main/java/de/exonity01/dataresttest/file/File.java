package de.exonity01.dataresttest.file;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
