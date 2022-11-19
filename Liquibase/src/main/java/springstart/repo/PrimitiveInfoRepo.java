package springstart.repo;

import springstart.models.PrimitiveInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimitiveInfoRepo extends JpaRepository<PrimitiveInfo, Long> {}
