package com.cares.boot3.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cares.boot3.util.Pager;

@Mapper
public interface ProductMapper {

	public List<ProductVO> getList(Pager pager)throws Exception;

	public int setAdd(ProductVO productVO)throws Exception;

	public int setFileAdd(ProductFilesVO productFilesVO)throws Exception;

}