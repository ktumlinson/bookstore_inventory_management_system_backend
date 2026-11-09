package bookstore.bims.book_api.repository;

import bookstore.bims.book_api.model.CoverType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverRepository extends JpaRepository<CoverType, Long> {
}
