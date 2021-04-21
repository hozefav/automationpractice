package com.mytesting.automation.model.components;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
    protected WebElement rootElement;

    public Product(WebElement rootElement) {
        this.rootElement = rootElement;
    }

    public String getTitle() {
        return rootElement.findElement(By.className("product_img_link")).getAttribute("title");
    }

    public double getOldPrice() {

            //rootElement.findElement(By.className("old-price")).getText().replaceAll("[^0-9\\.]+", "")
            var value = Double.parseDouble(rootElement.findElement(By.className("old-price"))
                                         .getAttribute("innerText")
                                         .replaceAll("[\\s$]", ""))
                                         ;                  
                                     

            System.out.println(value);

            var percent = Double.parseDouble(rootElement.findElement(By.className("price-percent-reduction"))
                                        .getAttribute("innerText")
                                        .replaceAll("[-%]", ""));

            System.out.println(percent);

            var discountedPrice = value - (value * percent / 100);

            System.out.println(discountedPrice);

            //return (0.00);//.format(discountedPrice);

            return discountedPrice; 

    }

    public int getStars() {
        return Integer.parseInt(
            rootElement.findElement(By.className("star-level")).getText()
        );
    }
}
