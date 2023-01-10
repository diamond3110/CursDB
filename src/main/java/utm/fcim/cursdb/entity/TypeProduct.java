package utm.fcim.cursdb.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "type_product")
public class TypeProduct {
    private int idProduct;
    private String typeProduct;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_type", nullable = false)
    public int getIdType() {
        return idProduct;
    }

    public void setIdType(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "type_product", nullable = true, length = 255)
    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeProduct that = (TypeProduct) o;
        return idProduct == that.idProduct && Objects.equals(typeProduct, that.typeProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, typeProduct);
    }
}
