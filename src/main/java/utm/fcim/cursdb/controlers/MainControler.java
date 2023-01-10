package utm.fcim.cursdb.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utm.fcim.cursdb.entity.Producer;
import utm.fcim.cursdb.entity.Product;
import utm.fcim.cursdb.entity.TypeProduct;
import utm.fcim.cursdb.repository.ProducerRepository;
import utm.fcim.cursdb.repository.ProductRepository;
import utm.fcim.cursdb.repository.TypeProductRepository;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

@Controller
public class MainControler {
    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TypeProductRepository typeProductRepository;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Главная страница");
        return "home";
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("title", "Авторизация");
        return "login";
    }

    @GetMapping("/singup")
    public String singup(Model model){
        model.addAttribute("title", "Регистрация");
        return "singup";
    }

    @GetMapping("/producers")
    public String producers(Model model){
        Iterable<Producer> producers = producerRepository.findAll();
        model.addAttribute("title", "Производители");
        model.addAttribute("producers", producers);
        return "producers";
    }
    @GetMapping("/products")
    public String products(@ModelAttribute String sort, Model model){
        Iterable<Product> products = sortProducts();
        Iterable<TypeProduct> typeProducts = typeProductRepository.findAll();
        model.addAttribute("title", "Продукты");
        model.addAttribute("type", typeProducts);
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/producer-add")
    public String addProducer(Model model){
        model.addAttribute("title", "Добавить производителя");
        return "producer-add";
    }

    @PostMapping("/producer-add")
    public String postAddProducer(@RequestParam String nameProducer, @RequestParam String addressProducer,
                                  @RequestParam String numberProducer, @RequestParam String emailProducer,
                                  Model model){
        Producer producer = new Producer();
        producer.setNameProducer(nameProducer);
        producer.setAddressProducer(addressProducer);
        producer.setNumberProducer("+373" + numberProducer);
        producer.setEmailProducer(emailProducer);
        System.out.println(producer);
        producerRepository.save(producer);
        return "redirect:/";
    }


        @GetMapping("/product-add")
    public String addProduct(Model model){
        Iterable<Producer> producers = producerRepository.findAll();
        Iterable<TypeProduct> types = typeProductRepository.findAll();
        model.addAttribute("producers", producers);
        model.addAttribute("types", types);
        model.addAttribute("title", "Добавить продукт");
        return "product-add";
    }

    @PostMapping("/product-add")
    public String postAddProducer(@RequestParam String nameProduct, @RequestParam Double priceProduct,
                                  @RequestParam String eco, @RequestParam String nameProducer,
                                  @RequestParam String typeProduct, Model model){
        Product product = new Product();
        product.setNameProduct(nameProduct);
        product.setPriceProduct(priceProduct);
        product.setEcoProduct(eco);
        product.setNameProducer("");
        product.setTypeProduct("");
        Iterable<Producer> producers = producerRepository.findAll();
        Iterable<TypeProduct> typeProducts = typeProductRepository.findAll();
        for(Producer producer: producers){
            if(nameProducer.equals(producer.getNameProducer())){
                product.setIdProducer(producer.getIdProducer());
                System.out.println("ДА" + product.getIdProducer());
            }
        }
        for(TypeProduct type: typeProducts){
            if(typeProduct.equals(type.getTypeProduct())){
                product.setIdType(type.getIdType());
            }
        }
        System.out.println(product);
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/producers/{id}")
    public String aboutProducer(@PathVariable(value = "id") Integer id, Model model){
        Optional<Producer> producers = producerRepository.findById(id);
        ArrayList<Producer> res = new ArrayList<>();
        producers.ifPresent(res::add);
        Iterable<Product> products = productRepository.findAll();
        ArrayList<Product> result = new ArrayList<>();
        Iterable<TypeProduct> typeProducts = typeProductRepository.findAll();
        for(Product p: products){
            if(res.get(0).getIdProducer()==p.getIdProducer()){
                for(TypeProduct type: typeProducts){
                    if(p.getIdType() == type.getIdType()) p.setTypeProduct(type.getTypeProduct());
                }
                result.add(p);
            }
        }
        model.addAttribute("title", res.get(0).getNameProducer());
        model.addAttribute("producer", res);
        model.addAttribute("products", result);
        return "producer-info";
    }

    public Iterable<Product> sortProducts() {
        Iterable<Product> products = productRepository.findAll();
        Iterable<Producer> producers = producerRepository.findAll();
        Iterable<TypeProduct> typeProducts = typeProductRepository.findAll();
        for(Product p: products){
            for(Producer prod: producers){
                if(p.getIdProducer()==prod.getIdProducer()){
                    p.setNameProducer(prod.getNameProducer());
                }
            }
            for(TypeProduct type: typeProducts){
                if(p.getIdType()==type.getIdType()){
                    p.setTypeProduct(type.getTypeProduct());
                }
            }

        }
        return products;
    }
}
