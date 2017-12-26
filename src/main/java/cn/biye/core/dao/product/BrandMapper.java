package cn.biye.core.dao.product;

import cn.biye.core.bean.product.Brand;
import cn.biye.core.query.product.BrandQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BrandMapper {

    // 选择品牌页

   /* @Select({"select", "id, name, description, img_url, sort, is_display",
            "from bbs_brand",
            "where is_display = #{isDisplay,jdbcType=INTEGER}",
            "order by id desc", "limit 0,5"})*/
    public List<Brand> getBrandListWithPage(Brand brand);

    // 查询总记录数

    @Select({"select count(1) from bbs_brand where is_display = #{isDisplay}"})
    public int getBrandCount(Brand brand);

    //添加品牌
    public void addBrand(Brand brand);


    //删除
    @Delete({"delete from bbs_brand where id = #{id}"})
    public void deleteBrandByKey(Integer id);
    //删除 批量
    public void deleteBrandByKeys(Integer[] ids);//List<Integer>  ids
    //修改
    public void updateBrandByKey(Brand brand);

    //
    public Brand getBrandByKey(Integer id);

    //查询集合  getBrandList
    public List<Brand> getBrandList(BrandQuery brandQuery);

}
