package Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    public List<Product> products=new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }
    public void displayProduct(){
        for(Product product: products)
        {
            System.out.println(product.toString());
        }
    }
    public Product findProduct(int index)
    {
        return products.get(index);
    }
}
