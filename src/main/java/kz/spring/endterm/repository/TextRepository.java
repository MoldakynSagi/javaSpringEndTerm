package kz.spring.endterm.repository;

import kz.spring.endterm.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextRepository extends JpaRepository<Text, Long> {
    List<Text> getTextByProductId(Long id);
}
