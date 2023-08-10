package com.zwundzwzig.batch_practice.c.repository;

import com.zwundzwzig.batch_practice.a.entity.Auser;
import com.zwundzwzig.batch_practice.c.entity.Cuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuserRepository extends JpaRepository<Cuser, Long> {
}
