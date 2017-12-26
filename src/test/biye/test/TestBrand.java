package biye.test;

import cn.biye.common.junit.SpringJunitTest;
import cn.biye.core.bean.product.Brand;
import cn.biye.core.query.product.BrandQuery;
import cn.biye.core.service.product.BrandService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ASUS on 2017/11/13.
 */

public class TestBrand extends SpringJunitTest {

    @Autowired
    private BrandService brandService;
    @Test
    public void testGet() throws Exception {
        BrandQuery brandQuery = new BrandQuery();

//        brandQuery.setFields("id");
//        brandQuery.setNameLike(true);
//        brandQuery.setName("金");
        brandQuery.orderbyId(false);
//
        brandQuery.setPageNo(2);
        brandQuery.setPageSize(2);

        List<Brand> brands = brandService.getBrandList(brandQuery);

        for (Brand b : brands) {
            System.out.println(b);
        }
    }
}
