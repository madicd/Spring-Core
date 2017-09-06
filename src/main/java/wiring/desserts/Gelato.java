package wiring.desserts;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("iceCream")
public class Gelato implements Dessert {
}
