package org.example.trabajoclase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        // Verificar si ya hay datos en la tabla persona
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM persona", Integer.class);
        
        if (count == 0) {
            System.out.println("🔄 Inicializando datos de prueba...");
            
            // Leer y ejecutar el script import.sql
            ClassPathResource resource = new ClassPathResource("import.sql");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                
                StringBuilder sql = new StringBuilder();
                String line;
                
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    // Ignorar comentarios y líneas vacías
                    if (!line.isEmpty() && !line.startsWith("--")) {
                        sql.append(line).append(" ");
                        
                        // Si la línea termina con ';', ejecutar el comando
                        if (line.endsWith(";")) {
                            try {
                                jdbcTemplate.execute(sql.toString());
                                System.out.println("✅ Ejecutado: " + sql.toString().substring(0, Math.min(50, sql.length())) + "...");
                            } catch (Exception e) {
                                System.err.println("❌ Error ejecutando: " + sql.toString());
                                System.err.println("Error: " + e.getMessage());
                            }
                            sql.setLength(0);
                        }
                    }
                }
            }
            
            System.out.println("✅ Datos de prueba inicializados correctamente!");
        } else {
            System.out.println("ℹ️ Los datos ya existen en la base de datos. Se omite la inicialización.");
        }
    }
}
