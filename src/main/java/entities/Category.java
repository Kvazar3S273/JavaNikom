package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Part> partList;

//    public Category() {
//    }
//
//    public Category(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
