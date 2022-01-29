package entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200, nullable = false)
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tbl_shops_parts",
            joinColumns = { @JoinColumn(name = "shop_id") },
            inverseJoinColumns = { @JoinColumn(name = "part_id") }
    )
    Set<Part> parts = new HashSet<>();

}
