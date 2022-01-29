package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "tbl_parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(length = 200)
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(mappedBy = "projects")
    private Set<Shop> shops = new HashSet<>();

}