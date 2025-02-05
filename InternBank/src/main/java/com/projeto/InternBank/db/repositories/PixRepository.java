package com.projeto.InternBank.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.InternBank.db.models.Pix;

@Repository
public interface PixRepository extends JpaRepository<Pix, Integer> {
}
