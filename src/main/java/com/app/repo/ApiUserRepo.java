package com.app.repo;

import com.app.data.ApiUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 3/22/17.
 */
public interface ApiUserRepo extends PagingAndSortingRepository<ApiUser, Long> {

    public ApiUser findByUsername(String username);
    public ApiUser findByUsernameAndPassword(String username, String password);
}
