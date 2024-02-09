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
@Table(name = "Paquetes")
public class  PaquetesBean {
    @Id
    @Column(name = "id_paquetes")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_paquetes;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "costo", nullable = false)
    private String costo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spa_id")
    private SpaBean spaBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante_id")
    private RestauranteBean restauranteBean;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "paquetesBean")
    private Set<HistorialBean> historialBeans = new HashSet<>();


}
