package com.mytesting.automation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mytesting.automation.model.data.DressData;
import com.mytesting.automation.model.pages.HomePage;
import com.mytesting.automation.tests.dataProviders.CsvToDressData;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class ShopTests extends BaseTests {

    @Test
    void calculateDiscount(){
        var discountPrice = open(HomePage.class)
                        .chooseDress(p -> p.getTitle().equals("Printed Chiffon Dress"))
                        .getOldPrice();

           assertEquals(16.40,discountPrice,0.001);   
       }

    @Test
    void validateColor(){
        var colors = open(HomePage.class)
                        .clickWomenMenu()
                        .getProductWithColor(p -> p.getTitle().equals("Printed Summer Dress") && p.getColor().contains("blue"))
                        .getColor() ;
        
        assertTrue(colors.contains("blue"));
    }

    @ParameterizedTest
    @CsvSource({
        "Printed Dress,pink",
        "Printed Chiffon Dress,yellow"
    })
    void validateColorDataDrivenTest(@CsvToDressData DressData dressData){
        
        var colors = open(HomePage.class)
                        .clickWomenMenu()
                        .getProductWithColor(p -> p.getTitle().equals(dressData.dressType()) && p.getColor().contains(dressData.color()))
                        .getColor() ;
        
        assertTrue(colors.contains(dressData.color()));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dress_data.csv",numLinesToSkip = 1)
    void validateColorDataDrivenTestFile(@CsvToDressData DressData dressData){
        var colors = open(HomePage.class)
                        .clickWomenMenu()
                        .getProductWithColor(p -> p.getTitle().equals(dressData.dressType()) && p.getColor().contains(dressData.color()))
                        .getColor() ;
        
        assertTrue(colors.contains(dressData.color()));
    }

    @Test
    void validateRatingForProduct() {
        var rating = open(HomePage.class)
            .clickShopMenu()
            .getProduct(p -> p.getTitle().equals("Funny Cow"))
            .getStars();
        assertEquals(0,rating);
    }
    
}
