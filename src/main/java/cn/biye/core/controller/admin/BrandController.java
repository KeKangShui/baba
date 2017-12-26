package cn.biye.core.controller.admin;

import cn.biye.core.dao.product.BrandMapper;
import cn.biye.core.service.product.BrandService;
import cn.itcast.common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.biye.core.bean.product.Brand;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 品牌
 *
 * @author lx
 */
@Controller
public class BrandController {


    @Autowired
    private BrandService brandService;
    private static ApplicationContext ac;
    //品牌列表页面
    @RequestMapping(value = "/brand/list.do")
    public String list(String name, Integer isDisplay, Integer pageNo, ModelMap model) {

        //参数
        StringBuilder params = new StringBuilder();
        Brand brand = new Brand();
        //判断传进来的名称是否为Null并且还要判断 是否为空串   blank  ""  "   "   emtpy  ""   "  "
        if (StringUtils.isNotBlank(name)) {
            brand.setName(name);
            params.append("name=").append(name);
        }
        //是  不是
        if (null != isDisplay) {
            brand.setIsDisplay(isDisplay);
            params.append("&").append("isDisplay=").append(isDisplay);
        } else {
            brand.setIsDisplay(1);
            params.append("&").append("isDisplay=").append(1);
        }

        //如果页号为null 或小于1  置为1

        //页号
        brand.setPageNo(Pagination.cpn(pageNo));

        //每页数
        brand.setPageSize(5);
        //分页对象
        Pagination pagination = brandService.getBrandListWithPage(brand);

        //分页展示   /brand/list.do?name=瑜伽树（yogatree）&isDisplay=1&pageNo=2

        String url = "/brand/list.do";
        pagination.pageView(url, params.toString());

        model.addAttribute("pagination", pagination);//request.setAttribute
        model.addAttribute("name", name);//request.setAttribute
        model.addAttribute("isDisplay", isDisplay);//request.setAttribute

        return "brand/list";
    }

    //跳转品牌添加页面
    @RequestMapping(value = "/brand/toAdd.do")
    public String toAdd() {
        return "brand/add";
    }

    //添加品牌
    @RequestMapping(value = "/brand/add.do")
    public String write(Brand brand,HttpServletRequest request){

        String s=request.getParameter("name");
        System.out.println("获取到的只是sss--"+s);
        System.out.println(brand.getName());
        brandService.addBrand(brand);
        return "redirect:/brand/list.do";
//        获得物理路径webapp所在路径
    /*    String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path="";
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path=uuid+"."+imageName;
            try {
                file.transferTo(new File("D:\\1\\pic\\"+path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(path);*/


//        如果邮件不为空就执行带三个参数的方法
/*        System.out.println("-----------");
        System.out.println(brand.getDescription() + " " + brand.getName());
        System.out.println("---------**");
        //获得物理路径webapp所在路径
        System.out.println("---------**---------");
        String names = request.getParameter("name");
        System.out.println("获取到的用户名是" + names);
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path = "";
        if (!file.isEmpty()) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = file.getContentType();
            //获得文件后缀名称
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            path = uuid + "." + imageName;
//            file.transferTo(new File("D:\\1\\pic\\" + path));
        }
        System.out.println(path);

        BrandMapper mapper = (BrandMapper) ac.getBean("brand");

        mapper.addBrand(brand);*/
    }


    //    public String add(@RequestParam("name")String name ) {
//        //添加开始
//        System.out.println("123"+name);
////        System.out.println("brander:"+brand.toString());
////        brandService.addBrand(brand);
////        return "redirect:/brand/list.do";
//        return null;
//    }

    //删除一个品牌
    @RequestMapping(value = "/brand/delete.do")
    public String delete(Integer id, String name, Integer isDisplay, ModelMap model) {
        //TODO 删除

        brandService.deleteBrandByKey(id);
        if (StringUtils.isNotBlank(name)) {
            model.addAttribute("name", name);
        }
        if (null != isDisplay) {
            model.addAttribute("isDisplay", isDisplay);
        }

        return "redirect:/brand/list.do";
    }

    //删除多个品牌
    @RequestMapping(value = "/brand/deletes.do")
    public String deletes(Integer[] ids, String name, Integer isDisplay, ModelMap model) {
        //TODO 删除
        brandService.deleteBrandByKeys(ids);
        if (StringUtils.isNotBlank(name)) {
            model.addAttribute("name", name);
        }
        if (null != isDisplay) {
            model.addAttribute("isDisplay", isDisplay);
        }

        return "redirect:/brand/list.do";
    }

    //去修改页面
    @RequestMapping(value = "/brand/toEdit.do")
    public String toEdit(Integer id, ModelMap model) {

        Brand brand = brandService.getBrandByKey(id);

        model.addAttribute("brand", brand);

        return "brand/edit";
    }

    //去修改页面
    @RequestMapping(value = "/brand/edit.do")
    public String edit(Brand brand, ModelMap model) {

        brandService.updateBrandByKey(brand);

        return "redirect:/brand/list.do";
    }
}
