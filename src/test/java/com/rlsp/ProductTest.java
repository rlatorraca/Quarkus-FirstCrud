package com.rlsp;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import com.rlsp.models.Product;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.Test;

@DBRider
@QuarkusTest
@QuarkusTestResource(DataBaseLifeStyle.class)
public class ProductTest {

    @Test
    @DataSet("products.yml")
    public  void firstTest(){
        Assert.assertEquals(1, Product.count());
    }
}

