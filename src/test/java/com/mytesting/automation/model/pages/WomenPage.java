package com.mytesting.automation.model.pages;

import java.util.function.Function;

import com.mytesting.automation.model.components.Product;
import com.mytesting.automation.model.components.ProductWithColor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenPage extends BasePage {

    public WomenPage(WebDriver driver) {
        super(driver);

        new WebDriverWait(driver, 10).until(d -> d.findElement(By.className("bottom-pagination-content")).isDisplayed());
    }

    public ProductWithColor getProductWithColor(Function<ProductWithColor,Boolean> comparator){

        var elements = driver.findElements(By.className("product-container"));

        return elements.stream()
                        .map(element -> new ProductWithColor(element))
                        .filter(productWithColor -> comparator.apply(productWithColor))
                        .findFirst()
                        .orElseThrow(()-> new RuntimeException("Product not found"))
                        ;


    }

}
