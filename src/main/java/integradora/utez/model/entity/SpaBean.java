package integradora.utez.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "Spa")
public class SpaBean {
    @Id
    @Column(name = "id_spa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_spa;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private String precio;
    @Column(name = "descuento", nullable = false)
    private Integer descuento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "spaBean")
    private Set<PaquetesBean> paquetesBeans = new HashSet<>();


}
