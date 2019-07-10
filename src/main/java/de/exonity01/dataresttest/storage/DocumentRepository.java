package de.exonity01.dataresttest.storage;

import org.springframework.data.jpa.repository.JpaRepository;

interface DocumentRepository extends JpaRepository<Document, Long> {
}
