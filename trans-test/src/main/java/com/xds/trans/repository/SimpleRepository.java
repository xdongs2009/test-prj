package com.xds.trans.repository;

import com.xds.trans.po.Simple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleRepository extends JpaRepository<Simple, Long> {
}
