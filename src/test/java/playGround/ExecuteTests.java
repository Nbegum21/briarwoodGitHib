package playGround;

import org.testng.annotations.Test;
import paramteres.DataProviderClass;

public class ExecuteTests {
    @Test(dataProvider = "MultipleValues",dataProviderClass = DataProviderClass.class)
    public void run(String Name, String State, int Zipcode) {
        System.out.println("[Multiple column value] Name is: " + Name);
        System.out.println("[Multiple column value] State is: " + State);
        System.out.println("[Multiple column value] Zipcode is: " + Zipcode);
    }
}
