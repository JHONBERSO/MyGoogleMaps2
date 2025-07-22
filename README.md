## 📱 Capturas del proyecto - Agenda Gastronómica

### 1. Splash Screen  
Implementada usando `Handler` y `postDelayed` para mostrar temporalmente una imagen de presentación antes de iniciar la actividad principal.  
![Splash Screen](https://github.com/user-attachments/assets/75d52bfd-1e68-41e0-8deb-8081a0bf0b0e)

---

### 2. Pantalla de bienvenida  
Interfaz diseñada con `LinearLayout`, centrando imagen y texto. Se utiliza un botón para navegar a la lista de restaurantes, implementando `Intent`.  
![Pantalla de bienvenida](https://github.com/user-attachments/assets/19e4adb6-98d9-4087-81de-e7d0be125de1)

---

### 3. Listado de restaurantes  
`ListView` con un adaptador personalizado (`BaseAdapter`) que muestra imagen, nombre y plato recomendado de cada restaurante con `item_restaurant.xml`.  
![Listado de restaurantes](https://github.com/user-attachments/assets/8c4fd66d-706d-4388-98ba-9ad2e15e8ece)

---

### 4. Detalle del restaurante  
Muestra dinámicamente el nombre, plato recomendado e imagen del plato específico, gracias al uso de `Intent` y recursos `drawable` personalizados.  
![Detalle del restaurante](https://github.com/user-attachments/assets/e0b75476-20fc-4214-8c1e-71a2a339033b)

---

### 5. Mapa con ubicación actual  
Se integra `SupportMapFragment` y `FusedLocationProviderClient` para obtener y mostrar la ubicación del usuario en tiempo real con marcador.  
![Mapa ubicación actual](https://github.com/user-attachments/assets/dc6d5e93-7fa6-4975-b479-1e9673945518)

---

### 6. Marcadores de restaurantes  
Cada restaurante tiene un `Marker` con `title` y `snippet` (plato recomendado). Al hacer clic en el marcador se abre Google Maps para navegación.  
![Marcador 1](https://github.com/user-attachments/assets/1ec9bb28-c4c8-4a0f-b737-0dce2dce7542)  
![Marcador 2](https://github.com/user-attachments/assets/73b19bca-e2b0-4c1e-9e78-9c264fd1533d)

---

### 7. Botón de navegación “IR” y navegación integrada  
- Botón “IR”: Lanza un `Intent` externo que abre Google Maps directamente a la ubicación del restaurante seleccionado (`geo:lat,lng`).  
- Mapa con `BottomNavigationView`: Combinación de `SupportMapFragment` con `BottomNavigationView` permite navegación fluida entre vistas sin perder el mapa.  
![Botón IR 1](https://github.com/user-attachments/assets/d54d4020-f12c-4b37-95d2-cdfd16dc5b0e)  
![Botón IR 2](https://github.com/user-attachments/assets/5a01422d-e873-4166-bc3f-326392eedad8)





