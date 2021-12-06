package paramteres;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
    @DataProvider(name = "MultipleValues")
    public Object[][] storeMultipleValues() {
        return new Object[][] {
                {"Sultana","New York",11432},
                {"Anika","New Jersey",22435},
                {"Tasnim","Florida",11435}
        };
    }

    @DataProvider(name = "RealAprRates")
    public Object[][] storeRealAprData() {
        return new Object[][] {
                {"200000","15000","3","3.130%"}
        };
    }

    @Test(dataProvider = "MultipleValues")
    public void readMultipleValues(String Name, String State, int Zipcode) {
        System.out.println("[Multiple column value] Name is: " + Name);
        System.out.println("[Multiple column value] State is: " + State);
        System.out.println("[Multiple column value] Zipcode is: " + Zipcode);
    }
}

