/**
 * @filename Linkage.java
 * @author wangxiaodong
 * @date 2013-9-27
 * @vsersion 1.0
 * Copyright (C) 2013 辉盛科技发展责任有限公司
 */
package com.hopsun.tppas.webservice.bean.company;

/**
 * @comments 公司地址(linkage)
 * @author wangxiaodong
 * @date 2013-9-27
 * @version 1.0
 */
public class Address {

	// 所在国家（存）
	private String country;
	// 所在国家（展示）
	private String countryName;
	// 所在省份（存）
	private String province;
	// 所在省份（展示）
	private String provinceName;
	// 所在城市（存）
	private String city;
	// 所在城市（展示）
	private String cityName;
	// 所在县（存）
	private String county;
	// 所在县（展示）
	private String countyName;
	// 所在详细地址
	private String address;
	// 所在区域
	private String garden;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String country, String countryName, String province, String provinceName, String city, String cityName, String county, String countyName, String address, String garden) {
		super();
		this.country = country;
		this.countryName = countryName;
		this.province = province;
		this.provinceName = provinceName;
		this.city = city;
		this.cityName = cityName;
		this.county = county;
		this.countyName = countyName;
		this.address = address;
		this.garden = garden;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGarden() {
		return garden;
	}

	public void setGarden(String garden) {
		this.garden = garden;
	}
	
}