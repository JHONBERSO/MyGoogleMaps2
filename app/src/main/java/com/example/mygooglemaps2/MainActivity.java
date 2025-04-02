package com.example.mygooglemaps2;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import kotlinx.coroutines.scheduling.Task;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    // Constante para identificar la solicitud del permiso de ubicación
    // Se puede usar cualquier valor entero
    private final int FINE_PERMISSION_CODE = 1;
    // Objeto que representa el mapa de Google
    private GoogleMap myMap;
    // Variable para almacenar la ubicación actual del usuario
    Location currentLocation;
    // Cliente que provee los servicios de ubicación de Google
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Configura la pantalla para usar todo el espacio, incluyendo áreas detrás de las barras del sistema
        EdgeToEdge.enable(this);

        // Establece el layout principal de la actividad
        setContentView(R.layout.activity_main);

        // Ajusta el padding de la vista para evitar que el contenido se solape con las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa el cliente para obtener la ubicación del dispositivo
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        // Llama al método para obtener la última ubicación conocida
        getLastLocation();

    }
    // Método para obtener la última ubicación del dispositivo
    private void getLastLocation() {
        // Comprueba si se tienen los permisos de ubicación necesarios
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Si no se tienen los permisos, se solicitan (en este caso, solo el de ubicación fina)
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, FINE_PERMISSION_CODE);
            return;
        }
        // Solicita la última ubicación conocida del dispositivo
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(task -> {
            if (task.isSuccessful()) { // Verifica si la tarea se completó con éxito
                currentLocation = task.getResult(); // Guarda la ubicación obtenida
                if (currentLocation != null) {
                    // Obtiene el fragmento del mapa definido en el layout y configura el callback
                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    mapFragment.getMapAsync(this);
                }
            }
        });
    }

    // Método llamado cuando el mapa ya está listo para ser manipulado
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap = googleMap; // Asigna el mapa a la variable global
        // Crea un objeto LatLng con la latitud y longitud de la ubicación actual
        LatLng uns = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        //Latitud y longitud de la Universidad Nacional de Salta
        //LatLng uns = new LatLng(-9.1211631,-78.5148755);
        // Añade un marcador en el mapa en la ubicación actual con el título "My Ubicación"
        myMap.addMarker(new MarkerOptions().position(uns).title("My Ubicación"));
        // Mueve la cámara del mapa hacia la ubicación del marcador
        myMap.moveCamera(CameraUpdateFactory.newLatLng(uns));
        // Aplica un zoom animado sobre el marcador para destacar la ubicación (nivel de zoom 15)
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(uns, 15));

    }

    // Método que recibe la respuesta del usuario sobre la solicitud de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FINE_PERMISSION_CODE) { // Verifica que la respuesta corresponda al permiso solicitado
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Si el permiso es concedido, se vuelve a intentar obtener la ubicación
                getLastLocation();
            } else {
                // Si el permiso es denegado, se muestra un mensaje de aviso
                Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}