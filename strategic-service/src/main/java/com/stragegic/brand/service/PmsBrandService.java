package com.stragegic.brand.service;

import com.stragegic.brand.entity.PmsBrand;

/**
 * PmsBrandService
 * Created by macro on 2019/4/19.
 */
public interface PmsBrandService {

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    PmsBrand getBrand(Long id);
}
