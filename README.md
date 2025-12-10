# 🛒 Spring Boot E-Commerce API (aka "The Product Whisperer")

> *Because the world needed another e-commerce platform... said every developer ever.*

Welcome to the most over-engineered shopping cart you'll see today! This is a RESTful API built with Spring Boot that lets you manage products like a pro. It's got everything: CRUD operations, image uploads, keyword search, and an in-memory database that forgets everything when you turn it off (just like my short-term memory after too much coffee ☕).

## 🎭 What Is This Thing?

It's a Spring Boot REST API for managing products in an e-commerce system. Think of it as the backend that powers your dreams of becoming the next tech billionaire, minus the billion dollars and the actual frontend.

**Fun fact:** This project has more products in its seed data than items in my actual shopping cart. Priorities, right?

## ✨ Features That'll Make Your Dev Heart Sing

- 🎯 **Full CRUD Operations** - Create, Read, Update, Delete products (because sometimes you just need to delete that $999 iPhone from existence)
- 🖼️ **Image Upload Support** - Store product images as byte arrays (we're fancy like that)
- 🔍 **Smart Search** - Find products by name, description, brand, or category (powered by JPQL wizardry)
- 📦 **15 Pre-loaded Products** - From iPhones to gaming consoles, we've got your test data covered
- 🚀 **H2 In-Memory Database** - Fast, furious, and completely forgetful
- 🎨 **Clean Architecture** - Controller → Service → Repository (we follow the rules, unlike JavaScript developers)

## 🛠️ Tech Stack (The Cool Kids Table)

- **Spring Boot 3.5.8** - Because we like our Spring fresh
- **Java 17** - Old enough to vote, young enough to be hip
- **Spring Data JPA** - Making database queries feel like magic
- **H2 Database** - The Etch A Sketch of databases (shake to reset!)
- **Lombok** - Because nobody has time to write getters and setters
- **Maven** - Build tool of champions (fight me, Gradle users)

## 🚀 Getting Started (Let's Do This!)

### Prerequisites

- Java 17 (or higher, we're not judging)
- Maven (it's probably already on your machine, hiding)
- A burning desire to manage products

### Installation

```bash
# Clone this bad boy
git clone https://github.com/yourusername/ecom-proj.git

# Navigate into the project (you got this!)
cd ecom-proj

# Build with Maven (grab a coffee, this might take a moment)
mvn clean install

# Run the application (drums rolling...)
mvn spring-boot:run
```

The API will start on `http://localhost:8081` (because port 8080 was too mainstream).

## 📚 API Endpoints (Your New Best Friends)

### Product Management

| Method | Endpoint | Description | What It Actually Does |
|--------|----------|-------------|----------------------|
| `GET` | `/api/products` | Get all products | Returns everything. ALL OF IT. |
| `GET` | `/api/products/{id}` | Get product by ID | Find that one special product |
| `POST` | `/api/products` | Create new product | Birth a new product into existence |
| `PUT` | `/api/products/{id}` | Update product | Change your mind about things |
| `DELETE` | `/api/products/{id}` | Delete product | Send products to the shadow realm |
| `GET` | `/api/products/search?keyword=apple` | Search products | Find products like a detective |
| `GET` | `/api/products/{id}/image` | Get product image | Fetch those sweet, sweet bytes |

### Example Requests

**Create a Product (with multipart/form-data):**
```bash
curl -X POST http://localhost:8081/api/products \
  -F "product={\"name\":\"Super Gadget\",\"price\":99.99,\"brand\":\"TechCo\",\"category\":\"Electronics\",\"available\":true,\"quantity\":10};type=application/json" \
  -F "image=@/path/to/image.jpg"
```

**Search for Products:**
```bash
curl http://localhost:8081/api/products/search?keyword=apple
# Returns all products with "apple" in name, description, brand, or category
# (Yes, even if it's about actual apples)
```

**Get a Product:**
```bash
curl http://localhost:8081/api/products/1
# Returns that beautiful iPhone 15 Pro we seeded
```

## 🗄️ Database Schema

```sql
Product {
    id: Long (auto-generated, like my excuses)
    name: String (what is it?)
    description: String (what does it do?)
    brand: String (who made it?)
    price: Double (how much money will I cry over?)
    category: String (where does it belong?)
    releaseDate: Date (when was it born?)
    available: Boolean (can I actually buy it?)
    quantity: Integer (how many are left?)
    imageName: String (what's the file called?)
    imageType: String (image/jpeg? image/png?)
    image: byte[] (the actual pixels)
}
```

## 🎮 Sample Data

We've pre-loaded 15 products for your testing pleasure:
- 📱 Smartphones (iPhone, Samsung Galaxy)
- 💻 Laptops (MacBook Pro, Dell XPS)
- 🎧 Audio gear (Sony headphones, AirPods)
- 🎮 Gaming consoles (PS5, Xbox, Nintendo Switch)
- ⌚ Wearables (Apple Watch, Fitbit)
- 📷 And more!

## 🔧 Configuration

Check out `application.properties` for all the juicy configs:

```properties
server.port=8081                    # We're rebels
spring.datasource.url=jdbc:h2:mem:hemesh  # In-memory magic
spring.jpa.show-sql=true            # Watch the SQL flow by
```

## 🎯 Future Enhancements (The TODO List of Shame)

- [ ] Add proper exception handling (@ControllerAdvice, we're coming for you!)
- [ ] Implement pagination (because 1000 products in one response is... ambitious)
- [ ] Add authentication & authorization (currently anyone can delete everything 😅)
- [ ] Switch to a real database (PostgreSQL? MySQL? MongoDB? Oracle? JK, not Oracle)
- [ ] Add validation annotations (@Valid, @NotNull, all the good stuff)
- [ ] Write actual tests (I know, I know...)
- [ ] Add proper image content-type headers
- [ ] Implement DTOs (because exposing entities directly is living dangerously)

## 🐛 Known Issues

- The H2 database resets every time you restart (feature, not a bug!)
- No frontend (use Postman like the cool kids)
- Update method only updates images, not other fields (oops)

## 🤝 Contributing

Found a bug? Want to add a feature? Pull requests are welcome! Just remember:
1. Keep it clean
2. Keep it tested (aspirational, I know)
3. Keep it funny (most important)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

Translation: Do whatever you want with it. Build an empire. Make millions. Just remember me when you're rich.

## 👨‍💻 Author

Built with ☕, 🍕, and an unhealthy amount of Stack Overflow tabs.

## 🙏 Acknowledgments

- Coffee, for keeping me awake
- Stack Overflow, for keeping me employed
- Spring Boot, for making Java development bearable
- You, for actually reading this README

---

⭐ **If this project helped you, give it a star!** ⭐

*Or don't. I'm a README, not a cop.*