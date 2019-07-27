package de.exonity01.dataresttest.customerstorage;

import org.springframework.data.jpa.repository.JpaRepository;

interface StorageRepository extends JpaRepository<Storage, Long> {
}
