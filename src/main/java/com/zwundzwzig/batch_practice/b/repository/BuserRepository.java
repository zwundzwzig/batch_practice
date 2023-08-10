package com.zwundzwzig.batch_practice.b.repository;

import com.zwundzwzig.batch_practice.a.entity.Auser;
import com.zwundzwzig.batch_practice.b.entity.Buser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuserRepository extends JpaRepository<Buser, Long> {
}
