package com.whiskypedia.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Whisky")
public class WhiskyEntity {

    @Id
    @Column(name = "whisky_id")
    private String whiskyID;

    @NotNull
    @Size(max = 100)
    @Column(name = "whisky_name", nullable = false)
    private String whiskyName;

    @NotNull
    @Size(max = 100)
    @Column(name = "whisky_origin", nullable = false)
    private String whiskyOrigin;

    @Size(max = 100)
    @Column(name = "whisky_distiller")
    private String whiskyDistiller;

    @Size(max = 50)
    @Column(name = "whisky_type")
    private String whiskyType;

    @Size(max = 200)
    @Column(name = "whisky_flavour")
    private String whiskyFlavour;

    // @Size(max = 500)
    // @Column(name = "whisky_description")
    // private String whiskyDescription;

    // @Size(max = 200)
    // @Column(name = "whisky_image")
    // private String whiskyImage;

    // @OneToMany(mappedBy = "whisky", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<ReviewEntity> reviews;
}