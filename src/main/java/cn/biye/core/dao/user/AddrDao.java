package cn.biye.core.dao.user;

import cn.biye.core.bean.user.Addr;
import cn.biye.core.query.user.AddrQuery;

import java.util.List;
import cn.biye.core.query.user.*;
public interface AddrDao {

	/**
	 * 添加
	 * @param addr
	 */
	public Integer addAddr(Addr addr);

	/**
	 * 根据主键查找
	 * @param addrQuery
	 */
	public Addr getAddrByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param addrQuery
	 */
	public List<Addr> getAddrsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param addrQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param addrQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param addrQuery
	 */
	public Integer updateAddrByKey(Addr addr);

	/**
	 * 分页查询
	 * @param addrQuery
	 */
	public List<Addr> getAddrListWithPage(AddrQuery addrQuery);

	/**
	 * 集合查询
	 * @param addrQuery
	 */
	public List<Addr> getAddrList(AddrQuery addrQuery);
	
	/**
	 * 总条数
	 * @param addrQuery
	 */
	public int getAddrListCount(AddrQuery addrQuery);
}
