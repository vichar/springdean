# Product Service API
End Point
- /products - get all product list
```json
[
  {
    id: 1,
    name: "Intel i7",
    type: "CPU",
    imageUrl: "https://i.ytimg.com/vi/mmHY8Kj4vCk/maxresdefault.jpg",
    description: "i7 7700k",
    price: 7000
  },
  {
    id: 2,
    name: "AMD Raizen 1700X",
    type: "CPU",
    imageUrl: "http://cdn.wccftech.com/wp-content/uploads/2017/02/AMD-Ryzen-CPU.png",
    description: "AMD 1700X",
    price: 3500
  },
  {
    id: 3,
    name: "Galax HOF GTX1080",
    type: "GPU",
    imageUrl: "https://www.custompcreview.com/wp-content/uploads/2016/05/29140448720l.jpg",
    description: "GTX 1080",
    price: 2350
  },
  {
    id: 4,
    name: "Raiden Plasma",
    type: "RAM",
    imageUrl: "https://i.ytimg.com/vi/SApyTXm_jQE/maxresdefault.jpg",
    description: "DDR4 32GB",
    price: 8872
  }
]
```
- /product/{id} - get product by id, if product doesn't exist API will return http code 404 
```json
{
  id: 1,
  name: "Intel i7",
  type: "CPU",
  imageUrl: "https://i.ytimg.com/vi/mmHY8Kj4vCk/maxresdefault.jpg",
  description: "i7 7700k",
  price: 7000
}
```