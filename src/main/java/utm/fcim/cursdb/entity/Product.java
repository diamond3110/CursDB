package utm.fcim.cursdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    private int idProduct;
    private int idProducer;
    private String nameProducer;
    private int idType;
    private String typeProduct;
    private String nameProduct;
    private String ecoProduct;
    private double priceProduct;

    public String toString(){
        return "Product[" + idProduct + "," + nameProduct + "," + idProducer + "," + nameProducer
                + "," + idType + "," + typeProduct + "," + ecoProduct + "," + priceProduct + "]";

    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product", nullable = false)
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "id_producer", nullable = false)
    public int getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(int idProducer) {
        this.idProducer = idProducer;
    }

    @Basic
    @Column(name = "id_type", nullable = false)
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "name_product", nullable = false, length = 255)
    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Basic
    @Column(name = "eco_product", nullable = true, length = 255)
    public String getEcoProduct() {
        return ecoProduct;
    }

    public void setEcoProduct(String ecoProduct) {
        this.ecoProduct = ecoProduct;
    }

    @Basic
    @Column(name = "price_product", nullable = false, precision = 0)
    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idProduct == product.idProduct && idProducer == product.idProducer && idType == product.idType && Double.compare(product.priceProduct, priceProduct) == 0 && Objects.equals(nameProduct, product.nameProduct) && Objects.equals(ecoProduct, product.ecoProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idProducer, idType, nameProduct, ecoProduct, priceProduct);
    }

    public String getNameProducer(){return nameProducer;}
    public void setNameProducer(String nameProducer){ this.nameProducer = nameProducer; }

    public String getTypeProduct(){return typeProduct;}
    public void setTypeProduct(String typeProduct){ this.typeProduct = typeProduct; }
}
