📱 Capturas del proyecto - Agenda Gastronómica
![Imagen de WhatsApp 2025-07-22 a las 01 19 47_904893e2](https://github.com/user-attachments/assets/75d52bfd-1e68-41e0-8deb-8081a0bf0b0e)
Splash Screen: Implementada usando Handler y postDelayed para mostrar temporalmente una imagen de presentación antes de iniciar la actividad principal.

![Imagen de WhatsApp 2025-07-22 a las 01 19 47_a89e2d73](https://github.com/user-attachments/assets/19e4adb6-98d9-4087-81de-e7d0be125de1)
Pantalla de bienvenida: Interfaz diseñada con LinearLayout, centrando imagen y texto. Se utiliza un botón para navegar a la lista de restaurantes, implementando Intent.

![Imagen de WhatsApp 2025-07-22 a las 01 19 47_6275f9e7](https://github.com/user-attachments/assets/8c4fd66d-706d-4388-98ba-9ad2e15e8ece)
Listado de restaurantes: ListView con un adaptador personalizado (BaseAdapter) que muestra imagen, nombre y plato recomendado de cada restaurante con item_restaurant.xml.

![Imagen de WhatsApp 2025-07-22 a las 01 19 48_fef2a715](https://github.com/user-attachments/assets/e0b75476-20fc-4214-8c1e-71a2a339033b)
Detalle del restaurante: Muestra dinámicamente el nombre, plato recomendado e imagen del plato específico, gracias al uso de Intent y recursos drawable personalizados.

![Imagen de WhatsApp 2025-07-22 a las 01 19 48_a85fa6d8](https://github.com/user-attachments/assets/dc6d5e93-7fa6-4975-b479-1e9673945518)
Mapa con ubicación actual: Se integra SupportMapFragment y FusedLocationProviderClient para obtener y mostrar la ubicación del usuario en tiempo real con marcador.

![Imagen de WhatsApp 2025-07-22 a las 01 19 48_763c0cff](https://github.com/user-attachments/assets/1ec9bb28-c4c8-4a0f-b737-0dce2dce7542)
![Imagen de WhatsApp 2025-07-22 a las 01 19 49_017ffe10](https://github.com/user-attachments/assets/73b19bca-e2b0-4c1e-9e78-9c264fd1533d)
Marcadores de restaurantes: Cada restaurante tiene un Marker con title y snippet (plato recomendado). Al hacer clic en el marcador se abre Google Maps para navegación.


![Imagen de WhatsApp 2025-07-22 a las 01 20 21_59f2c7f8](https://github.com/user-attachments/assets/d54d4020-f12c-4b37-95d2-cdfd16dc5b0e)
![Imagen de WhatsApp 2025-07-22 a las 01 20 21_7addcd69](https://github.com/user-attachments/assets/5a01422d-e873-4166-bc3f-326392eedad8)
Botón de navegación “IR”: Lanza un Intent externo que abre Google Maps directamente a la ubicación del restaurante seleccionado (geo:lat,lng).
Mapa con BottomNavigation: Combinación de SupportMapFragment con BottomNavigationView permite navegación fluida entre vistas sin perder la vista del mapa.




