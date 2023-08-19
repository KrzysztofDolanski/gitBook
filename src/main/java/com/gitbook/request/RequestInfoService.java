package com.gitbook.request;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Krzysztof Dolański
 */
@Service
@AllArgsConstructor
public class RequestInfoService {

    private static final Logger logger = LoggerFactory.getLogger(RequestInfoService.class);
    private final RequestInfoRepository repository;

    public void saveRequestInfo(String login) {
        long count = 0L;
        if (repository.findAll().isEmpty()) {
            count++;
        } else {
        count = repository.findOneByRequestCountDesc().stream().findFirst().orElseThrow().getRequestCount() + 1;

        }
        RequestInfo requestInfo = userRequestInfoMapper(login, count);
        saveRequestInfo(requestInfo);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<RequestInfo> findOneByREQUEST_COUNTDesc() {
        return repository.findOneByRequestCountDesc();
    }


    private RequestInfo userRequestInfoMapper(String login, Long count) {
        return new RequestInfo.RequestInfoBuilder().login(login).requestCount(count).build();
    }

    private void saveRequestInfo(RequestInfo requestInfo) {
        try {
            repository.save(requestInfo);
        } catch (RequestInfoRepositoryException e) {
            logger.error("Failed writing to DB RequestInfo with login {} cause of {}", requestInfo.getLogin(), e.getMessage());
        }
    }

}
