package com.sqsm.entity;

public class Food {
	private int id;
	private String foodName;
	private String foodImg;
	private String changeToA;
	private String time;
	private String material1;
	private String material2;
	private String material3;
	private String material4;
	private String material5;
	private String step1;
	private String step2;
	private String step3;
	private String step4;
	private String step5;
	private String hot_degree;
	private String sort;
	private String upload_user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	public String getChangeToA() {
		return changeToA;
	}
	public void setChangeToA(String changeToA) {
		this.changeToA = changeToA;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMaterial1() {
		return material1;
	}
	public void setMaterial1(String material1) {
		this.material1 = material1;
	}
	public String getMaterial2() {
		return material2;
	}
	public void setMaterial2(String material2) {
		this.material2 = material2;
	}
	public String getMaterial3() {
		return material3;
	}
	public void setMaterial3(String material3) {
		this.material3 = material3;
	}
	public String getMaterial4() {
		return material4;
	}
	public void setMaterial4(String material4) {
		this.material4 = material4;
	}
	public String getMaterial5() {
		return material5;
	}
	public void setMaterial5(String material5) {
		this.material5 = material5;
	}
	public String getStep1() {
		return step1;
	}
	public void setStep1(String step1) {
		this.step1 = step1;
	}
	public String getStep2() {
		return step2;
	}
	public void setStep2(String step2) {
		this.step2 = step2;
	}
	public String getStep3() {
		return step3;
	}
	public void setStep3(String step3) {
		this.step3 = step3;
	}
	public String getStep4() {
		return step4;
	}
	public void setStep4(String step4) {
		this.step4 = step4;
	}
	public String getStep5() {
		return step5;
	}
	public void setStep5(String step5) {
		this.step5 = step5;
	}
	public String getHot_degree() {
		return hot_degree;
	}
	public void setHot_degree(String hot_degree) {
		this.hot_degree = hot_degree;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getUpload_user() {
		return upload_user;
	}
	public void setUpload_user(String upload_user) {
		this.upload_user = upload_user;
	}
	public Food(int id, String foodName, String foodImg, String changeToA,
			String time, String material1, String material2, String material3,
			String material4, String material5, String step1, String step2,
			String step3, String step4, String step5, String hot_degree,
			String sort, String upload_user) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.foodImg = foodImg;
		this.changeToA = changeToA;
		this.time = time;
		this.material1 = material1;
		this.material2 = material2;
		this.material3 = material3;
		this.material4 = material4;
		this.material5 = material5;
		this.step1 = step1;
		this.step2 = step2;
		this.step3 = step3;
		this.step4 = step4;
		this.step5 = step5;
		this.hot_degree = hot_degree;
		this.sort = sort;
		this.upload_user = upload_user;
	}
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", foodName=" + foodName + ", foodImg="
				+ foodImg + ", changeToA=" + changeToA + ", time=" + time
				+ ", material1=" + material1 + ", material2=" + material2
				+ ", material3=" + material3 + ", material4=" + material4
				+ ", material5=" + material5 + ", step1=" + step1 + ", step2="
				+ step2 + ", step3=" + step3 + ", step4=" + step4 + ", step5="
				+ step5 + ", hot_degree=" + hot_degree + ", sort=" + sort
				+ ", upload_user=" + upload_user + "]";
	}
	
	
	
	
}
