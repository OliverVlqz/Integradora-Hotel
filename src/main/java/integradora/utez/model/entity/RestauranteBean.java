package integradora.utez.model.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "Restaurante")
public class RestauranteBean {
    @Id
    @Column(name = "id_restaurante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_restaurante;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private String precio;
    @Column(name = "descuento", nullable = false)
    private int  descuento;
}
