package tests;

import helpers.ReadProperties;
import org.junit.jupiter.api.BeforeEach;

/**
 * Class provides some base methods for tests.
 */
public class BaseTest {

    /**
     * Method read properties.
     */
    @BeforeEach
    public void readProperties() {
        ReadProperties.readProperties();
    }

}
