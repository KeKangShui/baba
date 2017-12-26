package cn.biye.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import cn.biye.core.bean.product.Brand;
import cn.biye.core.dao.product.BrandMapper;
import cn.biye.core.query.product.BrandQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;


/**
 * 品牌事务
 * @author lx
 *
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandMapper brandMapper;

	@Transactional(readOnly = true)
	public Pagination getBrandListWithPage(Brand brand){
		//1:起始页  startRow = (pageNo - 1)*pageSize
		//2:每页数
		//3:总记录数
		Pagination  pagination = new Pagination(brand.getPageNo(),brand.getPageSize(),brandMapper.getBrandCount(brand));
		//Brand集合
		pagination.setList(brandMapper.getBrandListWithPage(brand));
		
		return pagination;
	}

	@Override//添加品牌
	public void addBrand(Brand brand) {
		brandMapper.addBrand(brand);
	}

	@Override
	public void deleteBrandByKey(Integer id) {
		brandMapper.deleteBrandByKey(id);
		
	}

	@Override
	public void deleteBrandByKeys(Integer[] ids) {
		brandMapper.deleteBrandByKeys(ids);
		
	}

	@Override
	public void updateBrandByKey(Brand brand) {
		brandMapper.updateBrandByKey(brand);
		
	}

	@Override
	public Brand getBrandByKey(Integer id) {
		// TODO Auto-generated method stub
		return brandMapper.getBrandByKey(id);
	}

	@Override
	public List<Brand> getBrandList(BrandQuery brandQuery) {
		// TODO Auto-generated method stub
		System.out.println("-----:"+brandQuery.toString());
		return brandMapper.getBrandList(brandQuery);
	}
}
