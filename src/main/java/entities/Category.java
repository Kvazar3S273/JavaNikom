package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "category_part",
            joinColumns = { @JoinColumn(referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "Id")})
    private List<Part> parts = new ArrayList<>();


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", partList=" + partList +
                '}';
    }
}
