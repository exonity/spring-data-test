package de.exonity01.dataresttest.file;

import org.springframework.data.jpa.repository.JpaRepository;

interface FileRepository extends JpaRepository<File, Long> {
}
