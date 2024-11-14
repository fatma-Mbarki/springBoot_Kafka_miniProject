package net.javaguides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.entity.wikimediaData;
public interface WikimediaDataRepository extends JpaRepository<wikimediaData,Long> {
}
