package utm.fcim.cursdb.entity;




import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "producer")
public class Producer {
    private int idProducer;
    private String nameProducer;
    private String addressProducer;
    private String numberProducer;
    private String emailProducer;

    public String toString(){
        return "Id: " + idProducer +
                "\nName: " + nameProducer +
                "\nAddress: " + addressProducer +
                "\nNumber: " + numberProducer +
                "\nEmail: " + emailProducer;
    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producer", nullable = false)
    public int getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(int idProducer) {
        this.idProducer = idProducer;
    }

    @Basic
    @Column(name = "name_producer", nullable = false, length = 255)
    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    @Basic
    @Column(name = "address_producer", nullable = false, length = 255)
    public String getAddressProducer() {
        return addressProducer;
    }

    public void setAddressProducer(String addressProducer) {
        this.addressProducer = addressProducer;
    }

    @Basic
    @Column(name = "number_producer", nullable = false, length = 255)
    public String getNumberProducer() {
        return numberProducer;
    }

    public void setNumberProducer(String numberProducer) {
        this.numberProducer = numberProducer;
    }

    @Basic
    @Column(name = "email_producer", nullable = false, length = 255)
    public String getEmailProducer() {
        return emailProducer;
    }

    public void setEmailProducer(String emailProducer) {
        this.emailProducer = emailProducer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return idProducer == producer.idProducer && Objects.equals(nameProducer, producer.nameProducer) && Objects.equals(addressProducer, producer.addressProducer) && Objects.equals(numberProducer, producer.numberProducer) && Objects.equals(emailProducer, producer.emailProducer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducer, nameProducer, addressProducer, numberProducer, emailProducer);
    }
}
