package com.mytesting.automation.model.components;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductWithColor extends Product {

    public ProductWithColor(WebElement rootElement) {
        super(rootElement);
    }

    public List<String> getColor() {
        var elements = rootElement.findElements(By.className("color_pick"));

        return elements.stream().map(element -> element.getAttribute("href")
                                                        .split("color-")[1])
                                                        .collect(Collectors.toList());  
    }

}
