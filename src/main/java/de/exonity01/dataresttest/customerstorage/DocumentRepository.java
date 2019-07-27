package de.exonity01.dataresttest.customerstorage;

import org.springframework.data.jpa.repository.JpaRepository;

interface DocumentRepository extends JpaRepository<Document, Long> {
}
