package design.mode.factory;


import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    public  Product createProduct(String owner){
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add((IDCard)product).getOwner();
    }


    public List getOwners(){
        return owners;
    }
}
