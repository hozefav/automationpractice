package com.mytesting.automation.model.pages;

import java.util.List;
import java.util.function.Function;

import com.mytesting.automation.model.components.Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

   public HomePage(WebDriver driver) {
        super(driver);        
    }

    public Product chooseDress(Function<Product,Boolean> comparator){

        List<WebElement> elements = driver.findElements(By.className("product-container"));

        return elements
            .stream()
            //.map(element -> new Product(element))
            .map(Product::new)
            //.filter(product -> comparator.apply(product))
            .filter(comparator::apply)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Dress not found"));

    }

    

    

    
}
