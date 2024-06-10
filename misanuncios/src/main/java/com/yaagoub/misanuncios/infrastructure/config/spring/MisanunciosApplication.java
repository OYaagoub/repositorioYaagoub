package com.yaagoub.misanuncios.infrastructure.config.spring;

import com.yaagoub.misanuncios.infrastructure.db.database.model.CategoryEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.repository.SpringDataCategoryRepository;
import com.yaagoub.misanuncios.infrastructure.db.database.repository.SpringDataRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "com.yaagoub.misanuncios.infrastructure")
@EntityScan(basePackages = "com.yaagoub.misanuncios.infrastructure.db.database.model")
public class MisanunciosApplication {
  @Autowired
  private SpringDataRoleRepository springDataRoleRepository;
  @Autowired
  private SpringDataCategoryRepository springDataCategoryRepository;

  public static void main(String[] args) {
    SpringApplication.run(MisanunciosApplication.class);
  }


  void SaveRolesTestRepository() {

    String[] roles = {"admin","user"};
    Arrays.asList(roles).forEach(role -> {
      RoleEntity rolled=new RoleEntity();
      rolled.setName(role);
      springDataRoleRepository.save(rolled);
    });



  }

  void SaveCategories(){
    String[] categories = {
            "Coches", "Motos", "Motor y Accesorios", "Moda y Accesorios", "Inmobiliaria",
            "Tecnología y Electrónica",  "Deporte y Ocio", "Hogar y Jardín", "Otros"
    };
    for (String category : categories) {
      CategoryEntity categoryEntity = new CategoryEntity();
      categoryEntity.setName(category);
      springDataCategoryRepository.save(categoryEntity);
    }
  }

  @PostConstruct
  public void init() {
    // Code to run after the bean is initialized
    this.SaveCategories();
    this.SaveRolesTestRepository();

  }
}
