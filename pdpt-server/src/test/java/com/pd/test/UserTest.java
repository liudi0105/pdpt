package com.pd.test;

import com.pd.server.user.UserDTO;
import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.test.ApiTestClient;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;

public class UserTest {

    private final ApiTestClient apiTestClient = new ApiTestClient("user");

    @Test
    public void listPaged() {
        AppPageResult<UserDTO> user = apiTestClient.apiPostJsonForJson("list-paged", new AppPageParam()
                .setPageIndex(1)
                .setPageSize(10), new ParameterizedTypeReference<>() {
        });
        System.out.println();
    }

}
