package pageObjectSauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.SouceLab.ProductPageUI;
import commons.BasePage;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
	}

	public boolean isProductNameSortByASC() {
		// Khai bao 1 array list de chua cac product name tren UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lay ra het tat ca cac text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// Dung vong lap de get text va add vao Array list tren
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		// Tao ra 1 Arraylist moi de sort du lieu trong ArrayList cu xem dung hay k
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort cai productSortList
		Collections.sort(productSortList);

		// So sanh 2 List da bang nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDESC() {
		// Khai bao 1 array list de chua cac product name tren UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lay ra het tat ca cac text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// Dung vong lap de get text va add vao Array list tren
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		// Tao ra 1 Arraylist moi de sort du lieu trong ArrayList cu xem dung hay k
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort cai productSortList
		Collections.sort(productSortList);

		// Reverse cai productSortList
		Collections.reverse(productSortList);

		// So sanh 2 List da bang nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByASC() {
		// Khai bao 1 array list de chua cac product name tren UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// Lay ra het tat ca cac text product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

		// Dung vong lap de get text va add vao Array list tren
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		// Tao ra 1 Arraylist moi de sort du lieu trong ArrayList cu xem dung hay k
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		// Sort cai productSortList
		Collections.sort(productSortList);

		// So sanh 2 List da bang nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDESC() {
		// Khai bao 1 array list de chua cac product name tren UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// Lay ra het tat ca cac text product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

		// Dung vong lap de get text va add vao Array list tren
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		// Tao ra 1 Arraylist moi de sort du lieu trong ArrayList cu xem dung hay k
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		// Sort cai productSortList
		Collections.sort(productSortList);

		// Reverse cai productSortList
		Collections.reverse(productSortList);

		// So sanh 2 List da bang nhau
		return productSortList.equals(productUIList);
	}

}
