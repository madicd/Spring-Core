package wiring.desserts;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DessertsConfig.class)
public class DessertsTest {

    @Autowired
    @Qualifier("iceCream")
    Dessert dessert;

    @Test
    public void shouldWireIceCream() {
        Assert.assertTrue(dessert instanceof Gelato);
    }
}
