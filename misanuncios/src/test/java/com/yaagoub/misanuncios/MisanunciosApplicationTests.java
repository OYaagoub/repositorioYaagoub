package com.yaagoub.misanuncios;

import com.yaagoub.misanuncios.domain.Category;
import com.yaagoub.misanuncios.domain.Permission;
import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.infrastructure.config.spring.MisanunciosApplication;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.*;
import com.yaagoub.misanuncios.infrastructure.db.database.model.CategoryEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ProductEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.repository.*;

import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CategoryDtoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@SpringBootTest(classes = MisanunciosApplication.class)
@ContextConfiguration
class MisanunciosApplicationTests {
	@Autowired
	private   SpringDataRoleRepository springDataRoleRepository;
	@Autowired
	private  SpringDataNotificationRepository springDataNotificationRepository;
	@Autowired
	private RoleEntityMapper roleEntityMapper;

	@Autowired
	private CategoryEntityMapper categoryEntityMapper;
	@Autowired
	private CategoryDtoMapper categoryDtoMapper;
	@Autowired
	private SpringDataProductRepository springDataProductRepository;

	@Autowired
	private SpringDataCategoryRepository springDataCategoryRepository;
	@Autowired
	private SpringDataPermissionRepository springDataPermissionRepository;

	@Autowired
	private PermissionEntityMapper permissionEntityMapper;
	@Autowired
	private SpringDataUserRepository springDataUserRepository;
	private CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
	private CycleAvoidingMappingContext contextDto = new CycleAvoidingMappingContext();

