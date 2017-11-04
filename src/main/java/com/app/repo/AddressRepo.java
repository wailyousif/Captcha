package com.app.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.data.Address;

/**
 * Created by wailm.yousif on 3/22/17.
 */
public interface AddressRepo extends PagingAndSortingRepository<Address, Long> {
}
