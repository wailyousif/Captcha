package com.app.repo;

import com.app.data.Geolocation;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 10/24/17.
 */
public interface GeolocationRepo extends PagingAndSortingRepository<Geolocation, Long> {
}