    /*
    * Work 100%
    * */
	@Test
	void SaveRolesTestRepository() {

		String[] roles = {"admin","user","super-admin"};
		Arrays.asList(roles).forEach(role -> {
			RoleEntity rolled=new RoleEntity();
			rolled.setName(role);
			springDataRoleRepository.save(rolled);
		});



	}
	@Test
	void setDateToNotification(){
		AtomicInteger id= new AtomicInteger(50);
		springDataNotificationRepository.findAll().stream().forEach(
				notificationEntity -> {
					System.out.println("----------antes---------");
					System.out.println(notificationEntity);

                    try {
                        notificationEntity.setSendAt(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2017-12-15 10:"+ (id.decrementAndGet())));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
					springDataNotificationRepository.save(notificationEntity);
					System.out.println("----------despues---------");
					System.out.println(notificationEntity);


                }
		);
	}
	@Test
	void ShowCategoryEntity(){
		List<Category> categories = springDataCategoryRepository.findAll().stream()
				.map(categoryEntity -> {
					System.out.println(categoryEntity);
					return  categoryEntityMapper.toDomain(categoryEntity,context);
				})
				.collect(Collectors.toList());
		categories.forEach(System.out::println);
	}

	@Test
	void ShowRolesEntity(){
		List<Role> roles = springDataRoleRepository.findAll().stream()
				.map(roleEntity -> {
					System.out.println(roleEntity.toString());
					return  roleEntityMapper.toDomain(roleEntity,context);
				})
				.collect(Collectors.toList());
		roles.forEach(System.out::println);
	}
	@Test
	void ShowPermissionsEntity(){
		List<Permission> permissions = springDataPermissionRepository.findAll().stream()
				.map(permissionEntity -> {
					System.out.println(permissionEntity.toString());
					return  permissionEntityMapper.toDomain(permissionEntity,context);
				})
				.collect(Collectors.toList());
		permissions.forEach(System.out::println);
	}

	@Test
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

	@Test
	void SaveProductsCars(){
		UserEntity user = springDataUserRepository.findByEmail("developer@e.com");

		// Set other user details as needed

		CategoryEntity category = springDataCategoryRepository.findById(1L).orElse(null);

		// Set other category details as needed

		// Create instances of ProductEntity for each car
		ProductEntity car1 = new ProductEntity();
		car1.setTitle("Toyota Camry");
		car1.setDescription("A reliable sedan with great fuel efficiency.");
		car1.setUser(user);
		car1.setPrice("4.434");
		car1.setCategory(category);

		ProductEntity car2 = new ProductEntity();
		car2.setTitle("Honda Civic");
		car2.setDescription("A compact car known for its practicality and reliability.");
		car2.setUser(user);
		car2.setPrice("3.434");
		car2.setCategory(category);

		ProductEntity car3 = new ProductEntity();
		car3.setTitle("Ford Mustang");
		car3.setDescription("An iconic American muscle car with powerful performance.");
		car3.setUser(user);
		car3.setPrice("2.434");
		car3.setCategory(category);

		ProductEntity car4 = new ProductEntity();
		car4.setTitle("BMW 3 Series");
		car4.setDescription("A luxury sports sedan offering a balance of performance and comfort.");
		car4.setUser(user);
		car4.setPrice("34.434");
		car4.setCategory(category);

		ProductEntity car5 = new ProductEntity();
		car5.setTitle("Tesla Model 3");
		car5.setDescription("An electric sedan with cutting-edge technology and impressive range.");
		car5.setUser(user);
		car5.setPrice("46.434");
		car5.setCategory(category);

		ProductEntity car6 = new ProductEntity();
		car6.setTitle("Chevrolet Silverado");
		car6.setDescription("A rugged and versatile pickup truck suitable for work and play.");
		car6.setUser(user);
		car6.setPrice("1.434");
		car6.setCategory(category);

		ProductEntity car7 = new ProductEntity();
		car7.setTitle("Mercedes-Benz E-Class");
		car7.setDescription("A luxurious executive sedan known for its comfort and refinement.");
		car7.setUser(user);
		car7.setPrice("434.000");
		car7.setCategory(category);

	// Add the ProductEntity instances to a list or set
		Set<ProductEntity> cars = new LinkedHashSet<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		cars.add(car6);
		cars.add(car7);
		cars.forEach(productEntity -> springDataProductRepository.save(productEntity));
	}

	@Test
	void SaveProductsMotos() {
		UserEntity user = springDataUserRepository.findByEmail("developer@e.com");

		// Set other user details as needed

		CategoryEntity category = springDataCategoryRepository.findById(2L).orElse(null);

		// Set other category details as needed

		// Create instances of ProductEntity for each moto
		ProductEntity moto1 = new ProductEntity();
		moto1.setTitle("Yamaha MT-07");
		moto1.setDescription("A versatile and agile motorcycle suitable for daily commuting and weekend rides.");
		moto1.setUser(user);
		moto1.setCategory(category);

		ProductEntity moto2 = new ProductEntity();
		moto2.setTitle("Honda CB650R");
		moto2.setDescription("A stylish and powerful naked bike with excellent handling and performance.");
		moto2.setUser(user);
		moto2.setCategory(category);

		ProductEntity moto3 = new ProductEntity();
		moto3.setTitle("Kawasaki Ninja ZX-6R");
		moto3.setDescription("A high-performance sportbike known for its sharp handling and strong acceleration.");
		moto3.setUser(user);
		moto3.setCategory(category);

		ProductEntity moto4 = new ProductEntity();
		moto4.setTitle("Suzuki GSX-R750");
		moto4.setDescription("An iconic sportbike with a perfect balance of power and agility.");
		moto4.setUser(user);
		moto4.setCategory(category);

		ProductEntity moto5 = new ProductEntity();
		moto5.setTitle("Ducati Monster 821");
		moto5.setDescription("A premium naked bike with Italian flair and thrilling performance.");
		moto5.setUser(user);
		moto5.setCategory(category);

		ProductEntity moto6 = new ProductEntity();
		moto6.setTitle("BMW S1000RR");
		moto6.setDescription("A high-tech superbike offering blistering speed and precision handling.");
		moto6.setUser(user);
		moto6.setCategory(category);

		ProductEntity moto7 = new ProductEntity();
		moto7.setTitle("Harley-Davidson Street Glide");
		moto7.setDescription("An iconic cruiser with a comfortable ride and classic American styling.");
		moto7.setUser(user);
		moto7.setCategory(category);

		// Add the ProductEntity instances to a list or set
		Set<ProductEntity> motos = new LinkedHashSet<>();
		motos.add(moto1);
		motos.add(moto2);
		motos.add(moto3);
		motos.add(moto4);
		motos.add(moto5);
		motos.add(moto6);
		motos.add(moto7);
		motos.forEach(productEntity -> springDataProductRepository.save(productEntity));
	}

	@Test
	void saveProductsAccesorios() {
		UserEntity user = springDataUserRepository.findByEmail("developer@e.com");

		// Fetch the category by name
		CategoryEntity category = springDataCategoryRepository.findById(3L).orElse(null);

		// Create instances of ProductEntity for each accessory
		ProductEntity accessory1 = new ProductEntity();
		accessory1.setTitle("Car Air Freshener");
		accessory1.setDescription("Keep your car smelling fresh with this long-lasting air freshener.");
		accessory1.setUser(user);
		accessory1.setCategory(category);

		ProductEntity accessory2 = new ProductEntity();
		accessory2.setTitle("Phone Holder for Car");
		accessory2.setDescription("Securely mount your phone on the dashboard for hands-free navigation.");
		accessory2.setUser(user);
		accessory2.setCategory(category);

		ProductEntity accessory3 = new ProductEntity();
		accessory3.setTitle("Car Seat Covers");
		accessory3.setDescription("Protect your car seats while adding style with these comfortable seat covers.");
		accessory3.setUser(user);
		accessory3.setCategory(category);

		// Repeat the process for other accessories...

		// Add the ProductEntity instances to a set
		Set<ProductEntity> accessories = new LinkedHashSet<>();
		accessories.add(accessory1);
		accessories.add(accessory2);
		accessories.add(accessory3);
		// Add the other accessories...

		// Save all the products
		accessories.forEach(productEntity -> springDataProductRepository.save(productEntity));
	}

	@Test
	void saveProductsModaYAccesorios() {
		UserEntity user = springDataUserRepository.findByEmail("developer@e.com");

		// Fetch the category by name
		CategoryEntity category = springDataCategoryRepository.findById(4L).orElse(null);

		// Create instances of ProductEntity for each fashion item or accessory
		ProductEntity item1 = new ProductEntity();
		item1.setTitle("Designer Handbag");
		item1.setDescription("Elevate your style with this luxurious designer handbag.");
		item1.setUser(user);
		item1.setCategory(category);

		ProductEntity item2 = new ProductEntity();
		item2.setTitle("Men's Leather Wallet");
		item2.setDescription("Stay organized in style with this high-quality leather wallet.");
		item2.setUser(user);
		item2.setCategory(category);

		ProductEntity item3 = new ProductEntity();
		item3.setTitle("Women's Sunglasses");
		item3.setDescription("Protect your eyes while looking chic with these fashionable sunglasses.");
		item3.setUser(user);
		item3.setCategory(category);

		// Repeat the process for other fashion items...

		// Add the ProductEntity instances to a set
		Set<ProductEntity> modaYAccesorios = new LinkedHashSet<>();
		modaYAccesorios.add(item1);
		modaYAccesorios.add(item2);
		modaYAccesorios.add(item3);
		// Add the other fashion items...

		// Save all the products
		modaYAccesorios.forEach(productEntity -> springDataProductRepository.save(productEntity));
	}

	@Test
	void saveRealEstateProperties() {
		UserEntity user = springDataUserRepository.findByEmail("developer@e.com");

		// Fetch the category by name
		CategoryEntity category = springDataCategoryRepository.findById(5L).orElse(null);

		// Create instances of ProductEntity for each real estate property
		ProductEntity property1 = new ProductEntity();
		property1.setTitle("Spacious Family Home");
		property1.setDescription("Beautiful 4-bedroom family home in a quiet neighborhood. Features a large backyard and modern amenities.");
		property1.setUser(user);
		property1.setCategory(category);

		ProductEntity property2 = new ProductEntity();
		property2.setTitle("Luxury Apartment with City Views");
		property2.setDescription("Stunning 2-bedroom apartment located in the heart of the city. Offers panoramic views and top-notch facilities.");
		property2.setUser(user);
		property2.setCategory(category);

		ProductEntity property3 = new ProductEntity();
		property3.setTitle("Cozy Cottage in the Countryside");
		property3.setDescription("Charming cottage nestled in scenic countryside surroundings. Perfect for a peaceful retreat.");
		property3.setUser(user);
		property3.setCategory(category);

		// Repeat the process for other real estate properties...

		// Add the ProductEntity instances to a set
		Set<ProductEntity> realEstateProperties = new LinkedHashSet<>();
		realEstateProperties.add(property1);
		realEstateProperties.add(property2);
		realEstateProperties.add(property3);
		// Add the other real estate properties...

		// Save all the products
		realEstateProperties.forEach(productEntity -> springDataProductRepository.save(productEntity));
	}

	@Test
	void saveTechnologyAndElectronicsProducts() {
		UserEntity user = springDataUserRepository.findByEmail("developer@e.com");

		// Fetch the category by name
		CategoryEntity category = springDataCategoryRepository.findById(6L).orElse(null);

		// Create instances of ProductEntity for each technology and electronics product
		ProductEntity product1 = new ProductEntity();
		product1.setTitle("Smartphone");
		product1.setDescription("Latest model smartphone with high-resolution display, fast processor, and advanced camera features.");
		product1.setUser(user);
		product1.setCategory(category);

		ProductEntity product2 = new ProductEntity();
		product2.setTitle("Laptop");
		product2.setDescription("Powerful laptop with a sleek design, large storage capacity, and long battery life. Ideal for work and entertainment.");
		product2.setUser(user);
		product2.setCategory(category);

		ProductEntity product3 = new ProductEntity();
		product3.setTitle("Smart TV");
		product3.setDescription("Ultra HD smart TV with built-in streaming apps, voice control, and immersive sound technology. Transform your living room experience.");
		product3.setUser(user);
		product3.setCategory(category);

		// Repeat the process for other technology and electronics products...

		// Add the ProductEntity instances to a set
		Set<ProductEntity> technologyAndElectronicsProducts = new LinkedHashSet<>();
		technologyAndElectronicsProducts.add(product1);
		technologyAndElectronicsProducts.add(product2);
		technologyAndElectronicsProducts.add(product3);
		// Add the other technology and electronics products...

		// Save all the products
		technologyAndElectronicsProducts.forEach(productEntity -> springDataProductRepository.save(productEntity));
	}

	@Test
	void saveSportsAndLeisureProducts() {
		UserEntity user = springDataUserRepository.findByEmail("developer@e.com");

		// Fetch the category by name
		CategoryEntity category = springDataCategoryRepository.findById(7L).orElse(null);

		// Create instances of ProductEntity for each sports and leisure product
		ProductEntity product1 = new ProductEntity();
		product1.setTitle("Mountain Bike");
		product1.setDescription("High-performance mountain bike with lightweight frame, advanced suspension, and rugged tires. Perfect for off-road adventures.");
		product1.setUser(user);
		product1.setCategory(category);

		ProductEntity product2 = new ProductEntity();
		product2.setTitle("Treadmill");
		product2.setDescription("Commercial-grade treadmill with powerful motor, adjustable incline, and built-in workout programs. Stay fit and active from the comfort of your home.");
		product2.setUser(user);
		product2.setCategory(category);

		ProductEntity product3 = new ProductEntity();
		product3.setTitle("Fishing Rod");
		product3.setDescription("Premium fishing rod crafted from durable materials, featuring sensitive tip and comfortable grip. Enjoy a relaxing day of fishing by the lake.");
		product3.setUser(user);
		product3.setCategory(category);

		// Repeat the process for other sports and leisure products...

		// Add the ProductEntity instances to a set
		Set<ProductEntity> sportsAndLeisureProducts = new LinkedHashSet<>();
		sportsAndLeisureProducts.add(product1);
		sportsAndLeisureProducts.add(product2);
		sportsAndLeisureProducts.add(product3);
		// Add the other sports and leisure products...

		// Save all the products
		sportsAndLeisureProducts.forEach(productEntity -> springDataProductRepository.save(productEntity));
	}

	@Test
	void saveHomeAndGardenProducts() {
		UserEntity user = springDataUserRepository.findByEmail("developer@e.com");

		// Fetch the category by name
		CategoryEntity category = springDataCategoryRepository.findById(8L).orElse(null);

		// Create instances of ProductEntity for each home and garden product
		ProductEntity product1 = new ProductEntity();
		product1.setTitle("Garden Furniture Set");
		product1.setDescription("Complete outdoor furniture set including a table, chairs, and umbrella. Ideal for enjoying meals and gatherings in the garden or patio.");
		product1.setUser(user);
		product1.setCategory(category);

		ProductEntity product2 = new ProductEntity();
		product2.setTitle("Smart Home Security System");
		product2.setDescription("Advanced home security system with smart sensors, cameras, and alarm. Protect your home and family with state-of-the-art technology.");
		product2.setUser(user);
		product2.setCategory(category);

		ProductEntity product3 = new ProductEntity();
		product3.setTitle("Indoor Plant Collection");
		product3.setDescription("Assortment of indoor plants including succulents, ferns, and air-purifying plants. Add greenery and freshness to your home interior.");
		product3.setUser(user);
		product3.setCategory(category);

		// Repeat the process for other home and garden products...

		// Add the ProductEntity instances to a set
		Set<ProductEntity> homeAndGardenProducts = new LinkedHashSet<>();
		homeAndGardenProducts.add(product1);
		homeAndGardenProducts.add(product2);
		homeAndGardenProducts.add(product3);
		// Add the other home and garden products...

		// Save all the products
		homeAndGardenProducts.forEach(productEntity -> springDataProductRepository.save(productEntity));
	}

	@Test
	void saveOtherProducts() {
		UserEntity user = springDataUserRepository.findByEmail("developer@e.com");

		// Fetch the category by name
		CategoryEntity category = springDataCategoryRepository.findById(9L).orElse(null);

		// Create instances of ProductEntity for miscellaneous products
		ProductEntity product1 = new ProductEntity();
		product1.setTitle("Vintage Vinyl Record Player");
		product1.setDescription("Classic turntable with built-in speakers and Bluetooth connectivity. Enjoy your favorite vinyl records with modern convenience.");
		product1.setUser(user);
		product1.setCategory(category);

		ProductEntity product2 = new ProductEntity();
		product2.setTitle("Travel Backpack");
		product2.setDescription("Durable backpack designed for travel enthusiasts. Features multiple compartments, padded straps, and water-resistant material.");
		product2.setUser(user);
		product2.setCategory(category);

		ProductEntity product3 = new ProductEntity();
		product3.setTitle("Portable Espresso Maker");
		product3.setDescription("Compact espresso machine for brewing coffee on the go. Enjoy delicious espresso wherever you are, whether camping, hiking, or traveling.");
		product3.setUser(user);
		product3.setCategory(category);

		// Repeat the process for other miscellaneous products...

		// Add the ProductEntity instances to a set
		Set<ProductEntity> otherProducts = new LinkedHashSet<>();
		otherProducts.add(product1);
		otherProducts.add(product2);
		otherProducts.add(product3);
		// Add the other miscellaneous products...

		// Save all the products
		otherProducts.forEach(productEntity -> springDataProductRepository.save(productEntity));
	}
	@Test
	void SaveAllProducts(){
		SaveProductsCars();
		SaveProductsMotos();
		saveProductsAccesorios();
		saveProductsModaYAccesorios();
		saveRealEstateProperties();
		saveTechnologyAndElectronicsProducts();
		saveSportsAndLeisureProducts();
		saveHomeAndGardenProducts();
		saveOtherProducts();

	}




}
