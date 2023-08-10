package com.zwundzwzig.batch_practice.a.repository;

import com.zwundzwzig.batch_practice.a.entity.Auser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuserRepository extends JpaRepository<Auser, Long> {
}
