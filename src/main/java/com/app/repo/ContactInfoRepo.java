package com.app.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.data.ContactInfo;

/**
 * Created by wailm.yousif on 3/22/17.
 */
public interface ContactInfoRepo extends PagingAndSortingRepository<ContactInfo, Long> {
}
