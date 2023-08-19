package com.gitbook.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestInfoRepository extends JpaRepository<RequestInfo, Long> {

    @Query("SELECT r FROM RequestInfo r ORDER BY r.requestCount DESC")
    List<RequestInfo> findOneByRequestCountDesc();

}
