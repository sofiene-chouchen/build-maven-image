package com.poly.gestioncatalogueg1.dao;

import com.poly.gestioncatalogueg1.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    public List<Produit> findByNomContains(String mc); //derived query
    @Query("Select p from Produit p where p.categorie.id= :x")
    public List<Produit> getProductsBYCat(@Param("x") Long idC);

}
