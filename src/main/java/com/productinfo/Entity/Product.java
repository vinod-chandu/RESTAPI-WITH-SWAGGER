package com.productinfo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_Data")
public class Product {

	@Id
	@GeneratedValue
	private Integer productId;
	private String productName;
	private Double productCost;
	private Double productRateings;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductCost() {
		return productCost;
	}

	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}

	public Double getProductRateings() {
		return productRateings;
	}

	public void setProductRateings(Double productRateings) {
		this.productRateings = productRateings;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productRateings=" + productRateings + ", getProductId()=" + getProductId() + ", getProductName()="
				+ getProductName() + ", getProductCost()=" + getProductCost() + ", getProductRateings()="
				+ getProductRateings() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
