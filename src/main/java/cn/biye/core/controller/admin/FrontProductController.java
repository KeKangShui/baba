package cn.biye.core.controller.admin;

import cn.biye.core.bean.product.*;
import cn.biye.core.query.product.*;
import cn.biye.core.service.product.*;
import cn.itcast.common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2017/11/20.
 */
@Controller
public class FrontProductController {
    @Autowired
    private SkuService skuService;
    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private FeatureService featureService;

    /*商品列表页面*/
    @RequestMapping(value = "/product/display/list.shtml")
    public String list(Integer pageNo,Integer brandId,String brandName,Integer typeId,String typeName, ModelMap model) {

        //加载商品属性
        FeatureQuery featureQuery = new FeatureQuery();

        List<Feature> features = featureService.getFeatureList(featureQuery);
        //显示在页面
        model.addAttribute("features", features);

        //分页参数
        StringBuilder params = new StringBuilder();
        //商品条件对象
        ProductQuery productQuery = new ProductQuery();
        //设置页号
        productQuery.setPageNo(Pagination.cpn(pageNo));
        //设置每页数
        productQuery.setPageSize(Product.font_page_size);
        //设置倒序排列
        productQuery.orderbyId(false);
        //TODO
        //隐藏已选条件
        boolean flag = false;

        Map<String,String> query = new LinkedHashMap<String,String>();

        //品牌ID
        if(null !=brandId){
            productQuery.setBrandId(brandId);
            flag =true;

            model.addAttribute("brandId",brandId);
            model.addAttribute("brandName",brandName);
            query.put("品牌",brandName);
            params.append("&").append("brandId=").append(brandId).append("&brandName=").append(brandName);
        }else {
            //加载商品品牌
            //品牌条件对象
            BrandQuery brandQuery = new BrandQuery();
            //设置指定字段
            brandQuery.setFields("id,name");
            //设置可见
            brandQuery.setIsDisplay(1);
            //加载品牌   ---  这里出了问题
            List<Brand> brands = brandService.getBrandList(brandQuery);
            //显示在页面
            model.addAttribute("brands", brands);
        }

        if(null !=typeId){
            productQuery.setTypeId(typeId);
            flag = true;

            model.addAttribute("typeId",typeId);
            model.addAttribute("typeName",typeName);
            query.put("类型",typeName);
            params.append("&").append("typeId=").append(typeId).append("&typeName=").append(typeName);

        }else {
            //加载商品类型
            TypeQuery typeQuery = new TypeQuery();
            //指定查询哪些字段
            typeQuery.setFields("id,name");
            typeQuery.setIsDisplay(1);
            typeQuery.setParentId(0);
            List<Type> types = typeService.getTypeList(typeQuery);
            System.out.println(types.size());
            //显示在页面
            model.addAttribute("types", types);
        }

        model.addAttribute("flag",flag);
        model.addAttribute("query",query);


        //加载带有分页的商品
        Pagination pagination = productService.getProductListWithPage(productQuery);

        //分页页面展示    //String params = "brandId=1&name=2014瑜伽服套装新款&pageNo=1";
        String url = "/product/display/list.shtml";
        pagination.pageView(url, params.toString());

        model.addAttribute("pagination", pagination);

        return "product/product";

    }

    @RequestMapping(value = "/product/detail.shtml")
    public String detail(Integer id,ModelMap model){
        //商品加载
        Product product = productService.getProductByKey(id);
        model.addAttribute("product",product);

        //skus
        SkuQuery skuQuery = new SkuQuery();  /* 这种是方案一。*/
        skuQuery.setProductId(id);
        List<Sku> skus = skuService.getSkuList(skuQuery);

//        List<Sku> skus = skuService.getStock(id);//这种是方案二
        model.addAttribute("skus",skus);
        //去重复
        List<Color> colors = new ArrayList<Color>();
        for (Sku sku :skus){
            if(!colors.contains(sku.getColor())){
                colors.add(sku.getColor());
            }
        }
        System.out.println(colors.toString());
        model.addAttribute("colors",colors);

        return "product/productDetail";
    }

}
