package com.sample.workshopcassandra;

import com.sample.workshopcassandra.model.embedded.Prop;
import com.sample.workshopcassandra.model.entities.Department;
import com.sample.workshopcassandra.model.entities.Product;
import com.sample.workshopcassandra.model.enums.PropType;
import com.sample.workshopcassandra.repositories.DepartmentRepository;
import com.sample.workshopcassandra.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

@Component
@Profile("test")
public class Startup implements CommandLineRunner {


    private final DepartmentRepository departmentRepository;

    private final ProductRepository productRepository;

    public Startup(DepartmentRepository departmentRepository,ProductRepository productRepository) {
        this.departmentRepository = departmentRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        departmentRepository.deleteAll();
        productRepository.deleteAll();

        Department d1 = new Department(UUID.randomUUID(), "Livros");
        Department d2 = new Department(UUID.randomUUID(), "Computadores");
        Department d3 = new Department(UUID.randomUUID(), "Jogos");

        departmentRepository.saveAll(Arrays.asList(d1, d2, d3));

        Product p1 = new Product(UUID.randomUUID(), d1.getName(), 180.90, Instant.parse("2021-02-25T10:00:00Z"), "O Senhor dos anéis", "Um conjunto de amigos se unem para combater uma grande ameaça na Terra Média");
        p1.getProps().add(new Prop("Páginas", "1055", PropType.PRODUCT));
        p1.getProps().add(new Prop("Edição", "5", PropType.PRODUCT));

        Product p2 = new Product(UUID.randomUUID(), d1.getName(), 78.00, Instant.parse("2021-02-26T11:00:00Z"), "O Código da Vinci", "Um grande mistério se desenrola em Paris sobre a busca do Santro Graal");
        p2.getProps().add(new Prop("Páginas", "325", PropType.PRODUCT));
        p2.getProps().add(new Prop("Edição", "3", PropType.PRODUCT));

        Product p3 = new Product(UUID.randomUUID(), d2.getName(), 3490.00, Instant.parse("2021-02-26T12:00:00Z"), "PC Gamer", "Computador especial para quem deseja performance nos seus games");
        p3.getProps().add(new Prop("Memória", "16GB", PropType.PRODUCT));
        p3.getProps().add(new Prop("CPU", "Core i9", PropType.PRODUCT));
        p3.getProps().add(new Prop("Garantia", "1 ano", PropType.CONDITION));

        Product p4 = new Product(UUID.randomUUID(), d2.getName(), 2497.90, Instant.parse("2021-02-26T13:00:00Z"), "Desktop PC", "O equilíbro entre curso e performance para sua comodidade");
        p4.getProps().add(new Prop("Memória", "8GB", PropType.PRODUCT));
        p4.getProps().add(new Prop("CPU", "Core i5", PropType.PRODUCT));
        p4.getProps().add(new Prop("Garantia", "1 ano", PropType.CONDITION));

        Product p5 = new Product(UUID.randomUUID(), d3.getName(), 239.00, Instant.parse("2021-02-27T14:00:00Z"), "The Last of Us 2", "Um mundo pós-apocalíptico enfrente uma grande ameaça novamente");
        p5.getProps().add(new Prop("Ano", "2021", PropType.PRODUCT));

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
