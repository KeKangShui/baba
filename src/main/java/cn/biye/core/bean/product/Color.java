package cn.biye.core.bean.product;

import java.io.Serializable;

/**
 * 颜色
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */
public class Color implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer parentId;
	private String imgUrl;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String toString() {
		return "Color [id=" + id + ",name=" + name + ",parentId=" + parentId + ",imgUrl=" + imgUrl + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)  //地址
			return true;
		if (obj == null)  //不能null
			return false;
		if (getClass() != obj.getClass()) //cn.itcast.core.bean.color
			return false;
		Color other = (Color) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
		result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
		return result;
	}
}
